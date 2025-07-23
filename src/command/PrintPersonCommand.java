package command;

import service.PersonService;

public class PrintPersonCommand implements Command {
    private final PersonService personService;

    public PrintPersonCommand(PersonService personService) {
        this.personService = personService;
    }

    @Override
    public Long getId() {
        return 8L;
    }

    @Override
    public String getDescription() {
        return "Cписок людей";
    }

    @Override
    public void execute() {
        personService.printPersons();
    }
}
