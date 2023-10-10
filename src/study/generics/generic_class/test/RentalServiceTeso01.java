package study.generics.generic_class.test;

import study.generics.generic_class.domain.Carro;
import study.generics.generic_class.service.RentalService;
import study.generics.generic_class.domain.Barco;

import java.util.ArrayList;
import java.util.List;

public class RentalServiceTeso01 {
    public static void main(String[] args) {

        List<Carro> carroList = new ArrayList<>(List.of(
                new Carro("Civic"),
                new Carro("Fusca"),
                new Carro("Clio")
        ));

        List<Barco> barcoList = new ArrayList<>(List.of(
                new Barco("Lancha"),
                new Barco("Bote"),
                new Barco("Canoa")
        ));

        RentalService<Barco> barcoRentalService = new RentalService<>(barcoList);
        Barco barcoAlugado = barcoRentalService.alugar();
        barcoRentalService.devolver(barcoAlugado);

        System.out.println("-----------------------------");

        RentalService<Carro> carroRentalService = new RentalService<>(carroList);
        Carro carroAlugado = carroRentalService.alugar();
        carroRentalService.devolver(carroAlugado);


    }
}
