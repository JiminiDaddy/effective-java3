package item06;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * Created by Choen-hee Park
 * User : chpark
 * Date : 2021/05/15
 * Time : 3:23 PM
 */

public class AutoBoxingTest {
    @Test
    @DisplayName("오토박싱, 언박싱이 반복해서 일어날 때 성능이 떨어지는지 확인")
    void checkAutoBoxingPerfomance() {
        Long sum = 0L;
        long startTime = System.currentTimeMillis();
        long result1 = sumAllIntegerByBoxing(sum);
        System.out.println("wasted<Boxing>: " + (System.currentTimeMillis() - startTime));

        long sum2 = 0;
        startTime = System.currentTimeMillis();
        long result2 = sumAllIntegerByUnboxing(sum2);
        System.out.println("wasted<Unboxing>: " + (System.currentTimeMillis() - startTime));

        Assertions.assertThat(result1).isEqualTo(result2);
    }

    private long sumAllIntegerByBoxing(Long sum) {
        for (long i = 0; i < Integer.MAX_VALUE; ++i) {
            // 이 과정에서 불필요한 Long 오토박싱된 객체가 생성된다.
            sum += i;
        }
        return sum;
    }

     private long sumAllIntegerByUnboxing(long sum) {
        for (long i = 0; i < Integer.MAX_VALUE; ++i) {
            sum += i;
        }
        return sum;
    }
}
