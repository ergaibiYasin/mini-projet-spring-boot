package indatacore.test.realisation.repository;

import indatacore.test.realisation.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MyRepository extends JpaRepository<Person, Long> {
}
