package indatacore.test.realisation.controller;

import indatacore.test.realisation.model.Person;
import indatacore.test.realisation.repository.MyRepository;
import indatacore.test.realisation.service.RandomPersonGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class MyController {

    private final MyRepository myRepository;

    @Autowired
    public MyController(MyRepository myRepository) {
        this.myRepository = myRepository;
    }

    @GetMapping("/person")
    public List<Person> getPerson() {
        List<Person> personsList = new ArrayList<>();
        personsList.add(new Person("Person 1" ,25,"person1@gmail.com"));
        personsList.add(new Person("Person 2" ,40,"person2@gmail.com"));
        personsList.add(new Person("Person 3" ,70,"person3@gmail.com"));
        return personsList;
    }

    @PostMapping("/person")
    public Person addPerson(@RequestBody Person person) {
        Person savedPerson = myRepository.save(person);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedPerson).getBody();
    }

    @PostMapping("/random")
    public Person addRandomPerson() {
        Person randomPerson = RandomPersonGenerator.generateRandomPerson();
        Person savedPerson = myRepository.save(randomPerson);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedPerson).getBody();
    }
}
