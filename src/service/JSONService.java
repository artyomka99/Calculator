package service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import entity.person.Person;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

public class JSONService {
    private final ObjectMapper objectMapper = new ObjectMapper();
    private final String JSON_FILE = "persons.json";
    private final List<Person> persons = PersonService.persons;

    public void saveToJson() {
        try {
            objectMapper.writerWithDefaultPrettyPrinter().writeValue(new File(JSON_FILE), persons);
            System.out.println("Сохранено в JSON.");
        } catch (IOException e) {
            System.out.println("Ошибка при сохранении JSON: " + e.getMessage());
        }
    }
    public void loadFromJson() {
        try {
            File file = new File(JSON_FILE);
            if (file.exists()) {
                persons.clear();
                persons.addAll(objectMapper.readValue(file, new TypeReference<>() {}));
                System.out.println("Загружено из JSON.");
            } else {
                System.out.println("Файл JSON не найден.");
            }
        } catch (IOException e) {
            System.out.println("Ошибка при чтении JSON: " + e.getMessage());
        }
    }
    public void printJsonFile() {
        try {
            System.out.println(Files.readString(new File(JSON_FILE).toPath()));
        } catch (IOException e) {
            System.out.println("Ошибка чтения JSON.");
        }
    }
}
