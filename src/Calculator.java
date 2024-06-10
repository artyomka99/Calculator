import java.util.Scanner;

public class Calculator {
    Scanner scan  = new Scanner(System.in);

    public String result () {
        System.out.println("Enter the number one:");
        float num1 = scan.nextFloat();
        System.out.println("Enter the number two:");
        float num2 = scan.nextFloat();
        System.out.println("Enter the action:");
        String action = scan.nextLine();
        action = scan.nextLine();

        float result = calculator(num1, num2, action);
        System.out.println("Result: " + result);

        System.out.println("Do you want to do more actions?");
        if (scan.nextLine().equalsIgnoreCase("yes")) {
            System.out.println("Enter the number");
            float num3 = scan.nextFloat();
            System.out.println("Enter the action:");
            action = scan.nextLine();
            action = scan.nextLine();
            result = calculator(num3, result, action);
        } else {
            System.out.println("Goodbye");
        }
        return "Result: " + result;
    }
    private float res;


    public float addition(float num1, float num2) {
        res = num1 + num2;
        return res;
    }
    public float deduction(float num1, float num2) {
        res = num1 - num2;
        return res;
    }
    public float multiplication(float num1, float num2) {
        res = num1 * num2;
        return res;
    }
    public float division(float num1, float num2) {
        if (num2 == 0) {
            System.out.println("You can't divide by zero");;
        }else {
            res = num1 / num2;
        }
        return res;
    }


    public float calculator (float num1, float num2, String action) {
//        super.setValuesNum(num1, num2, action);
        switch (action){
            case "+":
                return addition(num1, num2);
            case "-":
                return deduction(num1, num2);
            case "*":
                return multiplication(num1, num2);
            case "/":
                return division(num1, num2);
            default:
                System.out.println("Enter the correct action");
        }
        return 0;
    }
}
