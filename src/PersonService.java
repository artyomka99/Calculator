import com.github.javafaker.Faker;

import java.util.*;

public class PersonService {

    private final Scanner scanner = new Scanner(System.in);
    private final Faker faker = new Faker();
    private final Random random = new Random();
    private final List<Person> persons = new ArrayList<>();

    public void generatePersons() {
        System.out.println("Сколько людей хотите создать?");
        int count = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < count; i++) {
            String name = faker.name().fullName();
            int age = random.nextInt(100) + 1;
            persons.add(new Person(name, age));
        }

        System.out.println("\nЛюди успешно созданы!");
        printPersons();
        assignPetsToPersons();
    }

    private void printPersons() {
        System.out.println("\n Список людей:");
        for (int i = 0; i < persons.size(); i++) {
            System.out.println((i + 1) + ". " + persons.get(i));
        }
    }

    private void assignPetsToPersons() {
        while (true) {

            System.out.print("\nВведите номер человека для назначения питомца (0 - выход): ");
            int index = scanner.nextInt();
            scanner.nextLine();

            if (index == 0) break;
            if (index < 1 || index > persons.size()) {
                System.out.println("Неверный номер.");
                continue;
            }

            Person person = persons.get(index - 1);

            System.out.println("Имя питомца: ");
            String petName = scanner.nextLine();


            System.out.println("Возраст питомца: ");
            int petAge = scanner.nextInt();
            scanner.nextLine();

            System.out.println("Порода питомца: ");
            String petBreed = scanner.nextLine();

            System.out.println("Тип питомца:");
            System.out.println("1 - Собака");
            System.out.println("2 - Кошка");
            System.out.println("3 - Мышь");
            System.out.println("4 - Крыса");
            int choice = scanner.nextInt();
            scanner.nextLine();

            Animal.Pet pet;
            switch (choice) {
                case 1 -> pet = new Animal.Dog(petName, petAge, petBreed);
                case 2 -> pet = new Animal.Cat(petName, petAge, petBreed);
                case 3 -> pet = new Animal.Mouse(petName, petAge, petBreed);
                case 4 -> pet = new Animal.Rat(petName, petAge, petBreed);
                default -> {
                    System.out.println("Неверный выбор.");
                    continue;
                }
            }

            person.setPet(pet);
            System.out.println("Питомец назначен!\n");
        }

        System.out.println("\nИтоговый список:");
        printPersons();
    }
}
