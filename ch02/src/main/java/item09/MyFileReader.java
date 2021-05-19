package item09;

/**
 * Created by Choen-hee Park
 * User : chpark
 * Date : 2021/05/19
 * Time : 11:37 PM
 */

public class MyFileReader implements AutoCloseable{
    @Override
    public void close() {
        System.out.println("MyFileReader.close");
    }
}
