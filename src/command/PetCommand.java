package command;

import entity.person.Person;
import entity.pet.Pet;
import service.PersonService;
import service.PetService;

public class PetCommand implements Command {
    private final PetService petService = new PetService();

    @Override
    public Long getId() {
        return 3L;
    }

    @Override
    public String getDescription() {
        return "Управление питомцами";
    }

    @Override
    public void execute() {
        petService.assignPetsToPersons();
    }
}
