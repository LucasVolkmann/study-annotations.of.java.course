package study.lambdas.predicate.test;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

    /*
        LAMBDAS:
        São anônimas, funções e concisas


        Para eu poder utilizar uma lambda em uma Interface, ela deve
        ser uma @FunctionalInterface (o que significa que ela só tem um método abstrato)

        E qualquer interface funcional me permite usar lambdas

        Tendo 2 ou mais métodos abstratos eu seria obrigado a sobreescrever mais de um
        método quando eu criasse uma classe anônima extendendo a interface.

      | Predicate <T> {
      |     boolean test(T t);
      | }

     */

public class PredicateTest01 {
    public static void main(String[] args) {

        List<Integer> nums = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        System.out.println(genericFilter(nums, num -> num % 2 == 0));

    }

    //----------------------------------------- Utilizando o Predicate:
    private static <T> List<T> genericFilter(List<T> list, Predicate<T> predicate) {

        List<T> filteredList = new ArrayList<>();
        for (T t : list) {
            if (predicate.test(t)) {
                filteredList.add(t);
            }
        }

        return filteredList;

    }

}
