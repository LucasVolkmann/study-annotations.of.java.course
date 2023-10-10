package study.param_behaviors.interfaces;

import study.param_behaviors.domain.Car;

public interface CarPredicate {
    boolean test(Car car);
}
