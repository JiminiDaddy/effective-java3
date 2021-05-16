package item07;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.EmptyStackException;

/**
 * Created by Choen-hee Park
 * User : chpark
 * Date : 2021/05/16
 * Time : 2:05 PM
 */

public class MyStackTest {
    @Test
    @DisplayName("스택의 push, pop기능이 잘 동작하는지 확인")
    void checkStackPushAndPop() {
        MyStack<Integer> stack = new MyStack();
        stack.push(100);
        stack.push(200);
        stack.push(300);
        Assertions.assertThat(stack.size()).isEqualTo(3);
        Assertions.assertThat(stack.pop()).isEqualTo(300);
        Assertions.assertThat(stack.pop()).isEqualTo(200);
        Assertions.assertThat(stack.pop()).isEqualTo(100);
        Assertions.assertThatThrownBy(stack::pop).isInstanceOf(EmptyStackException.class);
    }
}
