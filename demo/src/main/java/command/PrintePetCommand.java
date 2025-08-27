package command;

import service.PetService;

public class PrintePetCommand implements Command {
    private final PetService petService = new PetService();
    @Override
    public Long getId() {
        return 11L;
    }

    @Override
    public String getDescription() {
        return "Показать список питомцев";
    }

    @Override
    public void execute() {
        petService.printAllPets();
    }
}
