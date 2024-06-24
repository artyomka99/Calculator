import java.util.ArrayList;
import java.util.Scanner;

public class Command {

    Scanner scan = new Scanner(System.in);
    Person person = new Person();

    private ArrayList<Person> people = new ArrayList<>();

    public void addPerson() {
        people.add(person);
    }

    public void displayPeople() {
        if (people.isEmpty()) {
            System.out.println("No people found");
        } else {
            for (Person person : people) {
                System.out.println(person);
            }
        }
    }

    public String setName() {
        System.out.print("Please enter name for the command: ");
        String name = scan.nextLine();
        return name;
    }
    public void searchPeopleByName(String searchName) {
        boolean found = false;
        for (Person person : people) {
            if (person.getName().toLowerCase().contains(searchName.toLowerCase())) {
                System.out.println(person);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No matches found for: " + searchName);
        }
    }

    public String command(String name) {
        while (true) {
            System.out.println("1. Add a new person to the command ");
            System.out.println("2. See a list of commands");
            System.out.println("3. Search for matches");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scan.nextInt();
            switch (choice) {
                case 1:
                    person.setdata();
                    addPerson();
                    break;
                case 2:
                    System.out.println("Command name: " + name);
                    displayPeople();
                    break;
                case 3:
                    System.out.println("Enter name to be searched: ");
                    String searchName = scan.nextLine();
                    searchName = scan.nextLine();
                    searchPeopleByName(searchName);
                    break;
                case 4:
                    return "Exiting program";
                default:
                    System.out.println("Invalid choice. Try again");
            }
        }
    }

    public String getUserInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a substring to search for: ");
        String input = scanner.nextLine();
        scanner.close();
        return input;
    }
}