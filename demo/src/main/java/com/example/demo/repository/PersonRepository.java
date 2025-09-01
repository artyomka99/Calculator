package com.example.demo.repository;

import com.example.demo.entity.person.Person;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class PersonRepository {
    private static PersonRepository instance;
    private final List<Person> persons = new ArrayList<>();
    private Long nextId = 1L;

    private PersonRepository() {
    }

    public static synchronized PersonRepository getInstance() {
        if (instance == null) {
            instance = new PersonRepository();
        }
        return instance;
    }

    public void save(Person person) {
        if (person.getId() == null){
            person.setId(nextId++);
        }
        persons.add(person);
    }

    public List<Person> findAll() {
        return new ArrayList<>(persons);
    }

    public Person findById(Long id) {
        for (Person person :persons) {
            if (person != null && person.getId().equals(id)) {
                return person;
            }
        }
        return null;
    }
    public boolean deleteById(Long id) {
        return persons.removeIf(person ->
                person != null && person.getId().equals(id)
        );
    }

    public void clear() {
        persons.clear();
    }

    public int count() {
        return persons.size();
    }
}
