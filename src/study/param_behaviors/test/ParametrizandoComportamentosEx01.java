package study.param_behaviors.test;

import study.param_behaviors.domain.Car;

import java.util.ArrayList;
import java.util.List;

public class ParametrizandoComportamentosEx01 {

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

         */

        imprime("cor verde", filterGreenCar(carList));
        imprime("cor preta", filterBlackCar(carList));
        imprime("qualquer cor ('red', passado por parâmetro)", filterCarByColor(carList, "red"));
        imprime("mais antigos que 2000", filterCarByYearBefore(carList, 2000));

    }

    // Método que retorna uma lista filtrada com carros VERDES
    private static List<Car> filterGreenCar(List<Car> list) {

        List<Car> filterList = new ArrayList<>();

        for (Car car : list) {
            if (car.getColor().equals("green")) {
                filterList.add(car);
            }
        }

        return filterList;
    }

    // Método que retorna uma lista filtrada com carros VERMELHOS
    private static List<Car> filterBlackCar(List<Car> list) {

        List<Car> filterList = new ArrayList<>();

        for (Car car : list) {
            if (car.getColor().equals("black")) {
                filterList.add(car);
            }
        }

        return filterList;
    }

    private static List<Car> filterCarByColor(List<Car> list, String cor) {

        List<Car> filterList = new ArrayList<>();

        for (Car car : list) {
            if (car.getColor().equals(cor)) {
                filterList.add(car);
            }
        }

        return filterList;
    }

    private static List<Car> filterCarByYearBefore(List<Car> list, int year) {

        List<Car> filterList = new ArrayList<>();

        for (Car car : list) {
            if (car.getYear() < year) {
                filterList.add(car);
            }
        }

        return filterList;
    }

    public static void imprime(String filtradaPor, List list){
        System.out.println("Lista filtrada por "+filtradaPor);
        System.out.println(list);
        System.out.println("-----------------------");
    }

}
