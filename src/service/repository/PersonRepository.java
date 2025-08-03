package service.repository;

import entity.person.Person;

import java.util.ArrayList;
import java.util.List;

public class PersonRepository {
    private final List<Person> persons = new ArrayList<>();

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
