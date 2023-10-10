package study.optional.test;

import java.util.List;
import java.util.Optional;

public class OptionalTest01 {
    public static void main(String[] args) {

        String name = findByName("john");
        // Encontro um nome e retorno ele chamando o método toUppercase,
        // que lança uma exceção se for chamado para uma String nula
        try {
            System.out.println(name.toUpperCase());
        }catch (NullPointerException nullPointerException){
            System.out.println(" ! ------ Lançou uma exceção ( "+nullPointerException.getMessage()+" )\n");
        }

// ############################################################################################################
//      USANDO OPTIONAL ->

        // Aqui eu estou encapsulando a resposta de um método que eu não posso alterar
        Optional<String> optionalNameEmpty = Optional.ofNullable(findByName("john"));
        System.out.println("Retorno nulo do findByName dentro do Optional: "+optionalNameEmpty);

        Optional<String> optionalNameFull = Optional.ofNullable(findByName("John"));
        System.out.println("Retorno não nulo do findByName dentro do Optional: "+optionalNameFull);

//      Agora chamando o método que retorna um optional

        // Chamando o método "ifPresent" que pede um Consumer e
        // passo um consumer printando na tela o valor do optional
        optionalFindByName("Lucas").ifPresent(System.out::println);

        //Método "if else" em uma linha:
        optionalFindByName("Andre")
                .ifPresentOrElse(
                        // Se estiver presente:
                        s -> System.out.println("Nome encontrado! -> "+s),
                        // Senão:
                        () -> System.out.println("Não encontramos nenhum nome na nossa lista"));


    }

    private static String findByName(String name){

        List<String> names = List.of("Lucas", "Paulo", "Andre", "John");

        int i = names.indexOf(name);

        if(i != -1){
            return names.get(i);
        }

        // Retorno um objeto nulo se eu não achar nada.
        return null;
    }

    // Método que encapsula os retornos com um OPTIONAL
    private static Optional<String> optionalFindByName(String name){

        List<String> names = List.of("Lucas", "Paulo", "Andre", "John");

        int i = names.indexOf(name);

        if(i != -1){
            return Optional.ofNullable(names.get(i));
        }

        // Retorno um optional vazio que pode ser tratado
        return Optional.empty();

    }

}
