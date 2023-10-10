package study.streams.test.collectors;

import study.streams.domain.Funcao;
import study.streams.domain.Habilidade;
import study.streams.domain.Players;

import java.util.*;
import java.util.stream.Collectors;

public class GroupingByTest04 {

    private static List<Players> playersList = new ArrayList<>(List.of(
            new Players("Fábio",8.5, Funcao.GOLEIRO),
            new Players("S. Xavier",7.5, Funcao.DEFENSOR),
            new Players("Nino",8, Funcao.DEFENSOR),
            new Players("F. Melo",7, Funcao.DEFENSOR),
            new Players("Marcelo",8.5, Funcao.DEFENSOR),
            new Players("André",9, Funcao.MEIO_CAMPO),
            new Players("Alexsander",8.5, Funcao.MEIO_CAMPO),
            new Players("PH Ganso",8.5, Funcao.MEIO_CAMPO),
            new Players("John Arias",2, Funcao.ATACANTE),
            new Players("Cano",9, Funcao.ATACANTE),
            new Players("Keno",8.5, Funcao.ATACANTE)
    ));

    public static void main(String[] args) {

        System.out.println("----------------------------------------- Stats for Func");
        // Retornar um Map onde a chave é a Funcao e o valor é um objeto
        // de DoubleSummaryStatistics
        Map<Funcao, DoubleSummaryStatistics> collect = playersList.stream()
                .collect(Collectors.groupingBy(
                        Players::getFuncao,
                        Collectors.summarizingDouble(Players::getRating)
                ));
        collect.forEach( (func, stats) -> System.out.println(func+": \n"+stats));


        System.out.println("----------------------------------------- Skill for Func");
        // Agrupar as Habilidades dos jogadores por Funcao
        Map<Funcao, List<Habilidade>> collect1 = playersList.stream()
                .collect(Collectors.groupingBy(
                        Players::getFuncao,
                        //Vai mapear uma lista de players para uma lista de BAGRE ou NORMAL
                        Collectors.mapping(
                                player -> player.getRating() < 8.5 ?
                                        Habilidade.BAGRE :
                                        Habilidade.NORMAL,
                                // Pede o tipo de coleção que o retorno deve ter
                                Collectors.toList()
                        )
                ));
        collect1.forEach( (func, skillList) -> System.out.println(func+": \n"+skillList) );


        System.out.println("----------------------------------------- Skill for Func with Set");
        // Mesma coisa que o de cima mas retornar um Set para delegar
        // para o java a função de eliminar repetidos
        Map<Funcao, Set<Habilidade>> collect2 = playersList.stream()
                .collect(Collectors.groupingBy(
                        Players::getFuncao,
                        Collectors.mapping(
                                player -> player.getRating() < 8.5 ?
                                        Habilidade.BAGRE :
                                        Habilidade.NORMAL,
                                Collectors.toSet()
                        )
                ));
        collect2.forEach( (func, skillList) -> System.out.println(func+": \n"+skillList) );


        System.out.println("----------------------------------------- Skill for Func choosing collection type");
        // Escolhendo qual tipo de coleção queremos retornar
        Map<Funcao, Set<Habilidade>> collect3 = playersList.stream()
                .collect(Collectors.groupingBy(
                        Players::getFuncao,
                        Collectors.mapping(
                                player -> player.getRating() < 8.5 ?
                                        Habilidade.BAGRE :
                                        Habilidade.NORMAL,
                                Collectors.toCollection(LinkedHashSet::new)
                        )
                ));
        collect3.forEach( (func, skillList) -> System.out.println(func+": \n"+skillList) );


        System.out.println("----------------------------------------- TESTE PROPRIO");
        Map<Funcao, Map<Habilidade, Long>> collect4 = playersList.stream()
                .collect(Collectors.groupingBy(
                        Players::getFuncao,
                        Collectors.groupingBy(
                                player -> player.getRating() < 8.5 ?
                                        Habilidade.BAGRE :
                                        Habilidade.NORMAL,
                                Collectors.counting()
                        )
                ));
        collect4.forEach( (funcao, map) -> {
            System.out.println("---------" + funcao + ": ");
            map.forEach((habilidade, count) -> System.out.println("---" + habilidade + ": " + count));
        });
    }
}
