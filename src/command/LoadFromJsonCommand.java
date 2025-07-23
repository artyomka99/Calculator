package command;

import entity.person.Person;
import service.JSONService;
import service.PersonService;

import java.util.List;

public class LoadFromJsonCommand implements Command {

    JSONService jsonService;

    public LoadFromJsonCommand(PersonService personService) {
        List<Person> persons = personService.getPersons();
        this.jsonService = new JSONService(persons);
    }

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
