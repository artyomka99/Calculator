import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        PersonService personService = new PersonService();
        CalculatorService calculatorService = new CalculatorService();
        Scanner scanner = new Scanner(System.in);

        System.out.print("Выберите действие: \n1 - Работа с людьми \n2 - Калькулятор \nВаш выбор: ");
        String choice = scanner.nextLine();

        switch (choice) {
            case "1":
                personService.generatePersons();
                break;
            case "2":
                calculatorService.startCalculator();
                break;
            default:
                System.out.println("Неверный выбор. Пожалуйста, попробуйте снова.");
        }
    }
}
