package command;

import service.CalculatorService;

public class CalculatorCommand implements Command {

    private final CalculatorService calculatorService = new CalculatorService();

    @Override
    public Long getId() {
        return 0L;
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
