import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Calculator calc = new Calculator();
        PersonManager pm = new PersonManager();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Calculator");
            System.out.println("2. People");
            System.out.println("3. Exit");
            System.out.println("Enter your choice: ");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.println(calc.result());
                    break;
                case 2:
                    System.out.println(pm.listPeople());
                    break;
                case 3:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Enter correct choice");
            }
        }
    }
}