package command;

import entity.person.Person;
import service.JSONService;
import service.PersonService;

import java.util.List;

public class SaveToJsonCommand implements Command {
    JSONService jsonService = new JSONService();

    @Override
    public Long getId() {
        return 4L;
    }

    @Override
    public String getDescription() {
        return "Сохранить в JSON";
    }

    @Override
    public void execute() {
        jsonService.saveToJson();
    }
}
