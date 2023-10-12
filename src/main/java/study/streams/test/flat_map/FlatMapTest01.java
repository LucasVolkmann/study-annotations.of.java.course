package study.streams.test.flat_map;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

    /*
    ###################################################################
                              F L A T M A P
    ###################################################################
    * Utilizado para desaninhar arrays ou listas multidimensionais

     */

public class FlatMapTest01 {

    public static void main(String[] args) {

        List<List<String>> fluminense = new ArrayList<>();
        List<String> defensores = List.of(
                "Fábio",
                "S. Xavier",
                "Nino",
                "F. Melo",
                "Marcelo"
        );
        List<String> meiocampistas = List.of(
                "André",
                "Alexsander",
                "PH Ganso"
        );
        List<String> atacantes = List.of(
                "Keno",
                "Cano",
                "Arias"
        );
        fluminense.add(defensores);
        fluminense.add(meiocampistas);
        fluminense.add(atacantes);

        // Método antigo de impressão de todos os valores:
        for (List<String> funcoes : fluminense) {
            for (String jogador : funcoes) {
                System.out.println(jogador);
            }
        }
        System.out.println("-------------------");
        // Método com streams (Utilizando o FlatMap)

        fluminense.stream()
                .flatMap(Collection::stream) // Desaninha as listas
                .forEach(System.out::println);


    }

}
