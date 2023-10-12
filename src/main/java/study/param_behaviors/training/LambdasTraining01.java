package study.param_behaviors.training;

import study.param_behaviors.domain.Car;
import study.param_behaviors.interfaces.LambdasTrainingPredicate;

import java.util.List;

public class LambdasTraining01 {

    private static List<Car> carList = List.of(new Car("Fusca", "green", 1970), new Car("Audi", "black", 2020), new Car("BMW", "green", 2022), new Car("Ranger", "green", 1995), new Car("Civic", "red", 2008));

    public static void main(String[] args) {
        paraCada(carList, car -> System.out.println(car.getName().toUpperCase()));
    }

    private static <R> void paraCada(List<R> list, LambdasTrainingPredicate<R> lambdasTrainingPredicate) {

        for (R o : list) {
            lambdasTrainingPredicate.test(o);
        }


    }

}
