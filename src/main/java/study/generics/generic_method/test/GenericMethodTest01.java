package study.generics.generic_method.test;

import study.generics.generic_method.domain.Animal;
import study.generics.generic_method.domain.Onca;

import java.util.List;

public class GenericMethodTest01 {
    public static void main(String[] args) {
        List<Onca> list = criarArrayComObjeto(new Onca("Pintada"));
        System.out.println(list);
    }

    private static <Tipo extends Animal> List<Tipo> criarArrayComObjeto(Tipo t) {
        return List.of(t);
    }

}
