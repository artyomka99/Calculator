package com.example.demo.command;

import com.example.demo.service.PetService;

public class PetToPersonComannnd implements Command {
    private final PetService petService = new PetService();

    @Override
    public Long getId() {
        return 12L;
    }

    @Override
    public String getDescription() {
        return "Создание питомцев для людей";
    }

    @Override
    public void execute() {
        petService.assignPetsToPersons();
    }
}
