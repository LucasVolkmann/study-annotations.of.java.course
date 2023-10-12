package study.design_patterns.factory.domain;

public interface Currency {
    String getSymbol();
}

class Real implements Currency {
    @Override
    public String getSymbol() {
        return "R$";
    }

}

class usDollar implements Currency {
    @Override
    public String getSymbol() {
        return "$";
    }
}