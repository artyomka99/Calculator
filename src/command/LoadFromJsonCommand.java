package command;

import entity.person.Person;
import service.JSONService;
import service.PersonService;

import java.util.List;

public class LoadFromJsonCommand implements Command {
    private final JSONService jsonService = new JSONService();

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
