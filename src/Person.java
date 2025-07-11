public class Person {
    private final String name;
    private final int age;
    private Animal.Pet pet;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
    public void setPet(Animal.Pet pet){
        this.pet = pet;
    }
    public Animal.Pet getPet(){
        return pet;
    }

    @Override
    public String toString() {
        String petInfo = (pet != null) ? "Питомец: " + pet : "Без питомца";
        return name + " (возраст: " + age + ") — " + petInfo;
    }
}


