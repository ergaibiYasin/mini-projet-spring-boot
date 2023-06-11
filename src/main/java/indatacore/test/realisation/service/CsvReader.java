package indatacore.test.realisation.service;

import com.opencsv.CSVReader;
import indatacore.test.realisation.model.Person;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class CsvReader {
    public static List<Person> readCsvFile(String filePath) {
        List<Person> persons = new ArrayList<>();

        try (CSVReader reader = new CSVReader(new FileReader(filePath))) {
            String[] nextLine;
            while ((nextLine = reader.readNext()) != null) {
                Person person = new Person();
                person.setName(nextLine[0]);
                person.setAge(Integer.parseInt(nextLine[1]));
                person.setEmail(nextLine[2]);

                persons.add(person);
            }
        } catch (Exception e) {
            System.err.println("Erreur lors de la lecture du fichier CSV : " + e.getMessage());
        }

        return persons;
    }
}
