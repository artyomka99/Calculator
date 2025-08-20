package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Calculator {

        private double lastResult = 0; // хранение последнего результата
        private boolean hasLastResult = false;

        // GET /calc?num=5&op=+
        @GetMapping("/calc")
        public String calculate(
                @RequestParam double num,
                @RequestParam String op,
                @RequestParam(required = false) Boolean reset
        ) {
                if (reset != null && reset) {
                        lastResult = 0;
                        hasLastResult = false;
                        return "Калькулятор сброшен.";
                }

                double num1 = hasLastResult ? lastResult : num;
                double num2 = hasLastResult ? num : 0;
                double result;

                switch (op) {
                        case "+":
                                result = hasLastResult ? num1 + num2 : num;
                                break;
                        case "-":
                                result = hasLastResult ? num1 - num2 : -num;
                                break;
                        case "*":
                                result = hasLastResult ? num1 * num2 : num;
                                break;
                        case "/":
                                if (hasLastResult && num2 == 0) return "Ошибка: деление на ноль!";
                                result = hasLastResult ? num1 / num2 : num;
                                break;
                        default:
                                return "Неверная операция. Используй +, -, *, /";
                }

                lastResult = result;
                hasLastResult = true;

                return "Результат: " + result;
        }

        // GET /reset - сброс калькулятора
        @GetMapping("/reset")
        public String resetCalculator() {
                lastResult = 0;
                hasLastResult = false;
                return "Калькулятор сброшен.";
        }
}
