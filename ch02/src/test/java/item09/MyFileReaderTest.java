package item09;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * Created by Choen-hee Park
 * User : chpark
 * Date : 2021/05/19
 * Time : 11:38 PM
 */

public class MyFileReaderTest {
    @Test
    @DisplayName("try-with-resources사용시 제대로 close가 호출되는지 확인")
    void checkCalledCloseWithTryReosurces() {
       try(MyFileReader myFileReader = new MyFileReader()) {
       } catch (Exception e) {
           e.printStackTrace();
       }
    }

    @Test
    @DisplayName("try-finally제대로 close가 호출안되는지 확인")
    void checknotCalledCloseWithTryFinally() {
        MyFileReader myFileReader = null;
       try {
           myFileReader = new MyFileReader();
       } catch (Exception e) {
           e.printStackTrace();
       } finally {
           if (myFileReader != null) {
               myFileReader.close();
           }
       }
    }
}
