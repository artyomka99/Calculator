package command;

import service.PersonService;

public class PersonCommand implements Command {

    private final PersonService personService;

    public PersonCommand(PersonService personService) {
        this.personService = personService;
    }

    @Override
    public Long getId() {
        return 2L;
    }

    @Override
    public String getDescription() {
        return "Создание людей";
    }

    @Override
    public void execute() {
        personService.generatePersons();
    }
}
