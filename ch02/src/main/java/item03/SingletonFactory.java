package item03;

import java.io.Serializable;

/**
 * Created by Choen-hee Park
 * User : chpark
 * Date : 2021/05/13
 * Time : 2:47 PM
 */

public class SingletonFactory implements Serializable {
    private static final SingletonFactory INSTANCE = new SingletonFactory();

    private SingletonFactory() {
        System.out.println("SingletonFactory.SingletonFactory");
    }

    public static SingletonFactory getInstance() {
        return INSTANCE;
    }

    // for Deserialization
    private Object readResolve() {
        System.out.println("SingletonFactory.readResolve");
        return INSTANCE;
    }

    // for Serialization
    private Object writeReplace() {
        System.out.println("SingletonFactory.writeReplace");
        return INSTANCE;
    }
}
