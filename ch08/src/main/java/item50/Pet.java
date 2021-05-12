package item50;

/**
 * Created by Choen-hee Park
 * User : chpark
 * Date : 2021/05/11
 * Time : 5:31 PM
 */

public class Pet implements Cloneable {
    private String name;

    Pet(String name) {
        this.name = name;
    }

    public void changename(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
