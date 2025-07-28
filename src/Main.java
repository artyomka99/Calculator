import command.CalculatorCommand;
import command.Command;
import command.PersonCommand;
import command.PetCommand;
import service.PersonService;
import service.PetService;

import java.util.HashMap;
import java.util.Scanner;

public class Main {

    static HashMap<Long, Command> commands = new HashMap<>();
    static PersonService personService = new PersonService();
    static PetService petService = new PetService();
    static {
        Command calculator = commands.put(1L, new CalculatorCommand());
        Command person = commands.put(2L, new PersonCommand());
        Command pet = commands.put(3L, new PetCommand());
        Command saveToJson = commands.put(4L, new command.SaveToJsonCommand());
        Command saveToCsv = commands.put(5L, new command.SaveToCsvCommand());
        Command loadFromJson = commands.put(6L, new command.LoadFromJsonCommand());
        Command loadFromCsv = commands.put(7L, new command.LoadFromCsvCommand());
        Command printPerson = commands.put(8L, new command.PrintPersonCommand());
        Command printJsonFile = commands.put(9L, new command.PrintJsonCommand());
        Command printCsvFile = commands.put(10L, new command.PrintCsvCommand());
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

