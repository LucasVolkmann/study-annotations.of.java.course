package study.design_patterns.factory.domain;

public class CurrencyFactory {
    public static Currency newCurrency(Country country) {
        return switch (country) {
            case BRAZIL -> new Real();
            case USA -> new usDollar();
            default -> throw new IllegalArgumentException("No currency found for this country.");
        };
    }
}
