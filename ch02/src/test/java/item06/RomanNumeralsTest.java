package item06;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * Created by Choen-hee Park
 * User : chpark
 * Date : 2021/05/15
 * Time : 3:46 PM
 */

public class RomanNumeralsTest {
    @Test
    @DisplayName("문자열이 유효한 로마 숫자인지 확인")
    void checkStringIsRomanNumber() {
        System.out.println(RomanNumerals.isRomanNumeral("I"));
        System.out.println(RomanNumerals.isRomanNumeral("XV"));
        System.out.println(RomanNumerals.isRomanNumeral("XII"));
        System.out.println(RomanNumerals.isRomanNumeral("VIX"));
    }
}
