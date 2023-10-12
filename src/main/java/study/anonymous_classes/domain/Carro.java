package study.anonymous_classes.domain;

public class Carro {

    private String name;
    private int ano;

    public Carro(String name, int ano) {
        this.name = name;
        this.ano = ano;
    }

    @Override
    public String toString() {
        return "Carro{" +
                "name='" + name + '\'' +
                ", ano=" + ano +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }
}
