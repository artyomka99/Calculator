public class Animal {

    public interface Pet {
        String getName();

        int getAge();

        String getBreed();
    }

    static class Dog implements Pet {
        private String name;
        private int age;
        private String breed;

        public Dog(String name, int age, String breed) {
            this.name = name;
            this.age = age;
            this.breed = breed;
        }

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }

        public String getBreed() {
            return breed;
        }

        @Override
        public String toString() {
            return name + "(" + age + " лет," + breed + ")";
        }
    }

    public static class Cat implements Pet {
        private String name;
        private int age;
        private String breed;

        public Cat(String name, int age, String breed) {
            this.name = name;
            this.age = age;
            this.breed = breed;
        }

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }

        public String getBreed() {
            return breed;
        }

        @Override
        public String toString() {
            return name + "(" + age + " лет," + breed + ")";
        }
    }

    public static class Rat implements Pet {
        private String name;
        private int age;
        private String breed;

        public Rat(String name, int age, String breed) {
            this.name = name;
            this.age = age;
            this.breed = breed;
        }

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }

        public String getBreed() {
            return breed;
        }

        @Override
        public String toString() {
            return name + "(" + age + " лет," + breed + ")";
        }
    }

    public static class Mouse implements Pet {
        private String name;
        private int age;
        private String breed;

        public Mouse(String name, int age, String breed) {
            this.name = name;
            this.age = age;
            this.breed = breed;
        }

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }

        public String getBreed() {
            return breed;
        }

        @Override
        public String toString() {
            return name + "(" + age + " лет," + breed + ")";
        }
    }
}
