package service;

import entity.person.Person;
import entity.pet.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class PetService {
    private final List<Pet> pets = new ArrayList<>();
    private final List<Person> persons = PersonService.persons;
    private final Scanner scanner = new Scanner(System.in);
    private final PersonService personService = new PersonService();

    private final String[] names = {"Барсик", "Мурка", "Шарик", "Том", "Лаки", "Рекс", "Снежок", "Рыжик"};
    private final String[] breeds = {"Сиамский", "Бульдог", "Мейн-кун", "Доберман", "Сфинкс", "Дворовый"};
    private final Random random = new Random();

    public void generatePets() {
        System.out.print("Сколько питомцев хотите создать? ");
        int count = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < count; i++) {
            String petName = names[random.nextInt(names.length)];
            int petAge = random.nextInt(15) + 1;
            String petBreed = breeds[random.nextInt(breeds.length)];
            int type = random.nextInt(4) + 1;

            Pet pet = switch (type) {
                case 1 -> new Dog(petName, petAge, petBreed);
                case 2 -> new Cat(petName, petAge, petBreed);
                case 3 -> new Mouse(petName, petAge, petBreed);
                case 4 -> new Rat(petName, petAge, petBreed);
                default -> null;
            };

            if (pet != null) {
                pets.add(pet);
            }
        }
        System.out.println(count + " питомцев создано.");
    }

    public void printAllPets() {
        if (pets.isEmpty()) {
            System.out.println("Список питомцев пуст.");
            return;
        }

        System.out.println("\nВсе питомцы:");
        for (int i = 0; i < pets.size(); i++) {
            System.out.printf("%d. %s%n", i + 1, pets.get(i));
        }
    }

    public void assignPetsToPersons() {
        if (pets.isEmpty()) {
            System.out.println("Сначала создайте питомцев.");
            return;
        }

        if (persons.isEmpty()) {
            System.out.println("Сначала создайте людей.");
            return;
        }

        for (Pet pet : pets) {
            Person person = persons.get(random.nextInt(persons.size()));
            person.addPet(pet);
            System.out.printf("Питомец %s назначен %s%n", pet.getName(), person.getName());
        }

        pets.clear();
        System.out.println("Все питомцы назначены.");
    }

    public void findPetsByParams() {
        System.out.print("Введите имя (или пусто): ");
        String name = scanner.nextLine().trim();

        System.out.print("Введите возраст (или пусто): ");
        String ageInput = scanner.nextLine().trim();
        Integer age = ageInput.isEmpty() ? null : Integer.parseInt(ageInput);

        System.out.print("Введите породу (или пусто): ");
        String breed = scanner.nextLine().trim();

        List<Pet> found = new ArrayList<>();

        for (Person person : persons) {
            for (Pet pet : person.getPets()) {
                boolean matches =
                        (name.isEmpty() || pet.getName().equalsIgnoreCase(name)) &&
                                (age == null || pet.getAge() == age) &&
                                (breed.isEmpty() || pet.getBreed().equalsIgnoreCase(breed));

                if (matches) {
                    found.add(pet);
                }
            }
        }

        if (found.isEmpty()) {
            System.out.println("Ничего не найдено.");
        } else {
            System.out.println("Результаты поиска:");
            found.forEach(System.out::println);
        }
    }
}
