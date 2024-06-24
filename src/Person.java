import java.util.Scanner;

public class Person {

    Scanner scan = new Scanner(System.in);

    private String name;
    private int age;
    private String profession;

    public void person(String name, int age, String profession) {
        this.name = name;
        this.age = age;
        this.profession = profession;
    }
    public String getName() {
        return name;
    }

    public void setdata(){
        System.out.println("Enter the name of the person");
        name = scan.next();
        System.out.println("Enter the age of the person");
        age = scan.nextInt();
        System.out.println("Enter the profession of the person");
        profession = scan.next();
    }

    @Override
    public String toString() {
        return "Name: " + name + "\nAge: " + age + "\nProfession: " + profession ;
    }
}

