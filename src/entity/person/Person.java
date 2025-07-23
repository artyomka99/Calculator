package entity.person;

import entity.pet.Pet;

public class Person {
    private String name;
    private int age;
    private Pet pet;

    public Person() {
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }

    public Pet getPet() {
        return pet;
    }

    @Override
    public String toString() {
        String petInfo = (pet != null) ? "Питомец: " + pet : "Без питомца";
        return name + " (возраст: " + age + ") — " + petInfo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}


