package com.example.demo.command;

import lombok.Data;
import com.example.demo.service.CalculatorService;

@Data
public class CalculatorCommand implements Command {

    private final CalculatorService calculatorService = new CalculatorService();

    @Override
    public Long getId() {
        return 1L;
    }

    @Override
    public String getDescription() {
        return "Калькулятор";
    }

    @Override
    public void execute() {
        calculatorService.startCalculator();
    }
}
