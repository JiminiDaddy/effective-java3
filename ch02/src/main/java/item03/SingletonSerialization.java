package item03;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * Created by Choen-hee Park
 * User : chpark
 * Date : 2021/05/13
 * Time : 11:51 PM
 */

public class SingletonSerialization {

    // Object to ByteArray
    public byte[] serialize(Object instance) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try (byteArrayOutputStream; ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream)){
           objectOutputStream.writeObject(instance);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return byteArrayOutputStream.toByteArray();
    }

    // ByteArray to Object
    public Object deSerialize(byte[] seriailizedData) {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(seriailizedData);
        try (byteArrayInputStream; ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream)) {
           return objectInputStream.readObject() ;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
