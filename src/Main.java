import command.Command;
import service.PersonService;
import service.PetService;
import org.reflections.Reflections;

import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;


public class Main {

    static HashMap<Long, Command> commands = new HashMap<>();
    static PersonService personService = new PersonService();
    static PetService petService = new PetService();

    static {
        try {
            Reflections reflections = new Reflections("command");
            Set<Class<? extends Command>> commandClasses = reflections.getSubTypesOf(Command.class);

            for (Class<? extends Command> clazz : commandClasses) {
                if (!Modifier.isAbstract(clazz.getModifiers())) {
                    try {
                        Command command = clazz.getDeclaredConstructor().newInstance();
                        commands.put(command.getId(), command);
                    } catch (Exception e) {
                        System.out.println("Не удалось создать экземпляр команды: " + clazz.getSimpleName()
                                + ". Проверьте наличие дефолтного конструктора.");
                    }
                }
            }
            if (commands.isEmpty()) {
                System.out.println("Команды не найдены. Проверьте пакет command и классы команд.");
            }
        } catch (Exception e) {
            System.out.println("Ошибка при инициализации команд: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\nВыберите действие:");
            commands.forEach((key, command) ->
                    System.out.println(key + ": " + command.getDescription())
            );
            System.out.println("Введите номер команды:");
            Long commandId = scanner.nextLong();
            Command command = commands.get(commandId);
            if (command != null) {
                command.execute();
            } else {
                System.out.println("Команда не найдена");
            }
        }
    }
}

