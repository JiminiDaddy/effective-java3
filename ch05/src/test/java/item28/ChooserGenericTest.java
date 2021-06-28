package item28;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

class ChooserGenericTest {
	@Test
	@DisplayName("ChooserGeneric은 컴파일에 타입캐스팅을 체크할 수 있다")
	void chooserGenericIsTypeCastingWhenCompile() {
		List<Integer> integerList = Arrays.asList(100, 200, 300);
		ChooserGeneric<Integer> chooserGeneric = new ChooserGeneric<>(integerList);		// type unchecked
		//String str = (String) chooserGeneric.choose();		// T 타입으로 반환하므로 컴파일 오류가 발생한다.
	}
}
