package study.generics.generic_class.domain;

public class Barco {
    private String nome;

    @Override
    public String toString() {
        return "Barco{" +
                "nome='" + nome + '\'' +
                '}';
    }

    public Barco(String nome) {
        this.nome = nome;
    }

}
