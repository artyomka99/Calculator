package com.example.demo.repository;

import com.example.demo.entity.person.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonJpaRepository extends JpaRepository<Person, Long> {
    List<Person> findByAge(int age);
    List<Person> findByNameContainingIgnoreCase(String name);
    List<Person> findByAgeBetween(int minAge, int maxAge);
}