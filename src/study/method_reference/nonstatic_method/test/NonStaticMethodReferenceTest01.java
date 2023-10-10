package study.method_reference.nonstatic_method.test;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.Function;

public class NonStaticMethodReferenceTest01 {

    public static void main(String[] args) {
        List<String> nomes = new ArrayList<>(List.of(
                "André",
                "John Arias",
                "PH Ganso"
        ));
        //nomes.sort(  (o1, o2) -> o1.compareTo(o2)  );
        nomes.sort(String::compareTo);
        System.out.println(nomes);

        Function<String, Integer> stringToInt = Integer::parseInt;
        Integer num = stringToInt.apply("10");
        System.out.println(num);

        BiPredicate<List<String>, String> checkName = List::contains;
        System.out.println(checkName.test(nomes,"PH Ganso"));
    }

}
