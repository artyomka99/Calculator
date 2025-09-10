package com.example.demo.entity.person;

import com.example.demo.entity.pet.Pet;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "persons")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String name;

    @Column(nullable = false)
    private int age;

    @Transient
    private List<Pet> pets = new ArrayList<>();

    public Person(String name, int age, List<Pet> pets) {
        this.name = name;
        this.age = age;
        this.pets = pets;
    }

    public void addPet(Pet pet) {
        pets.add(pet);
    }

    @Override
    public String toString() {
        String petInfo = (pets != null) ? "Питомец: " + pets : "Без питомца";
        return name + " (возраст: " + age + ") — " + petInfo;
    }
}