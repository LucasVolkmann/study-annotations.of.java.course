package study.generics.generic_method.domain;

public class Aguia extends Animal{

    public Aguia(String nome) {
        super(nome);
    }

    @Override
    void locomover() {
        System.out.println("Voando...");
    }
}
