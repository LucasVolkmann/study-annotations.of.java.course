package study.streams.test.collectors;

import study.streams.domain.Funcao;
import study.streams.domain.Habilidade;
import study.streams.domain.Players;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GroupingByTest02 {

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

        System.out.println("--------------------------------- Agrupando p rating: ");
        // Definindo o agrupamento pelo rating
        Map<Habilidade, List<Players>> agrupadoPorHabilidade =
                playersList.stream()
                        .collect(Collectors.groupingBy(
                                jogador -> jogador.getRating() <= 7.5 ?
                                        Habilidade.BAGRE :
                                        Habilidade.NORMAL
                        ));
        agrupadoPorHabilidade.forEach((skill, plyrs) -> System.out.println(skill + ": \n" + plyrs));


        System.out.println("--------------------------------- FUNCAO: HABILIDADE: ");
        /*
            Agrupando por Funcao e dentro de cada agrupamento
            agrupar por habilidade

            •Funçao:
            ------•GOLEIROS:
            ------------•NORMAL:
            ------------•BAGRE:
            ------•DEFENSORES:
            ------------•NORMAL:
            ------------•BAGRE:
            ------•MEIAS:
            ------------•NORMAL:
            ------------•BAGRE:
            ------•ATACANTES:
            ------------•NORMAL:
            ------------•BAGRE:
         */
        Map<Funcao, Map<Habilidade, List<Players>>> agrupadoPorFuncEHabil =
                playersList.stream()
                        .collect(Collectors.groupingBy(
                                Players::getFuncao,
                                Collectors.groupingBy(
                                        jogador -> jogador.getRating() <= 7.5 ?
                                                Habilidade.BAGRE :
                                                Habilidade.NORMAL
                                )
                        ));
        agrupadoPorFuncEHabil.forEach((f, h) -> {
            System.out.println("---------" + f + ": ");
            h.forEach((h2, listP) -> System.out.println("---" + h2 + ": \n" + listP));
        });
    }
}
