package entity.person;

import com.opencsv.bean.CsvBindByName;

public class PersonCsvView {

        @CsvBindByName
        private String name;

        @CsvBindByName
        private int age;

        public PersonCsvView() {}

        public static PersonCsvView fromPerson(Person p) {
            var view = new PersonCsvView();
            view.name = p.getName();
            view.age = p.getAge();
            return view;
        }

        public Person toPerson() {
            return new Person(name, age);
        }
    }


