package study.streams.test.flat_map;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FlatMapTest02 {
    public static void main(String[] args) {

        List<String> palavras = List.of("Chegou"," ","a"," ","hora"," ","vamos"," ","ganhar"," ","a"," ","libertadores");
        String[] letters = palavras.get(0).split("");
        System.out.println("letters; "+letters);


        // Utilizando o "map" não funciona por que o que nós queremos
        // que retorne é Stream<String>
        List<String[]> lett = palavras.stream()
                .map(palavra -> palavra.split(""))
                .toList();

        // Desta maneira podemos transformar array em stream
        Stream<String> arrayStream = Arrays.stream(letters);

        // Agora utilizando o flatMap vemos que conseguimos extrair
        // todas as letras da lista de palavas
        List<String> rightLetters = palavras.stream()
                .map(p -> p.split("")) // Stream<String[]>
                    .flatMap(Arrays::stream) // Stream<String>
                        .toList();           // List<String>
        System.out.println(rightLetters);
    }
}
