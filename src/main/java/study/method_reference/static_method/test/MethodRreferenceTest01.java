package study.method_reference.static_method.test;

    /*
        Se a função lambda chamar apenas UM método pode-se utilizar
        method reference para simplificar ainda mais.

        (String s) -> s.toUpperCase()
        String::toUpperCase

     */

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class MethodRreferenceTest01 {
    public static void main(String[] args) {

        List<String> cantos = List.of(
                "Vamos, vamos tricolor",
                "Vamos, vamos pra vencer",
                "Nós viemos pra cantar",
                "Viemos pra ficar",
                "Contigo até morrer"
        );

        List<String> map = map(cantos, String::toUpperCase);
        System.out.println(map);

    }

    private static <T, R> List<R> map(List<T> list, Function<T, R> function) {

        List<R> mappedList = new ArrayList<>();
        for (T t : list) {

            R r = function.apply(t);

            mappedList.add(r);

        }

        return mappedList;
    }

}
