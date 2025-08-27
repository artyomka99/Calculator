package com.example.demo.command;

import com.example.demo.service.JSONService;

public class SaveToJsonCommand implements Command {
    private final JSONService jsonService = new JSONService();

    @Override
    public Long getId() {
        return 4L;
    }

    @Override
    public String getDescription() {
        return "Сохранить в JSON";
    }

    @Override
    public void execute() {
        jsonService.saveToJson();
    }
}
