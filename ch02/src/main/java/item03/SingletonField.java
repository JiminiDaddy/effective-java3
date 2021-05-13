package item03;

import java.nio.file.AccessDeniedException;

/**
 * Created by Choen-hee Park
 * User : chpark
 * Date : 2021/05/13
 * Time : 2:46 PM
 */

public class SingletonField {
    public static SingletonField INSTANCE;

    static {
        try {
            INSTANCE = new SingletonField();
        } catch (AccessDeniedException e) {
            e.printStackTrace();
        }
    }

    private SingletonField() throws AccessDeniedException {
        if (INSTANCE != null) {
            throw new AccessDeniedException("This is a singleton-object");
        }
        System.out.println("SingletonField.SingletonField");
    }
}
