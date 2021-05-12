import item50.Dog;
import item50.Pet;
import item50.PetClinic;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * Created by Choen-hee Park
 * User : chpark
 * Date : 2021/05/12
 * Time : 10:41 PM
 */

class PetClinicTest {
    @Test
    @DisplayName("PetClinic의 customer가 제대로 조회되는지 확인")
    void validPetclinicCustomer() throws CloneNotSupportedException {
        Pet dog = new Dog("dog");

        String originalPetName = dog.getName();

        PetClinic petClinic = new PetClinic(dog);
        Pet customer = petClinic.customer();
        customer.changename("new dog");

        String customerPetName = petClinic.customer().getName();

        Assertions.assertThat(customerPetName).isEqualTo(originalPetName);
    }
}
