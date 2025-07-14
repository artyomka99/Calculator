package entity.person;

import entity.pet.Pet;

public class Person {
    private final String name;
    private final int age;
    private Pet pet;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
    public void setPet(Pet pet){
        this.pet = pet;
    }
    public Pet getPet(){
        return pet;
    }

    @Override
    public String toString() {
        String petInfo = (pet != null) ? "Питомец: " + pet : "Без питомца";
        return name + " (возраст: " + age + ") — " + petInfo;
    }
}


