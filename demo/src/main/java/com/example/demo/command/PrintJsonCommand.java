package com.example.demo.command;

import com.example.demo.service.JSONService;

public class PrintJsonCommand implements Command {
    private final JSONService jsonService = new JSONService();


    @Override
    public Long getId() {
        return 9L;
    }

    @Override
    public String getDescription() {
        return "Показать JSON-файл";
    }

    @Override
    public void execute() {
        jsonService.printJsonFile();
    }
}
