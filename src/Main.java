import java.util.Scanner;

public class Main extends Calculator {
    public static void main(String[] args) {
        Scanner scan  = new Scanner(System.in);
        Calculator calc = new Calculator();

        System.out.println("Enter the number one:");
        float num1 = scan.nextFloat();
        System.out.println("Enter the number two:");
        float num2 = scan.nextFloat();
        System.out.println("Enter the action:");
        String action = scan.nextLine();
        action = scan.nextLine();

        float result = calc.calculator(num1, num2, action);
        System.out.println(calc.result());

        System.out.println("Do you want to do more actions?");
        if (scan.nextLine().equalsIgnoreCase("yes")) {
            System.out.println("Enter the number");
            float num3 = scan.nextFloat();
            System.out.println("Enter the action:");
            action = scan.nextLine();
            action = scan.nextLine();
            result = calc.calculator(num3, result, action);
            System.out.println(calc.result());
        }else {
            System.out.println("Goodbye");
        }
    }
}
