package study.optional.test;

import study.optional.domain.Person;
import study.optional.repository.PersonRepository;

import java.util.Optional;

public class OptionalTest02 {

    /*
    Exercicio:
        0. Dado um repositório de pessoas
        1. Procurar uma pessoa por nome -> se existir atualize ele
        2. Procure por ID caso o id não exista lançar IllegalArgumentException
        3. Procure por nome -> caso não encontre crie uma nova

     */

    public static void main(String[] args) {

        // 1 ->
        Optional<Person> personFixName = PersonRepository.findByName("Lucas");
        personFixName.ifPresent( person -> person.setName("Lucas Eduardo") );
        System.out.println("1--------");
        System.out.println(personFixName);

        // 2 ->
        try {

            Person personById = PersonRepository.findById(8)
                    .orElseThrow(IllegalArgumentException::new);
            System.out.println("2--------");
            System.out.println(personById);

        }catch(IllegalArgumentException ill){
            System.out.println("2--------");
            System.out.println("Lançada a EXCEÇÃO: "+ill.toString());
        }

        // 3 ->
        Person personFoundOrCreated = PersonRepository.findByName("Paulo")
                .orElse(new Person(5, "Paulo", 7981L));
        System.out.println("3--------");
        System.out.println(personFoundOrCreated);
    }
}
