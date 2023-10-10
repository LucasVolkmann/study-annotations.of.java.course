package study.streams.test.finding_and_matching;

import study.streams.domain.Players;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class FindingAndMatchingTest01 {
    private static List<Players> playersList = new ArrayList<>(List.of(
            new Players("Fábio",8.5),
            new Players("S. Xavier",7.5),
            new Players("Nino",8),
            new Players("F. Melo",7),
            new Players("Marcelo",8.5),
            new Players("André",9),
            new Players("Alexsander",8.5),
            new Players("PH Ganso",8.5),
            new Players("John Arias",8),
            new Players("Cano",9),
            new Players("Keno",8.5)
    ));
    public static void main(String[] args) {


        //  |anyMatch()|

        // true : se ALGUM jogador bate com o Predicate passado
        System.out.println(playersList.stream().anyMatch( pl -> pl.getRating() == 7));


        //  |allMatch()|

        // true : se TODOS os jogadores batem com o Predicate passado
        System.out.println(playersList.stream().allMatch( pl -> pl.getRating() > 0));


        //  |noneMatch()|

        // true : se NENHUM dos jogadores bate com o Predicate passado
        System.out.println(playersList.stream().noneMatch( pl -> pl.getRating() < 0));


        //  |findAny()|

        // retorna um OPTIONAL de algum elemento
        // (Sem qualquer garantia de qual ele vai retornar)
        playersList.stream()
                .filter( pl -> pl.getRating() >= 8.5)
                        .findAny()
        // A partir do findAny posso utilizar os métodos da classe Optional
                            .ifPresent(System.out::println);


        //  |findFirst()|

        // retorna um OPTIONAL do primeiro elemento da lista
        playersList.stream()
                .filter( pl -> pl.getRating() >= 8.5)
                    .sorted(Comparator.comparing(Players::getRating) // Ordenei pelo rating
                                            .reversed())             // Inverti a ordem
                        .findFirst()
                            .ifPresent(System.out::println);


        //  |min()| ou |max()|

        // retorna um OPTIONAL do primeiro ou último elemento da lista
        playersList.stream()
                .filter(pl -> pl.getRating() >= 8.5)
        // Estou pegando o elemento de cima da lista,
        // passo um Comparator para ordenar a lista e pegar ele.
        // Posso usar o "min()" para pegar o valor mínimo
                    .max(Comparator.comparing(Players::getRating))
                        .ifPresent(System.out::println);



    }
}
