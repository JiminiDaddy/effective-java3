package item03;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * Created by Choen-hee Park
 * User : chpark
 * Date : 2021/05/13
 * Time : 11:49 PM
 */

class SingletonSerializationTest {
    @Test
    @DisplayName("직렬화해도 싱글톤이 유지되는지 확인")
    void checkSingletonWhenSerialization() {
        SingletonSerialization singletonSerialization = new SingletonSerialization();
        SingletonFactory factory = SingletonFactory.getInstance();

        byte[] serializedData = singletonSerialization.serialize(factory);
        SingletonFactory deserializedData = (SingletonFactory)singletonSerialization.deSerialize(serializedData);

        Assertions.assertThat(factory).isExactlyInstanceOf(SingletonFactory.class);
        Assertions.assertThat(factory).isSameAs(deserializedData);
    }
}
