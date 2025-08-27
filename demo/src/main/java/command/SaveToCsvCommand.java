package command;

import service.CSVService;

public class SaveToCsvCommand implements Command {
    private final CSVService csvService = new CSVService();
    @Override
    public Long getId() {
        return 5L;
    }

    @Override
    public String getDescription() {
        return "Сохранить в CSV";
    }

    @Override
    public void execute() { csvService.saveToCsv(); }
}
