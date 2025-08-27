package repository;

import entity.person.Person;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter @Setter
public class PersonRepository {
    private static PersonRepository instance;

    private final List<Person> persons = new ArrayList<>();

    private PersonRepository() { }

    public static synchronized PersonRepository getInstance() {
        if (instance == null) {
            instance = new PersonRepository();
        }
        return instance;
    }

    public void save(Person person) {
        persons.add(person);
    }

    public List<Person> findAll() {
        return new ArrayList<>(persons);
    }

    public void clear() {
        persons.clear();
    }

    public int count() {
        return persons.size();
    }
}
