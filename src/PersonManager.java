import java.util.ArrayList;
import java.util.Scanner;

class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", Age: " + age;
    }
}

public class PersonManager {
    private static ArrayList<Person> people = new ArrayList<>();

    public static void addPerson(String name, int age) {
        people.add(new Person(name, age));
    }

    public static void displayPeople() {
        if (people.isEmpty()) {
            System.out.println("No people created yet.");
        } else {
            for (Person person : people) {
                System.out.println(person);
            }
        }
    }

    public static String listPeople() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Create a new person");
            System.out.println("2. Display all people");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter age: ");
                    int age = scanner.nextInt();
                    addPerson(name, age);
                    break;
                case 2:
                    displayPeople();
                    break;
                case 3:
                    return "Exiting...";
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}