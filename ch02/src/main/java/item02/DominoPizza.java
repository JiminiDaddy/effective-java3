package item02;

import java.util.Objects;

/**
 * Created by Choen-hee Park
 * User : chpark
 * Date : 2021/05/10
 * Time : 10:27 PM
 */

class DominoPizza extends Pizza {
    private final PizzaSize size;

    private DominoPizza(Builder builder) {
        super(builder);
        size = builder.size;
    }

    PizzaSize getSize() {
        return size;
    }

    // Pizza.Builder를 상속받고, 제네릭타입으로 자신(Builder)을 설정한다.
    public static class Builder extends Pizza.Builder<Builder> {
        private final PizzaSize size;

        Builder(PizzaSize size) {
            this.size = Objects.requireNonNull(size);
        }

        // 메서드 연쇄를 위해 자기 자신을 반환한다.
        @Override
        protected Builder self() {
            return this;
        }

        // 상위 클래스(Pizza)에서 build() 메서드 타입은 Pizza이지만 하위 클래스(DominoPizza)에서 타입을 DominoPizza로 변환했다.
        // 이렇게 하위 클래스에서 반환타입을 변경하는것을 공변 반환 타이핑이라고 한다.
        // 클라이언트(DominoPizza를 생성하는 객체)는 build() 반환타입의 형변환에 신경쓰지 않아도 된다.
        @Override
        public DominoPizza build() {
            return new DominoPizza(this);
        }
    }
}
