package item02;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static item02.PizzaSize.LARGE;
import static item02.PizzaSize.SMALL;
import static item02.Topping.*;

/**
 * Created by Choen-hee Park
 * User : chpark
 * Date : 2021/05/10
 * Time : 10:46 PM
 */

class PizzaTest {
    @Test
    @DisplayName("도미노피자와 피자헛피자 만들기")
    void createPizza() {
        DominoPizza dominoPizza = new DominoPizza.Builder(LARGE)
                .addTopping(CHEESE).addTopping(HAM).addTopping(MUSHROOM)
                .build();
        PizzaHutPizza pizzaHutPizza = new PizzaHutPizza.Builder(SMALL)
                .addTopping(CHEESE).addTopping(PEPPER).addTopping(ONION).addTopping(SAUSAGE)
                .sauceInside()
                .build();

        // contain: 중복여부, 순서 관계없이 값만 일차하면 성공
        // containsOnly: 원소의 순서, 중복여부 관계없지만 원소값과 갯수가 일치하면 성공
        // containsExactly: 원소의 순서, 중복여부, 원소값, 갯수까지 포함해서 정확히 일치해야함
        Assertions.assertThat(dominoPizza.getToppings()).containsOnly(CHEESE, HAM, MUSHROOM);
        Assertions.assertThat(dominoPizza.getSize()).isEqualTo(LARGE);
        Assertions.assertThat(pizzaHutPizza.getToppings()).containsOnly(CHEESE, PEPPER, ONION, SAUSAGE);
        Assertions.assertThat(pizzaHutPizza.getSize()).isEqualTo(SMALL);
        Assertions.assertThat(pizzaHutPizza.isSauceInside()).isTrue();
    }
}
