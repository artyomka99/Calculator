package command;

import service.PetService;

public class FindPetCommand implements Command {
    private final PetService petService = new PetService();

    @Override
    public Long getId() {
        return 13L;
    }

    @Override
    public String getDescription() {
        return "Поиск питомца";
    }

    @Override
    public void execute() {
        petService.findPetsByParams();
    }
}
