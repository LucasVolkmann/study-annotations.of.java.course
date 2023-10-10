package study.param_behaviors.test;

import study.param_behaviors.domain.Car;
import study.param_behaviors.interfaces.CarPredicate;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class ParametrizandoComportamentosEx02 {

    private static List<Car> carList = List.of(new Car("Fusca", "green", 1970), new Car("Audi", "black", 2020), new Car("BMW", "green", 2022), new Car("Ranger", "green", 1995), new Car("Civic", "red", 2008));

    public static void main(String[] args) {

        /*
            Tenho uma lista simulando um banco de dados e quero
            filtrar ela por:
            .Carros verdes
            .Carros pretos
            .Idade

            Método antigo:
            - Crio um método para cada um desses requisitos
            (Como no Ex anterior da classe: ParametrizandoComportamentosEx01)

            Novo método:
            - Crio um método generico onde passo a condição do filtro por parâmetro
            utilizando uma classe anônima chamada de uma interface criada por mim,
            onde sobreescrevo o método com a condição que desejo.

         */

        List<Car> greenCars = filter(carList, new CarPredicate() {
            @Override
            public boolean test(Car car) {
                return car.getColor().equals("green");
            }
        });

        /*
            Transformando a chamada da classe anônima em uma função lambda

                    car -> car.getColor().equals("green")
                    ^^^  | ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
     Parâmetro do método | Retorno do método

         */

        ParametrizandoComportamentosEx01.imprime("carros da cor 'green' utilizando um método genérico", genericFilter(carList, car -> car.getColor().equals("green")));

        ParametrizandoComportamentosEx01.imprime("carros da cor 'green'", greenCars);

    }

    /*
        Peço no parâmetro a interface que eu criei, e dentro do método
        eu chamo o único método dentro dela.
        O que possibilita que eu crie uma classe anônima na chamada do método
        e sobreescreva o método com a condição que eu quiser
     */
    private static List<Car> filter(List<Car> list, CarPredicate carPredicate) {

        List<Car> filterList = new ArrayList<>();

        for (Car car : list) {

            // Aqui chamo o método da interface
            if (carPredicate.test(car)) {
                filterList.add(car);
            }
        }

        return filterList;
    }

    // Método genérico de filtragem de listas:

    private static <T> List<T> genericFilter(List<T> list, Predicate<T> predicate){

        List<T> filteredList = new ArrayList<>();
        for (T t : list) {
            if(predicate.test(t)){
                filteredList.add(t);
            }
        }

        return filteredList;

    }

}
