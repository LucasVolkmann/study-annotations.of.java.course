package study.design_patterns.singleton_lazy.test;

import study.design_patterns.singleton_lazy.domain.AircraftSingletonLazy;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class AircraftSingletonLazyTest01 {
    public static void main(String[] args) throws NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
        bookSeat("1A");
        bookSeat("1A");
        System.out.println(AircraftSingletonLazy.getINSTANCE());
        System.out.println(AircraftSingletonLazy.getINSTANCE());

        // REFLECTION (Com reflection é possível alterar os meta dados da classe)
        Constructor<AircraftSingletonLazy> constructor = AircraftSingletonLazy.class.getDeclaredConstructor(String.class);
        constructor.setAccessible(true);
        AircraftSingletonLazy aircraftSingletonLazy = constructor.newInstance("787-900");

        System.out.println(aircraftSingletonLazy);
    }

    private static void bookSeat(String seat) {
        System.out.println(AircraftSingletonLazy.getINSTANCE());
        AircraftSingletonLazy aircraft = AircraftSingletonLazy.getINSTANCE();
        System.out.println(aircraft.bookSeat(seat));
    }
}
