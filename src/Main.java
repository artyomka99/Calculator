import command.*;
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
        Command pet = commands.put(3L, new GeneratePet());
        Command saveToJson = commands.put(4L, new SaveToJsonCommand());
        Command saveToCsv = commands.put(5L, new SaveToCsvCommand());
        Command loadFromJson = commands.put(6L, new LoadFromJsonCommand());
        Command loadFromCsv = commands.put(7L, new LoadFromCsvCommand());
        Command printPerson = commands.put(8L, new PrintPersonCommand());
        Command printJsonFile = commands.put(9L, new PrintJsonCommand());
        Command printCsvFile = commands.put(10L, new PrintCsvCommand());
        Command printPet = commands.put(11L, new PrintePetCommand());
        Command petToPerson = commands.put(12L, new PetToPersonComannnd());
        Command findPet = commands.put(13L, new FindPetCommand());
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

