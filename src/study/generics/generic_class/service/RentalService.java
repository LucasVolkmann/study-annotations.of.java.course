package study.generics.generic_class.service;

import java.util.List;

public class RentalService <T> {

    private List<T> avaliableServices;
    public RentalService(List<T> list) {
        this.avaliableServices = list;
    }

    public T alugar(){

        System.out.println("Buscando serviços...");
        T removed = avaliableServices.remove(0);
        System.out.println("Serviço alugado: "+removed);
        System.out.println("Serviços Dísponíveis: "+avaliableServices);

        return removed;
    }

    public void devolver(T t){

        System.out.println("Inserido "+t+" novamente no sistema.");
        avaliableServices.add(t);
        System.out.println("Serviços disponíveis: "+avaliableServices);

    }

}
