package service;

import com.github.javafaker.Faker;
import entity.person.Person;
import service.repository.PersonRepository;

import java.util.Random;
import java.util.Scanner;

public class PersonService {

    private final Scanner scanner = new Scanner(System.in);
    private final Faker faker = new Faker();
    private final Random random = new Random();
    private final PersonRepository personRepository = new PersonRepository();

    public void generatePersons() {
        System.out.print("Сколько людей хотите создать? ");
        int count = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < count; i++) {
            String name = faker.name().fullName();
            int age = random.nextInt(100) + 1;
            personRepository.save(new Person(name, age, null));
        }

        System.out.println("Люди успешно созданы!");
    }

    public void printPersons() {
        System.out.println("\nСписок людей:");
        int i = 1;
        for (Person person : personRepository.findAll()) {
            System.out.println((i++) + ". " + person);
        }
    }
}
