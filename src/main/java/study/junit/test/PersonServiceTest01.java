package study.junit.test;

import lombok.extern.log4j.Log4j2;
import study.junit.domain.Person;
import study.junit.service.PersonService;

@Log4j2
public class PersonServiceTest01 {
    public static void main(String[] args) {

        Person person = new Person(18);
        PersonService personService = new PersonService();
        log.info("Is adult? '{}'", personService.isAdult(person));

    }
}
