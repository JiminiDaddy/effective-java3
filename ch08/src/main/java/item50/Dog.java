package item50;

/**
 * Created by Choen-hee Park
 * User : chpark
 * Date : 2021/05/11
 * Time : 5:32 PM
 */

public class Dog extends Pet implements Cloneable{
    public Dog(String name) {
        super(name);
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return this;
    }
}
