package command;

import service.PersonService;

public class PersonComand implements Command {

    private final PersonService personService = new PersonService();

    @Override
    public Long getId() {
        return 1L;
    }

    @Override
    public String getDescription() {
        return "Создание людей и их характеристик";
    }

    @Override
    public void execute() {
        personService.generatePersons();
    }
}
