import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Person {
    String name;
    int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Имя " + name + ", Возраст " + age;
    }
}


