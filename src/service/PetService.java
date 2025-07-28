package service;

import entity.person.Person;
import entity.pet.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PetService {
    private final List<Person> persons = PersonService.persons;
    private final Scanner scanner = new Scanner(System.in);
    private final PersonService personService = new PersonService();

    public void assignPetsToPersons() {
        if (persons.isEmpty()) {
            System.out.println("Сначала создайте людей.");
            return;
        }

        assignPetsLoop:
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

            System.out.print("Имя питомца: ");
            String petName = scanner.nextLine();

            System.out.print("Возраст питомца: ");
            int petAge = scanner.nextInt();
            scanner.nextLine();

            System.out.print("Порода питомца: ");
            String petBreed = scanner.nextLine();

            System.out.println("Тип питомца:");
            System.out.println("1 - Собака");
            System.out.println("2 - Кошка");
            System.out.println("3 - Мышь");
            System.out.println("4 - Крыса");

            int choice = scanner.nextInt();
            scanner.nextLine();

            Pet pet;
            switch (choice) {
                case 1 -> pet = new Dog(petName, petAge, petBreed);
                case 2 -> pet = new Cat(petName, petAge, petBreed);
                case 3 -> pet = new Mouse(petName, petAge, petBreed);
                case 4 -> pet = new Rat(petName, petAge, petBreed);
                default -> {
                    System.out.println("Неверный выбор.");
                    continue assignPetsLoop;
                }
            }

            person.setPet(pet);
            System.out.println("Питомец назначен!");
        }

        System.out.println("\nИтоговый список:");
        personService.printPersons();
    }
}
