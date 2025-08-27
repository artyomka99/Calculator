package command;

import lombok.Data;
import service.CalculatorService;

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
