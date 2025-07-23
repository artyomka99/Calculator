package command;

import entity.person.Person;
import service.JSONService;
import service.PersonService;

import java.util.List;

public class PrintJsonCommand implements Command {
    JSONService jsonService;
    public PrintJsonCommand(PersonService personService) {
        List<Person> persons = personService.getPersons();
        this.jsonService = new JSONService(persons);
    }


    @Override
    public Long getId() {
        return 9L;
    }

    @Override
    public String getDescription() {
        return "Показать JSON-файл";
    }

    @Override
    public void execute() {
        jsonService.printJsonFile();
    }
}
