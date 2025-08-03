package command;

import service.PetService;

public class GeneratePet implements Command {
    private final PetService petService = new PetService();

    @Override
    public Long getId() {
        return 3L;
    }

    @Override
    public String getDescription() {
        return "Создание питомцев";
    }

    @Override
    public void execute() {
        petService.generatePets();
    }
}
