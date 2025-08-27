package com.example.demo.command;

import com.example.demo.service.JSONService;

public class LoadFromJsonCommand implements Command {
    private final JSONService jsonService = new JSONService();

    @Override
    public Long getId() {
        return 6L;
    }

    @Override
    public String getDescription() {
        return "Загрузить из JSON";
    }

    @Override
    public void execute() {
        jsonService.loadFromJson();
    }
}
