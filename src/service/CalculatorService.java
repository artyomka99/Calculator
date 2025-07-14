package service;

import java.util.Scanner;

public class CalculatorService {
    public void startCalculator() {
        Scanner scanner = new Scanner(System.in);
        double result;
        boolean continueOperation = true;

        while (continueOperation) {
            System.out.print("Введите первое число: ");
            double num1 = scanner.nextDouble();

            System.out.print("Введите второе число: ");
            double num2 = scanner.nextDouble();

            System.out.print("Выберите операцию (+, -, *, /): ");
            char operation = scanner.next().charAt(0);

            switch (operation) {
                case '+':
                    result = num1 + num2;
                    break;
                case '-':
                    result = num1 - num2;
                    break;
                case '*':
                    result = num1 * num2;
                    break;
                case '/':
                    if (num2 == 0) {
                        System.out.println("Ошибка: деление на ноль.");
                        continue;
                    }
                    result = num1 / num2;
                    break;
                default:
                    System.out.println("Неверная операция.");
                    continue;
            }

            System.out.println("Результат: " + result);

            System.out.print("Хотите выполнить операцию над результатом? (да/нет): ");
            String answer = scanner.next();

            if (answer.equalsIgnoreCase("да")) {
                num1 = result;
                System.out.print("Введите новое число: ");
                num2 = scanner.nextDouble();

                System.out.print("Выберите операцию (+,-, *, /): ");
                operation = scanner.next().charAt(0);

                switch (operation) {
                    case '+':
                        result = num1 + num2;
                        break;
                    case '-':
                        result = num1 - num2;
                        break;
                    case '*':
                        result = num1 * num2;
                        break;
                    case '/':
                        if (num2 == 0) {
                            System.out.println("Ошибка: деление на ноль.");
                            continue;
                        }
                        result = num1 / num2;
                        break;
                    default:
                        System.out.println("Неверная операция.");
                        continue;
                }

                System.out.println("Новый результат: " + result);
            }

            System.out.print("Хотите начать заново? (да/нет): ");
            String again = scanner.next();
            continueOperation = again.equalsIgnoreCase("да");
        }
        System.out.println("Программа завершена.");
        scanner.close();
    }
}
