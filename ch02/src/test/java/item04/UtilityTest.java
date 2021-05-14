package item04;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * Created by Choen-hee Park
 * User : chpark
 * Date : 2021/05/15
 * Time : 12:21 AM
 */

public class UtilityTest {
    @Test
    @DisplayName("Utility가 인스턴스화 불가능한지 테스트")
    void checkUtilityIsCannotInstances() throws IllegalAccessException, InvocationTargetException, InstantiationException {
        // private 생성자만 정의되어있으므로 아래와 같이 생성자호출은 컴파일 에러가 발생한다.
        //Utility utility = new Utility();

        Class c = Utility.class;
        for (Constructor constructor : c.getDeclaredConstructors()) {
            System.out.println(constructor.getModifiers());
            constructor.setAccessible(true);
            // 리플렉션을 통해 newInstance()를 수행할 때, 생성자에서 예외를 던지고, InvocationTargetException이 발생한다.
            Assertions.assertThatThrownBy(() -> {
                Utility utility = (Utility) constructor.newInstance();
            }).isInstanceOf(InvocationTargetException.class);
        }
    }
}
