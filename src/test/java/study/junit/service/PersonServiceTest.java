package study.junit.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import study.junit.domain.Person;

import java.util.List;

class PersonServiceTest {

    private Person adult;
    private Person notAdult;
    private PersonService personService;

    @BeforeEach
    void setUp() {
        adult = new Person(18);
        notAdult = new Person(17);
        personService = new PersonService();
    }

    @Test
    @DisplayName("A person should be not adult when age is lower than 18")
    void isAdult_ReturnFalse_WhenAgeIsLowerThan18() {
        Assertions.assertFalse(personService.isAdult(notAdult));
    }

    @Test
    @DisplayName("A person should be adult when age is greater or equal than 18")
    void isAdult_ReturnTrue_WhenAgeIsGreaterOrEqualThan18() {
        Assertions.assertTrue(personService.isAdult(adult));
    }

    @Test
    @DisplayName("Should throw IllegalArgumentException when person is null")
    void isAdult_ThrowIllegalArgumentException_WhenPersonIsNull() {
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> personService.isAdult(null), "Exception should be IllegalArgumentException");
    }

    @Test
    @DisplayName("Should return list with only adults")
    void filterRemovingNotAdult_ReturnListWithAdultsOnly_WhenListOfPersonWithAdultIsPassed() {
        List<Person> personList = List.of(
                new Person(17),
                new Person(18),
                new Person(21));
        Assertions.assertEquals(2, personService.filterRemovingNotAdult(personList).size());
    }

}