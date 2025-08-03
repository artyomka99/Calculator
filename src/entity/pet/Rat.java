package entity.pet;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Rat implements Pet {
    private String name;
    private int age;
    private String breed;

    @Override
    public String toString() {
        return name + " (" + age + " лет, " + breed + ")";
    }
}