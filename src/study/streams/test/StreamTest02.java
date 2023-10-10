package study.streams.test;

import study.streams.domain.Players;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class StreamTest02 {

    /*###########################################_______#######################
            M A N I P U L A N D O   L I S T A S  |C O M|  S T R E A M S
     ############################################¨¨¨¨¨¨¨######################*/

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

        List<String> playersName = playersList.stream() // transforma a coleção em stream
                .sorted(Comparator.comparing(Players::getName)) // Ordena por nome
                .filter(pl -> pl.getRating() <= 8.5) // Filtra jogadores com ratings menores ou iguais a 8.5
                .limit(3) // Limita o tamanho para 3 Jogadores
                .map(Players::getName) // Transforma a lista de jogadores em uma lista de String com o nome dos respectivos
                .collect(Collectors.toList()); // Transforma essa stream em uma coleção novamente

        // Retorna a mesma coisa que na classe "StreamTest01":
        System.out.println(playersName);
    }
}
