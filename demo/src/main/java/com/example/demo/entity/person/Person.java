package com.example.demo.entity.person;

import com.example.demo.entity.pet.Pet;
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
public class Person {
    private Long id;
    private String name;
    private int age;
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