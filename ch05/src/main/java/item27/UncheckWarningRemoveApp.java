package item27;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class UncheckWarningRemoveApp {
	private static String[] names = new String[3];

	public static void main(String[] args) {
		// Java7 이후부터는 <>로 선언해줘도 Compiler가 타입 매개변수를 추론해준다.
		Set<String> stringSet = new HashSet<>();

		names[0] = "AAA";
		names[1] = "BBB";
		names[2] = "CCC";

		String[] buffer = new String[2];
		String[] newBuffer = toArray(buffer);
		for (String s : newBuffer) {
			System.out.println("s: " + s);
		}
	}

	private static <T> T[] toArray(T[] buffer) {
		if (buffer.length < names.length) {
			// @SupressWarnings는 선언부에만 달 수 있기때문에 return문에는 달 수 없다.
			// 따라서 반환값을 지역변수로 참조하고, 지역변수를 반환해준다.
			@SuppressWarnings("unchecked")
			T[] result = (T[]) Arrays.copyOf(names, names.length, buffer.getClass());
			return result;
			//return (T[]) Arrays.copyOf(names, names.length, buffer.getClass());
		}
		System.arraycopy(names, 0, buffer, 0, names.length);
		if (buffer.length > names.length) {
			buffer[names.length] = null;
		}
		return buffer;
	}
}
