import item50.Period;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Date;

/**
 * Created by Choen-hee Park
 * User : chpark
 * Date : 2021/05/11
 * Time : 5:10 PM
 */

class PeroidTest {
    @Test
    @DisplayName("Period 가변식의 문제가 발견되는지 확인")
    void validMutablePeriod() {
        Date start = new Date(2021 - 1900, 5, 1);
        Date end = new Date(2021 - 1900, 5, 10);

        long originalStartTime = start.getTime();

        Period period = new Period(start, end);
        Date newStart = period.start();
        // newStart가 Period의 start 객체에 접근하여 객체가 가리키는 값을 변경하였다.
        // 따라서 Peroid 객체 내부에 저장되어 있는 start 객체의 값은 변경되었다.
        newStart.setDate(20);

        long modifiedStartTime = period.start().getTime();

        Assertions.assertThat(originalStartTime).isEqualTo(modifiedStartTime);
    }
}
