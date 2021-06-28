package item28;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

class ChooserArrayTest {
	@Test
	@DisplayName("ChooserArray는 런타임에 타입캐스팅 예외가 발생할 수 있다")
	void chooserArrayIsTypeCastringWhenRuntime() {
		List<Integer> integerList = Arrays.asList(100, 200, 300);
		ChooserArray chooserArray = new ChooserArray(integerList);

		Assertions.assertThatThrownBy(() -> {
			String selectedItem = (String) chooserArray.choose();		// Integer to String : Type-Casting-Exception
			System.out.println(selectedItem);
		}).isInstanceOf(ClassCastException.class);
	}
}
