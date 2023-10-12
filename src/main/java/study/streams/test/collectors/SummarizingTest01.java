package study.streams.test.collectors;

import study.streams.domain.Players;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;

public class SummarizingTest01 {

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

        // Contar os elementos
        System.out.println("\n------------------------ Quantidade de elementos :");
        System.out.println(playersList.stream().count());
        System.out.println(playersList.stream().collect(Collectors.counting()));


        // Rating mais alto
        System.out.println("\n------------------------ Rating mais alto :");
        playersList.stream().max(Comparator.comparing(Players::getRating))
                .ifPresent(System.out::println);
        playersList.stream()
                .collect(Collectors.maxBy(Comparator.comparing(Players::getRating)))
                .ifPresent(System.out::println);


        // Somar todos os ratings
        System.out.println("\n------------------------ Soma de todos os ratings :");
        System.out.println(playersList.stream().mapToDouble(Players::getRating).sum());
        System.out.println(playersList.stream()
                .collect(Collectors.summingDouble(Players::getRating)));


        // Média de Ratings
        System.out.println("\n------------------------ Média dos ratings :");
        playersList.stream().mapToDouble(Players::getRating)
                .average().ifPresent(System.out::println);
        System.out.println(playersList.stream()
                .collect(Collectors.averagingDouble(Players::getRating)));


        System.out.println("\n------------------------ Objeto contendo todas as estatísticas :");
        // Objeto com todas as estatisticas
        DoubleSummaryStatistics statistcs = playersList.stream()
                .collect(Collectors.summarizingDouble(Players::getRating));
        System.out.println(statistcs);


        System.out.println("\n------------------------ String com todos os nomes :");
        String nomes = playersList.stream()
                .map(Players::getName)
                .collect(Collectors.joining(", "));
        System.out.println(nomes);
    }
}
