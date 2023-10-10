package study.method_reference.static_method.test;

import study.method_reference.static_method.domain.Anime;
import study.method_reference.static_method.services.AnimeComparators;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class StaticMethodReferenceTest01 {
    public static void main(String[] args) {

        // LISTA DE ANIMES
        List<Anime> animes = new ArrayList<>(List.of(
                new Anime("C", 700),
                new Anime("A", 300),
                new Anime("D", 150),
                new Anime("E", 900),
                new Anime("B", 500)
        ));

        /*
            ###############################
            Quero ordenar a lista por nomes
            ###############################

            -> Vou chamar o método 'sort()' da lista e passar um comparator

            animes.sort(new Comparator<Anime>() {
                @Override
                public int compare(Anime o1, Anime o2) {
                    return o1.getTitle().compareTo(o2.getTitle());
                }
            });

            -> Posso simplificar com lambdas

         */

        // Simplificado com lambdas:
        animes.sort( (o1, o2) -> o1.getTitle().compareTo(o2.getTitle()) );
        System.out.println(animes);

        /*
            -> Mas eu posso criar uma classe 'AnimeComparators' com um
            método estático que retorna o mesmo que o Comparator
         */

        animes.sort(new Comparator<Anime>() {
            @Override
            public int compare(Anime o1, Anime o2) {
                return AnimeComparators.compareByTitle(o1, o2);
            }
        });

      //Collections.sort(animes, (a1, a2) -> AnimeComparators.compareByTitle(a1, a2) );
        animes.sort(AnimeComparators::compareByTitle);

    }

}
