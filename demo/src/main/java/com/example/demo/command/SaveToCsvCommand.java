package com.example.demo.command;

import com.example.demo.service.CSVService;

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
