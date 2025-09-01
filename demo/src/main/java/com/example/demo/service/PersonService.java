package com.example.demo.service;

import com.github.javafaker.Faker;
import com.example.demo.entity.person.Person;
import com.example.demo.repository.PersonRepository;
import org.springframework.stereotype.Service;

import java.util.Random;
import java.util.Scanner;

@Service
public class PersonService {

    private final Scanner scanner = new Scanner(System.in);
    private final Faker faker = new Faker();
    private final Random random = new Random();
    private final PersonRepository personRepository = PersonRepository.getInstance();



    public void generatePersons() {
        System.out.print("Сколько людей хотите создать? ");
        int count = scanner.nextInt();
        scanner.nextLine();
        generatePersonsWithCount(count);
    }

    public void generatePersonsWithCount(int count) {
        for (int i = 0; i < count; i++) {
            String name = faker.name().fullName();
            int age = random.nextInt(100) + 1;
            personRepository.save(new Person(name, age, null));
        }
    }

    public void printPersons() {
        System.out.println("\nСписок людей:");
        int i = 1;
        for (Person person : personRepository.findAll()) {
            System.out.println((i++) + ". " + person);
        }
    }
}
