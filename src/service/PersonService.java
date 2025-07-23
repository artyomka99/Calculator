package service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.javafaker.Faker;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import entity.person.Person;
import entity.person.PersonCsvView;
import entity.pet.*;

import java.io.*;
import java.nio.file.Files;
import java.util.*;

public class PersonService {

    private final Scanner scanner = new Scanner(System.in);
    private final Faker faker = new Faker();
    private final Random random = new Random();
    private final List<Person> persons = new ArrayList<>();

    public PersonService() {
        this.persons.add(new Person());
    }
    public List<Person> getPersons() {
        return persons;
    }

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
