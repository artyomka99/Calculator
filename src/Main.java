import command.CalculatorCommand;
import command.Command;
import command.PersonComand;

import java.util.HashMap;
import java.util.Scanner;

public class Main {

    static HashMap<Long, Command> commands = new HashMap<>();

    static {
        Command calculator = commands.put(0L, new CalculatorCommand());
        Command person = commands.put(1L, new PersonComand());
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Выберите действие:");
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

