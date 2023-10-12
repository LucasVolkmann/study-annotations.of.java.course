package study.optional.repository;

import study.optional.domain.Person;

import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

public class PersonRepository {

    private static final List<Person> personList = List.of(
            new Person(1, "Lucas", 1000L),
            new Person(2, "Eduardo", 1560L),
            new Person(3, "João", 1200L),
            new Person(4, "John", 6720L)
    );

    public static Optional<Person> findById(Integer id) {
        return findBy((p) -> p.getId().equals(id));
    }

    public static Optional<Person> findByName(String name) {
        return findBy((p) -> p.getName().equals(name));
    }

    private static Optional<Person> findBy(Predicate<Person> predicate) {

        Person foundPerson = null;

        for (Person person : personList) {
            if (predicate.test(person)) {
                foundPerson = person;
            }
        }

        return Optional.ofNullable(foundPerson);

    }


}
