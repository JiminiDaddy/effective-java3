package item06;

import java.util.regex.Pattern;

/**
 * Created by Choen-hee Park
 * User : chpark
 * Date : 2021/05/15
 * Time : 3:44 PM
 */

public class RomanNumerals {
    private static final Pattern ROMAN = Pattern.compile(
            "^(?=.)M*(c[MD]|D?C{0,3})"
            + "(X[CL]|L?X{0,3})(I[XV]|V?I{0,3})$");

    static boolean isRomanNumeral(String s) {
        return ROMAN.matcher(s).matches();
    }
}
