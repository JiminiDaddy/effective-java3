package item01.exam1;

import item01.exam1.domain.Person;
import item01.exam1.util.PersonStorage;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * Created by Choen-hee Park
 * User : chpark
 * Date : 2021/04/29
 * Time : 1:16 AM
 */

class PersonStorageTest {
    @Test
    @DisplayName("정적팩터리메서드 생성, 저장, 조회가 잘 되는지")
    void checkStaticFactoryMethod() {
        Person employee = PersonStorage.createEmployee("Employee1");
        Person student = PersonStorage.createStudent("Student1");
        PersonStorage.save(employee);
        PersonStorage.save(student);

        Person savedEmployee = PersonStorage.find(employee.getName());
        Person savedStudent = PersonStorage.find(student.getName());

        Assertions.assertThat(savedEmployee).isEqualTo(employee);
        Assertions.assertThat(savedStudent).isEqualTo(student);
    }
}
