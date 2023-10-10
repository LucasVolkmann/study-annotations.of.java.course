package study.anonymous_classes.test;

import study.anonymous_classes.domain.Carro;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class CarroNameComparator implements Comparator<Carro>{
    @Override
    public int compare(Carro o1, Carro o2) {
        return o1.getName().compareTo(o2.getName());
    }
}

public class ClassesAnonimasEx02 {
    public static void main(String[] args) {

        List<Carro> listaDeCarros = new ArrayList<>(List.of(
                new Carro("Fusca", 1500),
                new Carro("Brasília", 1750),
                new Carro("Kombi", 1460),
                new Carro("Gol", 1800)
        ));

        List<Carro> listaDeCarros2 = new ArrayList<>(List.of(
                new Carro("Fusca", 1500),
                new Carro("Brasília", 1750),
                new Carro("Kombi", 1460),
                new Carro("Gol", 1800)
        ));

        // Se eu quiser ordenar uma lista:

        listaDeCarros.sort(new CarroNameComparator());
        System.out.println(listaDeCarros);

        /*
            Se eu quiser ordenar uma lista SEM TER QUE CRIAR
            UMA CLASSE toda do zero, posso criar uma classe anônima

         */

        // PODE SER REFATORADO PARA UTILIZAR LAMBDAS
        listaDeCarros2.sort(new Comparator<Carro>() {
            @Override
            public int compare(Carro o1, Carro o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });
        System.out.println(listaDeCarros2);


    }
}
