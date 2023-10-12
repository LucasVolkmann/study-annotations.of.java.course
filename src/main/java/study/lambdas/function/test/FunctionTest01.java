package study.lambdas.function.test;

    /*
        Function:

        Recebe um tipo, e retorna outro.
        Você escolhe o retorno do método quando criar a lambda

        Function <T, R> {
            R apply(T t);
        }

     */

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class FunctionTest01 {
    public static void main(String[] args) {

        List<String> frases = List.of(
                "A vida é muito curta para ser pequena.",
                "Se você não alcançou seu objetivo, porque está descansando tanto?",
                "Se estiver passando pelo inferno, continue andando.",
                "Acredite em milagres, mas não dependa deles."
        );

//        S E M   L A M B D A ->
//
//        List<Integer> integers = map(frases, new Function<String, Integer>(){
//            @Override
//            public Integer apply(String s) {
//                return s.length();
//            }
//        });

//        C O M   L A M B D A ->

        List<Integer> stringsLengths = map(frases, str -> str.length());

        System.out.println(stringsLengths);

    }

    /*
        Método genérico que recebe uma lista de um tipo e retorna uma lista de
        outro tipo definido pela função lambda passada por parâmetro
     */

    private static <T, R> List<R> map(List<T> list, Function<T, R> function) {

        List<R> mappedList = new ArrayList<>();
        for (T t : list) {

            R r = function.apply(t);

            mappedList.add(r);

        }

        return mappedList;
    }

}
