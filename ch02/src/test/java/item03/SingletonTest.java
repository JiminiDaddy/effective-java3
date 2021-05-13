package item03;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

/**
 * Created by Choen-hee Park
 * User : chpark
 * Date : 2021/05/13
 * Time : 2:48 PM
 */

class SingletonTest {
    @Test
    @DisplayName("Filed타입 싱글톤이 제대로 만들어지는지 확인")
    void checkCreateSingletonField() {
        SingletonField singletonField1 = SingletonField.INSTANCE;

        SingletonField singletonField2 = SingletonField.INSTANCE;

        assertThat(singletonField1).isSameAs(singletonField2);
    }

    @Test
    @DisplayName("정적팩터리 타입의 싱글톤이 제대로 만들어지는지 확인")
    void checkCreateSingletonStaticFactory() throws IllegalAccessException, InvocationTargetException, InstantiationException {
        SingletonFactory singletonFactory1 = SingletonFactory.getInstance();
        SingletonFactory singletonFactory2 = SingletonFactory.getInstance();

        assertThat(singletonFactory1).isSameAs(singletonFactory2);

        Class c1 = singletonFactory1.getClass();
        Constructor[] constructors = c1.getDeclaredConstructors();
        for (Constructor constructor : constructors) {
            constructor.setAccessible(true);
        }
        SingletonFactory newInstance = (SingletonFactory) constructors[0].newInstance();
        // 생성자 예외를 하지 않았으므로 두 인스턴스는 다른 인스턴스다. (싱글턴 깨짐)
        assertThat(singletonFactory1).isNotSameAs(newInstance);
    }

    @Test
    @DisplayName("Enum 타입의 싱글톤이 제대로 만들어지는지 확인")
    void checkCreateSingletonEnum() {
        SingletonEnum singletonEnum1 = SingletonEnum.INSTANCE;
        SingletonEnum singletonEnum2 = SingletonEnum.INSTANCE;

        assertThat(singletonEnum1).isSameAs(singletonEnum2);

        Class c1 = singletonEnum1.getClass();
        Constructor[] constructors = c1.getDeclaredConstructors();
        for (Constructor constructor : constructors) {
            constructor.setAccessible(true);
        }
        // Java8에서 Reflection을 통해 Enum Class를 인스터화할 수 없다.
        assertThatThrownBy(() -> {
            SingletonEnum newInstance = (SingletonEnum) constructors[0].newInstance();
        }).isExactlyInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("리플렉션 공격을 피할 수 있는지 확인")
    void checkCreateSingletonByReflectionAttack() throws IllegalAccessException, InvocationTargetException, InstantiationException {
        SingletonField singletonField1 = SingletonField.INSTANCE;

        Class c1 = singletonField1.getClass();
        Constructor[] constructors = c1.getDeclaredConstructors();
        for (Constructor constructor : constructors) {
            constructor.setAccessible(true);
        }

        // 생성자 예외처리하지 않으면 리플렉션으로 인해 아래 코드가 수행되며 생성자는 2번 호출하게 된다.
        //SingletonField newInstance = (SingletonField) constructors[0].newInstance();
        //assertThat(singletonField1).isNotSameAs(newInstance);

        assertThatThrownBy(() -> {
            // 리플렉션으로 Private 생성자에 접근하면 예외가 발생한다.
            SingletonField newInstance = (SingletonField) constructors[0].newInstance();
        }).isInstanceOf(Exception.class);
    }

}
