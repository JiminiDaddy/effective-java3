package item28;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class Item28Test {
	@Test
	@DisplayName("배열은 공변으로 타입캐스팅이 런타임에 오류난다")
	void arrayIsCovariant() {
		Object[] objects = new Long[1];
		Assertions.assertThatThrownBy(() -> {
			objects[0] = "Long에 String을 쓰면 런타임에 캐스팅 오류난다";
		}).isInstanceOf(ArrayStoreException.class);
	}

	@Test
	@DisplayName("제네릭은 불공변으로 타입캐스팅이 컴파일에 오류난다")
	void genericIsIncovariant() {
		//List<Object> objects = new ArrayList<Long>();	// compile error

		//List<Long> objects = new ArrayList<>();	// compile error
		//objects.add("Long에 String을 쓰면 컴파일에 오류난다");
	}

	@Test
	@DisplayName("제네릭 배열 생성은 허용되지 않는다")
	void genericArrayIsDeny() {
		//List<String>[] stringList = new ArrayList<String>[1];	// compile error
		List<String>[] stringList = new ArrayList[1];	// type unchecked warning
		Object[] objects = stringList;

		//List<Integer> intList = List.of(100);
		//objects[0] = intList;			// ArrayStoreException
		List<Integer> intList = new ArrayList<>();
		intList.add(100);

		objects[0] = intList;

		Assertions.assertThatThrownBy(() -> {
			String str = stringList[0].get(0);		// Integer로 꺼낸 원소를 String으로 Casting하므로 런타임 오류!
		}).isInstanceOf(ClassCastException.class);
	}
}
