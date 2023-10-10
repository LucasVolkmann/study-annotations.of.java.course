package study.param_behaviors.training;

import study.param_behaviors.domain.Car;
import study.param_behaviors.interfaces.LambdasTrainingPredicate;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class LambdasTrainingTest02 {

    private static List<Car> carList = new ArrayList<>(List.of(new Car("Fusca", "green", 1970), new Car("Audi", "black", 2020), new Car("BMW", "green", 2022), new Car("Ranger", "green", 1995), new Car("Civic", "red", 2008)));

    public static void main(String[] args) {

        paraCada(carList, car -> car.setName(car.getName().toUpperCase()));
        System.out.println(carList);

        removeIf(carList, car -> car.getName().equals("BMW"));
        System.out.println(carList);

    }

    private static <T> void paraCada(List<T> list, LambdasTrainingPredicate<T> lambdasTrainingPredicate){
        for (T t : list) {
            lambdasTrainingPredicate.test(t);
        }
    }

    //Buscar na lista (de acordo com o que eu passar nos parâmetros) e retornar o tipo
    private static <T> void removeIf(List<T> list, Predicate<T> predicate){

        List<T> copy = new ArrayList<>(list);
        for (T t : copy) {
            if(predicate.test(t)) {
                list.remove(t);
            }
        }

        list = copy;

    }

}
