package service;

import org.springframework.stereotype.Service;
import org.reflections.Reflections;

import command.Command;

import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

@Service
public class CommandService {

    private final Map<Long, Command> commands = new HashMap<>();
    private final PersonService personService;
    private final PetService petService;

    public CommandService(PersonService personService, PetService petService) {
        this.personService = personService;
        this.petService = petService;
        loadCommands();
    }

    private void loadCommands() {
        try {
            Reflections reflections = new Reflections("command");
            Set<Class<? extends Command>> commandClasses = reflections.getSubTypesOf(Command.class);

            for (Class<? extends Command> clazz : commandClasses) {
                if (!Modifier.isAbstract(clazz.getModifiers())) {
                    try {
                        Command command = clazz.getDeclaredConstructor().newInstance();
                        commands.put(command.getId(), command);
                    } catch (Exception e) {
                        System.err.println("Не удалось создать команду: " + clazz.getSimpleName());
                    }
                }
            }

            if (commands.isEmpty()) {
                System.out.println("Команды не найдены");
            }
        } catch (Exception e) {
            System.err.println("Ошибка при загрузке команд: " + e.getMessage());
        }
    }

    public void startCommandLoop() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nВыберите действие:");
            commands.forEach((key, command) ->
                    System.out.println(key + ": " + command.getDescription())
            );
            System.out.println("0: Выход");
            System.out.println("Введите номер команды:");

            try {
                Long commandId = scanner.nextLong();

                if (commandId == 0) {
                    System.out.println("До свидания!");
                    System.exit(0);
                }

                Command command = commands.get(commandId);
                if (command != null) {
                    command.execute();
                } else {
                    System.out.println("Команда не найдена");
                }
            } catch (Exception e) {
                System.out.println("Ошибка ввода");
                scanner.nextLine();
            }
        }
    }
}