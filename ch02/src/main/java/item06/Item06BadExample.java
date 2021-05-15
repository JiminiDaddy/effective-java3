package item06;

/**
 * Created by Choen-hee Park
 * User : chpark
 * Date : 2021/05/15
 * Time : 3:52 PM
 */

public class Item06BadExample {
    public static void main(String[] args) {
        String s1 = "Hello";
        String s2 = new String("Hello");
        System.out.println(s1.equals(s2) + " " + (s1 == s2));
        System.out.println(s1.equals(s2) + " " + (s1.intern() == s2.intern()));

        Boolean b1 = Boolean.valueOf("TRUE");
        Boolean b2 = new Boolean("TRUE");
        Boolean b3 = Boolean.valueOf("TRUE");
        System.out.println(b1 + " " + b2);
        System.out.println(b1 == b3);

        Long l1 = Long.valueOf("1000");
    }
}
