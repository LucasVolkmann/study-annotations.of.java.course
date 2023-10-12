package study.design_patterns.factory.test;

import study.design_patterns.factory.domain.Country;
import study.design_patterns.factory.domain.Currency;
import study.design_patterns.factory.domain.CurrencyFactory;

public class CurrencyFactoryTest01 {
    public static void main(String[] args) {
        Currency currency = CurrencyFactory.newCurrency(Country.BRAZIL);
        System.out.println(currency.getSymbol());
    }
}
