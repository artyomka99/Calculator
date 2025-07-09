import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PersonService {
    public void generatePersons() {
        List<Person> persons = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        Faker faker = new Faker(new Locle("ru"));
        Random random = new Random();

        System.out println("Какое количество человек хотели бы создать ?");
        int count = scanner.nextInt();

        for (int i = 0; i < count; i++){
            String name = faker.name().fullName();
            int age = random.nextInt(100) + 1;
            persons.add(new Person(name, age));
        }
        System.out.println("Список созданых людей:");
        for (Person person : persons){
            System.out.println(person);
        }

        /*while (true) {
            System.out.println("\n1. Создать человека");
            System.out.println("2. Показать всех");
            System.out.println("3. Выйти");
            System.out.print("Выберите действие: ");

            String input = scanner.nextLine();

            switch (input) {
                case "1":
                    System.out.print("Введите имя: ");
                    String name = scanner.nextLine();
                    System.out.print("Введите возраст: ");

                    int age;
                    try {
                        age = Integer.parseInt(scanner.nextLine());

                    } catch (Exception e) {
                        System.out.println("Ошибка ввода возраста. Пожалуйста, введите число.");
                        continue;
                    }

                    persons.add(new Person(name, age));
                    System.out.println("Человек добавлен.");
                    break;
                case "2":
                    if (persons.isEmpty()) {
                        System.out.println("Список пуст.");
                    } else {
                        System.out.println("Список людей:");
                        for (Person person : persons) {
                            System.out.println(person);
                        }
                    }
                    break;
                case "3":
                    System.out.println("Выход из программы.");
                    return;
                default:
                    System.out.println("Неверный ввод. Пожалуйста, попробуйте снова.");
            }
        }*/
    }
}
