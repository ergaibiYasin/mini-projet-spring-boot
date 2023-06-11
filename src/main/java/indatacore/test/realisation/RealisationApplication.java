package indatacore.test.realisation;

import indatacore.test.realisation.model.Person;
import indatacore.test.realisation.service.CsvReader;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class RealisationApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(RealisationApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		String filePath = "src/main/resources/static/personsCsv.csv";

		List<Person> persons = CsvReader.readCsvFile(filePath);
		for (Person person : persons) {
			System.out.println(person.toString());
		}
	}

}
