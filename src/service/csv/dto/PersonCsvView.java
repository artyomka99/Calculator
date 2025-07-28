package service.csv.dto;

import com.opencsv.bean.CsvBindByName;
import entity.person.Person;

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


