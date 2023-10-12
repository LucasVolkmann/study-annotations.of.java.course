package study.streams.domain;

public class Players {

    private String name;
    private double rating;
    private Funcao funcao;

    public Players(String name, double rating) {
        this.name = name;
        this.rating = rating;
    }

    public Players(String name, double rating, Funcao funcao) {
        this.name = name;
        this.rating = rating;
        this.funcao = funcao;
    }

    @Override
    public String toString() {
        return "Players {" +
                "name='" + name + '\'' +
                ", rating=" + rating +
                ", funcao=" + funcao +
                '}';
    }

    public Funcao getFuncao() {
        return funcao;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }
}
