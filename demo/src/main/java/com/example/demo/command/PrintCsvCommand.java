package com.example.demo.command;

import com.example.demo.service.CSVService;

public class PrintCsvCommand implements Command {
    private final CSVService csvService = new CSVService();
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
