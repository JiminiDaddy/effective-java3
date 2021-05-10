package item02;

import java.util.EnumSet;
import java.util.Objects;
import java.util.Set;

/**
 * Created by Choen-hee Park
 * User : chpark
 * Date : 2021/05/10
 * Time : 10:15 PM
 */

abstract class Pizza {
    private final Set<Topping> toppings;

    // Builder의 타입은 따로 제한하지 않는다.
    Pizza(Builder<?> builder) {
       toppings = builder.toppings.clone();
    }

    Set<Topping> getToppings() {
        return toppings;
    }

    // Pizza.Builder를 상속받은 클래스만 제네릭 타입으로 허용한다.
    abstract static class Builder<T extends Builder<T>> {
        private EnumSet<Topping> toppings = EnumSet.noneOf(Topping.class);

        // 제네릭 타입 T(Builder를 상속받은 클래스)를 반환한다.
        T addTopping(Topping topping) {
            toppings.add(Objects.requireNonNull(topping));
            return self();
        }

        // self() 를 통해 하위클래스에서 메서드 연쇄가 가능하도록 구현한다.
        protected abstract T self();

        public abstract Pizza build();
    }
}
