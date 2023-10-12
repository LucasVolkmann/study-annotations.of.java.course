package study.streams.test;

import study.streams.domain.Players;

import java.util.ArrayList;
import java.util.List;

public class StreamTest03 {

    /*###########################################_______#######################
            M A N I P U L A N D O   L I S T A S  |C O M|  S T R E A M S
     ############################################¨¨¨¨¨¨¨######################*/

    //   • Alguns métodos terminais:
    private static List<Players> playersList = new ArrayList<>(List.of(
            new Players("Fábio", 8.5),
            new Players("S. Xavier", 7.5),
            new Players("Nino", 8),
            new Players("F. Melo", 7),
            new Players("Marcelo", 8.5),
            new Players("André", 9),
            new Players("Alexsander", 8.5),
            new Players("PH Ganso", 8.5),
            new Players("John Arias", 2),
            new Players("Cano", 9),
            new Players("Keno", 8.5)
    ));

    public static void main(String[] args) {

        playersList.forEach(player -> {
            if (player.getName().equals("John Arias")) {
                System.out.println(player);
            }
        });

        long aPlayers = playersList.stream()
                .distinct()
                .filter(pl -> pl.getRating() >= 8.5)
                .count();

        System.out.println(aPlayers);
    }
}
