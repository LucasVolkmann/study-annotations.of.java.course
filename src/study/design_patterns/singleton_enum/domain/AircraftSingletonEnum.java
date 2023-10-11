package study.design_patterns.singleton_enum.domain;

import java.util.HashSet;
import java.util.Set;

public enum AircraftSingletonEnum {
    INSTANCE;
    private final Set<String> availableSeats;

    AircraftSingletonEnum() {
        this.availableSeats = new HashSet<>();
        this.availableSeats.add("1A");
        this.availableSeats.add("1B");
    }

    // Tomar cuidado que este método não pe thread safe e
    // podem ocorrer problemas com a concorrência dele
    public boolean bookSeat(String seat) {
        return availableSeats.remove(seat);
    }
}
