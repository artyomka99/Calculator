package service;

import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import entity.person.Person;
import repository.PersonRepository;
import service.csv.dto.PersonCsvView;

import java.io.File;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.nio.file.Files;
import java.util.List;

public class CSVService {
    private final String CSV_FILE = "persons.csv";
    private final PersonRepository personRepository = PersonRepository.getInstance();;

    public void saveToCsv() {
        try (Writer writer = Files.newBufferedWriter(new File(CSV_FILE).toPath())) {
            var beans = personRepository.getPersons().stream().map(PersonCsvView::fromPerson).toList();
            new StatefulBeanToCsvBuilder<PersonCsvView>(writer).build().write(beans);
            System.out.println("Сохранено в CSV.");
        } catch (Exception e) {
            System.out.println("Ошибка при сохранении CSV: " + e.getMessage());
        }
    }

    public void loadFromCsv() {
        try (Reader reader = Files.newBufferedReader(new File(CSV_FILE).toPath())) {
            var csvList = new CsvToBeanBuilder<PersonCsvView>(reader)
                    .withType(PersonCsvView.class)
                    .build()
                    .parse();
            csvList.forEach(view -> personRepository.getPersons().add(view.toPerson()));
            System.out.println("Загружено из CSV.");
        } catch (Exception e) {
            System.out.println("Ошибка при чтении CSV: " + e.getMessage());
        }
    }

    public void printCsvFile() {
        try {
            System.out.println(Files.readString(new File(CSV_FILE).toPath()));
        } catch (IOException e) {
            System.out.println("Ошибка чтения CSV.");
        }
    }
}
