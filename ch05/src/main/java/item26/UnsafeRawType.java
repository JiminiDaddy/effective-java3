package item26;

import java.util.ArrayList;
import java.util.List;

public class UnsafeRawType {
	public static void main(String[] args) {
		List<String> strings = new ArrayList<>();

		unsafeAdd(strings, Integer.valueOf(100));		// runtime error!
		//safeAdd(strings, Integer.valueOf(100));		// compile error!
		String item = strings.get(0);
		System.out.println(item);
	}

	// strings가 매개변수로 Raw Type인 List를 전달받았다.
	private static void unsafeAdd(List strings, Object object) {
		strings.add(object);
	}

	private static void safeAdd(List<Object> strings, Object object) {
		strings.add(object);
	}
}
