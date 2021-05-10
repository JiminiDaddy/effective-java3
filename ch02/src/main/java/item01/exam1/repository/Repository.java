package item01.exam1.repository;

import item01.exam1.domain.Person;

/**
 * Created by Choen-hee Park
 * User : chpark
 * Date : 2021/04/29
 * Time : 12:09 AM
 */

public interface Repository {
    void save(Person person);

    Person find(String personName);
}
