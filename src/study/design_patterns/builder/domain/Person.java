package study.design_patterns.builder.domain;

public class Person {

    private String firstName;
    private String lastName;
    private String user;
    private String email;

    private Person(String firstName, String lastName, String user, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.user = user;
        this.email = email;
    }

    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", user='" + user + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    public static final class PersonBuilder {
        private String firstName;
        private String lastName;
        private String user;
        private String email;

        private PersonBuilder() {
        }

        public static PersonBuilder builder() {
            return new PersonBuilder();
        }

        public PersonBuilder firstName (String firstName) {
            this.firstName = firstName;
            return this;
        }
        public PersonBuilder lastName (String lastName) {
            this.lastName = lastName;
            return this;
        }
        public PersonBuilder user (String user) {
            this.user = user;
            return this;
        }
        public PersonBuilder email (String email) {
            this.email = email;
            return this;
        }

        public Person build(){
            return new Person(firstName, lastName, user, email);
        }

    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getUser() {
        return user;
    }

    public String getEmail() {
        return email;
    }
}
