package command;

import service.CSVService;

public class PrintCsvCommand implements Command {
    CSVService csvService = new CSVService();
    @Override
    public Long getId() {
        return 10L;
    }

    @Override
    public String getDescription() {
        return "Показать CSV-файла";
    }

    @Override
    public void execute() { csvService.printCsvFile(); }
}
