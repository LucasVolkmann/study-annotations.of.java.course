package study.generics.generic_method.domain;

public class Cobra extends Animal {

    public Cobra(String nome) {
        super(nome);
    }

    @Override
    void locomover() {
        System.out.println("Rastejando...");
    }

}
