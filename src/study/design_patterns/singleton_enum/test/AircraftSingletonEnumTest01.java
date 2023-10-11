package study.design_patterns.singleton_enum.test;

import study.design_patterns.singleton_enum.domain.AircraftSingletonEnum;

public class AircraftSingletonEnumTest01 {
    public static void main(String[] args) {
        bookSeat("1A");
        bookSeat("1A");
    }

    private static void bookSeat(String seat) {
        System.out.println(AircraftSingletonEnum.INSTANCE.hashCode());
        AircraftSingletonEnum aircraft = AircraftSingletonEnum.INSTANCE;
        System.out.println(aircraft.bookSeat(seat));
    }
}
