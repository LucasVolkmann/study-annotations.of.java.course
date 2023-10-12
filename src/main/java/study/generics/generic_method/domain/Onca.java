package study.generics.generic_method.domain;

public class Onca extends Animal {

    public Onca(String nome) {
        super(nome);
    }

    @Override
    public String toString() {
        return "Onca{" +
                "nome='" + nome + '\'' +
                '}';
    }

    @Override
    void locomover() {
        System.out.println("Correndo...");
    }

}
