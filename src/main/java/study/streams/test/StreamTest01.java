package study.streams.test;

import study.streams.domain.Players;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class StreamTest01 {

    /*###########################################_______#######################
            M A N I P U L A N D O   L I S T A S  |S E M|  S T R E A M S
     ############################################¨¨¨¨¨¨¨######################*/

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

        // Ordenar por nome:
        playersList.sort(Comparator.comparing(Players::getName));
        System.out.println(playersList);

        // Retornar os 3 primeiros Jogadores com rating menor ou igual a 8.5
        List<String> names = new ArrayList<>();

        for (Players players : playersList) {
            if (names.size() >= 3) {
                break;
            }
            if (players.getRating() <= 8.5) {
                names.add(players.getName());
            }
        }

        System.out.println(names);

    }
}
