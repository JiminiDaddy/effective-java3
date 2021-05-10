package item01.exam1.util;

import item01.exam1.domain.Employee;
import item01.exam1.domain.Person;
import item01.exam1.domain.Student;
import item01.exam1.repository.MemoryRepository;
import item01.exam1.repository.Repository;

/**
 * Created by Choen-hee Park
 * Person : chpark
 * Date : 2021/04/29
 * Time : 12:29 AM
 */

public class PersonStorage {
    private static Repository repository = new MemoryRepository();

    private PersonStorage() {}

    public static void save(Person person) {
        repository.save(person);
    }

    public static Person find(String personName) {
        return repository.find(personName);
    }

    public static Person createEmployee(String name) {
        return new Employee(name);
    }

    public static Person createStudent(String name) {
        return new Student(name);
    }
}
