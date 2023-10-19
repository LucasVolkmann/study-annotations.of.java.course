package study.junit.service;

import study.junit.domain.Person;

import java.util.List;

public class PersonService {

    public boolean isAdult(Person person) {
//        Objects.requireNonNull(person, "Person can't be null");
        if (person == null) {
            throw new IllegalArgumentException("Person can't be null");
        }
        return person.getAge() >= 18;
    }

    public List<Person> filterRemovingNotAdult(List<Person> people) {
        return people.stream().filter(this::isAdult).toList();
    }

}
