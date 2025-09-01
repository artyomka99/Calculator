package com.example.demo.controller;

import com.example.demo.entity.person.Person;
import com.example.demo.repository.PersonRepository;
import com.example.demo.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class PersonController {
    private final PersonRepository repo = PersonRepository.getInstance();

    @Autowired
    private PersonService personService;

    @GetMapping("/persons/{id}")
    public ResponseEntity<Person> getPerson(@PathVariable Long id) {

        Person person = repo.findById(id);

        if (person == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(person);
    }
    @GetMapping("/persons/search")
    public List<Person> searchPersons(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) Integer minAge,
            @RequestParam(required = false) Integer maxAge) {

        return repo.findAll().stream()
                .filter(p -> name == null || p.getName().toLowerCase().contains(name.toLowerCase()))
                .filter(p -> minAge == null || p.getAge() >= minAge)
                .filter(p -> maxAge == null || p.getAge() <= maxAge)
                .toList();
    }
    @GetMapping("/persons")
    public List<Person> getAllPersons() {
        return repo.findAll();
    }
    @DeleteMapping("/persons/{id}")
    public ResponseEntity<String> deletePerson(@PathVariable Long id) {
        boolean deleted = repo.deleteById(id);

        if (deleted) {
            return ResponseEntity.ok("Человек с ID " + id + " удален");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @PostMapping("/persons")
    public ResponseEntity<Person> createPerson(@RequestBody Person person) {
        repo.save(person);
        return ResponseEntity.status(201).body(person);
    }
    @PostMapping("/persons/generate/{count}")
    public String generatePerson(@PathVariable int count) {
        personService.generatePersonsWithCount(count);
        return "Создано " + count + " человек";
    }
    @PutMapping("/persons/{id}")
    public ResponseEntity<Person> updatePerson(@PathVariable Long id,
                                               @RequestBody Person updatedPerson) {
        Person existing = repo.findById(id);
        if (existing == null) {
            return ResponseEntity.notFound().build();
        }
        existing.setName(updatedPerson.getName());
        existing.setAge(updatedPerson.getAge());
        return ResponseEntity.ok(existing);
    }
}
