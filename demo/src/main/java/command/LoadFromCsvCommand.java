package command;

import service.CSVService;

public class LoadFromCsvCommand implements Command {
    private final CSVService csvService = new CSVService();
    @Override
    public Long getId() {
        return 7L;
    }

    @Override
    public String getDescription() {
        return "Загрузить из CSV";
    }

    @Override
    public void execute() { csvService.loadFromCsv(); }
}
