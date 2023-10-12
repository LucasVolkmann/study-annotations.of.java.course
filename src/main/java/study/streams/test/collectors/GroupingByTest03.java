package study.streams.test.collectors;

import study.streams.domain.Funcao;
import study.streams.domain.Players;

import java.util.*;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collectors;

public class GroupingByTest03 {

    private static List<Players> playersList = new ArrayList<>(List.of(
            new Players("Fábio", 8.5, Funcao.GOLEIRO),
            new Players("S. Xavier", 7.5, Funcao.DEFENSOR),
            new Players("Nino", 8, Funcao.DEFENSOR),
            new Players("F. Melo", 7, Funcao.DEFENSOR),
            new Players("Marcelo", 8.5, Funcao.DEFENSOR),
            new Players("André", 9, Funcao.MEIO_CAMPO),
            new Players("Alexsander", 8.5, Funcao.MEIO_CAMPO),
            new Players("PH Ganso", 8.5, Funcao.MEIO_CAMPO),
            new Players("John Arias", 2, Funcao.ATACANTE),
            new Players("Cano", 9, Funcao.ATACANTE),
            new Players("Keno", 8.5, Funcao.ATACANTE)
    ));

    public static void main(String[] args) {

        // Criando um Map com cada função e a quantidade de
        // jogadores po cada uma
        Map<Funcao, Long> contagemPorFuncao =
                playersList.stream()
                        .collect(Collectors.groupingBy(
                                Players::getFuncao,
                                Collectors.counting()
                        ));
        System.out.println(contagemPorFuncao);


        // Retornar o jogador com maior rating por função
        //
//        ******** OBS.: O jogador retornado vem dentro de um optional ********
        Map<Funcao, Optional<Players>> maiorRatingPorFuncao =
                playersList.stream()
                        .collect(
                                // Agrupando por:
                                Collectors.groupingBy(
                                        // Coluna1: Função
                                        Players::getFuncao,
                                        // Coluna2: Maior elemento
                                        Collectors.maxBy(
                                                // Ordenar os elementos por:
                                                Comparator.comparing(Players::getRating))
                                ));
        System.out.println(maiorRatingPorFuncao);


        // Retornando o jogador com maior rating por
        // função extraido do OPTIONAL
        Map<Funcao, Players> semOptional =
                playersList.stream()
                        .collect(
                                // Agrupar os elementos
                                Collectors.groupingBy(
                                        // Coluna1: Função
                                        Players::getFuncao,
                                        // Coluna2: Jogador com maior rating
                                        // Coleta o elemento e então executa uma função em cima dele
                                        Collectors.collectingAndThen(
                                                // Coleta o elemento com maior rating
                                                Collectors.maxBy(Comparator.comparing(Players::getRating)),
                                                // Pega o elemento de dentro do OPTIONAL
                                                Optional::get
                                        )
                                ));
        System.out.println(semOptional);


        // DE MANEIRA REDUZIDA *** Estudar depois
        Map<Funcao, Players> reduzida =
                playersList.stream()
                        .collect(
                                Collectors.toMap(
                                        Players::getFuncao,
                                        Function.identity(),
                                        BinaryOperator.maxBy(
                                                Comparator.comparing(Players::getRating))));
    }
}
