package item50;

/**
 * Created by Choen-hee Park
 * User : chpark
 * Date : 2021/05/12
 * Time : 10:33 PM
 */

public class PetClinic {
    private Pet pet;

    public PetClinic(Pet pet) {
        // Pet Class가 상속 가능하다면? (final class가 아닌경우)
        // 상속받은 Class에서 clone을 재구현하고 있다면?
        // clone()을 통해 shallow copy를 한다면 PetClinic의 멤버는 Pet 타입인데 실제로 cloning된 객체는 Pet의 하위 타입이 될 수 있다.
        this.pet = new Pet(pet.getName());
    }

    public Pet customer() throws CloneNotSupportedException {
        // 생성자에서 방어적 복사본을 통해 pet 객체가 Pet 타입이라고 확신할 수 있기 때문에 clone()을 반환해도 불변을 유지할 수 있다.
        return (Pet) pet.clone();
    }
}
