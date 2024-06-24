import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        Calculator calc = new Calculator();
        Command command = new Command();

        while (true){
            System.out.println("1. Calculator");
            System.out.println("2. Command");
            System.out.println("3. Exit");
            System.out.println("Enter your choice: ");
            int choice = scan.nextInt();
            switch(choice){
                case 1:
                    System.out.println(calc.result());
                    break;
                case 2:
                    String name = command.setName();
                    command.command(name);
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
