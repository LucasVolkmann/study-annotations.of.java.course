package study.design_patterns.builder.test;

import study.design_patterns.builder.domain.Person;

public class BuilderPatternTest01 {
    public static void main(String[] args) {

        Person buildedPerson = Person.PersonBuilder
                .builder()
                .firstName("Lucas")
                .lastName("Volkmann")
                .user("german_cano")
                .email("email@email.com")
                .build();

        System.out.println(buildedPerson);
    }
}
