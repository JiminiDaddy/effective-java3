package item02;

import java.util.Objects;

/**
 * Created by Choen-hee Park
 * User : chpark
 * Date : 2021/05/10
 * Time : 10:37 PM
 */

class PizzaHutPizza extends Pizza{
    private final PizzaSize size;

    private final boolean sauceInside;

    PizzaSize getSize() {
        return size;
    }

    boolean isSauceInside() {
        return sauceInside;
    }

    private PizzaHutPizza(Builder builder) {
        super(builder);
        size = Objects.requireNonNull(builder.size);
        sauceInside = builder.sourceInside;
    }

    public static class Builder extends Pizza.Builder<Builder> {
        private final PizzaSize size;

        private boolean sourceInside;

        Builder(PizzaSize size) {
            this.size = size;
        }

        Builder sauceInside() {
            sourceInside = true;
            return this;
        }

        @Override
        protected Builder self() {
            return this;
        }

        // 구체 하위 클래스의 인스턴스를 반환한다.
        // 상위 클래스에서 정의한 반환 타입이 아니라 하위 타입을 반환하는데 이것을 공변 반환 타이핑이라고 한다.
        // 클라이언트가 형변환으로부터 자유로워진다.
        @Override
        public PizzaHutPizza build() {
            return new PizzaHutPizza(this);
        }
    }
}
