package study.streams.test.reduce;

import study.streams.domain.Players;

import java.util.ArrayList;
import java.util.List;

public class ReduceTest02 {

    private static List<Players> playersList = new ArrayList<>(List.of(
            new Players("Fábio", 8.5),
            new Players("S. Xavier", 7.5),
            new Players("Nino", 8),
            new Players("F. Melo", 7),
            new Players("Marcelo", 8.5),
            new Players("André", 9),
            new Players("Alexsander", 8.5),
            new Players("PH Ganso", 8.5),
            new Players("John Arias", 8),
            new Players("Cano", 9),
            new Players("Keno", 8.5)
    ));

    public static void main(String[] args) {

        // Somar todos os ratings maiores ou iguais a 8.5
        playersList.stream()
                .map(Players::getRating) // Mapeio os PLayers em doubles
                .filter(r -> r >= 8.5) // Filtro todos para maiores de 8.5
                .reduce(Double::sum) // Somo todos com o reduce
                .ifPresent(System.out::println);


        // Em aplicações grandes deve-se tomar cuidado com o boxing e o
        // unboxing de tipos primitivos

        // portanto é recomendavel utilizar as Streams próprias dos
        // wrappers
        // OBS.: Perceba que o Double tem um método poóprio de soma de
        // valores "sum()" que ja retorna um tipo primitivo double
        double sum = playersList.stream()
                .mapToDouble(Players::getRating)
                .filter(r -> r >= 8.5)
                .sum();
        System.out.println(sum);
    }
}
