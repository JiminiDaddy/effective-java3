package item08;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * Created by Choen-hee Park
 * User : chpark
 * Date : 2021/05/17
 * Time : 2:40 PM
 */

public class RoomTest {
    @Test
    @DisplayName("try-with-ressource사용 후 close가 제대로 되는지 확인")
    void checkCloseWithTryCatchResources() throws Exception {
        try (Room room = new Room(100)) {
            System.out.println("RoomTest.checkCloseWithCatchResources");
        }
    }

    @Test
    @DisplayName("try-resource없이 close가 제대로 되는지 확인")
    void checkCloseNotTryCatchResources() throws Exception {
        Room room = new Room(100);
        System.out.println("RoomTest.checkCloseNotTryCatchResources");
    }
}
