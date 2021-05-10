package item01.exam1.repository;

import item01.exam1.domain.Person;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Choen-hee Park
 * User : chpark
 * Date : 2021/04/29
 * Time : 12:22 AM
 */

public class MemoryRepository implements Repository{
    private Map<String, Person> persons = new HashMap<>();

    @Override
    public void save(Person person) {
        persons.put(person.getName(), person);
    }

    @Override
    public Person find(String personName) {
        return persons.get(personName);
    }
}
