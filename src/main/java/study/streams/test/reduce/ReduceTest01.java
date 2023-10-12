package study.streams.test.reduce;

    /*
        #####################################################
                            R E D U C E
        #####################################################
        * Operação terminal que, a partir de operações, reduz
         a lista a um elemento único.

     */

import java.util.List;
import java.util.Optional;

public class ReduceTest01 {
    public static void main(String[] args) {
        List<Integer> integers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        // Utilizei o reduce para somar os elementos da lista em um único
        // Obs.: (Retorna um Optional)
        Optional<Integer> test1 = integers.stream()
                .reduce((x, y) -> x + y);
        System.out.println("test1: " + test1);

        // Somei todos mas começei com um elemento inicial(passado como primeiro parametro),
        // portanto não retorna um Optional
        Integer test2 = integers.stream()
                .reduce(0, (x, y) -> x + y);
        // Pode-se passar um method reference
        Integer test3 = integers.stream()
                .reduce(0, Integer::sum);
        System.out.println("test2: " + test2);
        System.out.println("test3: " + test3);


        System.out.println("---------------------------------");
        // Para retornar o elemento máximo da lista (FORMA "FEIA")
        integers.stream()
                .reduce((x, y) -> x > y ? x : y)
                .ifPresent(System.out::println);


        // Para retornar o elemento máximo da lista (FORMA "BONITA")
        // e posso passar como parâmetro um elemento inicial para usar
        // como referência (Eliminando o retorno do OPTIONAL)
        Integer test4 = integers.stream()
                .reduce(0, Integer::max);
        System.out.println("test4: " + test4);
    }
}
