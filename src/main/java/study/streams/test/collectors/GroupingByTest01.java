package study.streams.test.collectors;

import study.streams.domain.Funcao;
import study.streams.domain.Players;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GroupingByTest01 {

    private static List<Players> playersList = new ArrayList<>(List.of(
            new Players("Fábio", 8.5, Funcao.GOLEIRO),
            new Players("S. Xavier", 7.5, Funcao.DEFENSOR),
            new Players("Nino", 8, Funcao.DEFENSOR),
            new Players("F. Melo", 7, Funcao.DEFENSOR),
            new Players("Marcelo", 8.5, Funcao.DEFENSOR),
            new Players("André", 9, Funcao.MEIO_CAMPO),
            new Players("Alexsander", 8.5, Funcao.MEIO_CAMPO),
            new Players("PH Ganso", 8.5, Funcao.MEIO_CAMPO),
            new Players("John Arias", 8, Funcao.ATACANTE),
            new Players("Cano", 9, Funcao.ATACANTE),
            new Players("Keno", 8.5, Funcao.ATACANTE)
    ));

    public static void main(String[] args) {

//      Preencher um map separando os jogadores por funções:


        // S E M   U S A R   S T R E A M S ->

        Map<Funcao, List<Players>> playersForFunction = new HashMap<>();

        List<Players> goleiros = new ArrayList<>();
        List<Players> defensores = new ArrayList<>();
        List<Players> meio_campos = new ArrayList<>();
        List<Players> atacantes = new ArrayList<>();

        for (Players player : playersList) {

            switch (player.getFuncao()) {
                case GOLEIRO -> goleiros.add(player);
                case DEFENSOR -> defensores.add(player);
                case MEIO_CAMPO -> meio_campos.add(player);
                case ATACANTE -> atacantes.add(player);
            }

        }

        playersForFunction.put(Funcao.GOLEIRO, goleiros);
        playersForFunction.put(Funcao.DEFENSOR, defensores);
        playersForFunction.put(Funcao.MEIO_CAMPO, meio_campos);
        playersForFunction.put(Funcao.ATACANTE, atacantes);

        System.out.println(playersForFunction);


        // U S A N D O   S T R E A M S ->
        Map<Funcao, List<Players>> playersForFunction_WithStreams =
                playersList.stream()
                        .collect(Collectors.groupingBy(Players::getFuncao));

        System.out.println(playersForFunction_WithStreams);

    }
}
