package item06;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by Choen-hee Park
 * User : chpark
 * Date : 2021/05/15
 * Time : 3:39 PM
 */

public class KeySetTest {
    @Test
    @DisplayName("Map.keySet() 의 반환값은 항상 같은 인스턴스인지 확인")
    void testKeySetIsSameInstance() {
        Map<String,Integer> map = new HashMap<>();
        map.putIfAbsent("A", 1);
        map.putIfAbsent("B", 2);
        map.putIfAbsent("C", 3);
        map.putIfAbsent("D", 4);

        Set<String> set1 = map.keySet();
        Set<String> set2 = map.keySet();
        Assertions.assertThat(set1).isSameAs(set2);
        set1.remove("A");
        Assertions.assertThat(set1.size()).isEqualTo(set2.size());
    }
}
