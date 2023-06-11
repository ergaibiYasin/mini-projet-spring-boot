package indatacore.test.realisation.service;

import indatacore.test.realisation.model.Person;

import java.util.Random;

public class RandomPersonGenerator {
    private static final String[] NAMES = {
            "Yassine", "Hamza", "Fatima", "Noureddine", "Saad", "Nouha"
    };

    private static final int MIN_AGE = 18;
    private static final int MAX_AGE = 60;

    public static Person generateRandomPerson() {
        Random random = new Random();
        int nameIndex = random.nextInt(NAMES.length);
        String name = NAMES[nameIndex];

        int age = random.nextInt(MAX_AGE - MIN_AGE + 1) + MIN_AGE;

        String email = name.toLowerCase() + "@gmail.com";

        return new Person(name, age, email);
    }
}
