package study.method_reference.static_method.services;

import study.method_reference.static_method.domain.Anime;

public class AnimeComparators {

    public static int compareByTitle(Anime a1, Anime a2) {
        return a1.getTitle().compareTo(a2.getTitle());
    }

}
