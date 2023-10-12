package study.design_patterns.singleton_eager.test;

import study.design_patterns.singleton_eager.domain.AircraftSingletonEager;

public class AircraftTest01 {
    public static void main(String[] args) {
        bookSeat("1A");
        bookSeat("1A");
    }

    static void bookSeat(String seat) {

        System.out.println(AircraftSingletonEager.getInstance());
//        Aircraft aircraft = new Aircraft("747-900");
//        System.out.println(aircraft.bookSeat(seat));

    }
}
