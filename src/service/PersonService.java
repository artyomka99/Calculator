package service;

import com.github.javafaker.Faker;
import entity.person.Person;

import java.util.*;

public class PersonService {

    private final Scanner scanner = new Scanner(System.in);
    private final Faker faker = new Faker();
    private final Random random = new Random();
    public static List<Person> persons = new ArrayList<>();

    public void generatePersons() {
        System.out.print("Сколько людей хотите создать? ");
        int count = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < count; i++) {
            String name = faker.name().fullName();
            int age = random.nextInt(100) + 1;
            persons.add(new Person(name, age));
        }

        System.out.println("Люди успешно созданы!");
    }

    public void printPersons() {
        System.out.println("\nСписок людей:");
        for (int i = 0; i < persons.size(); i++) {
            System.out.println((i + 1) + ". " + persons.get(i));
        }
    }
}
