package item27;

import java.util.*;

public class UncheckWarningRemoveApp<E> {
	private E[] names = (E[]) new Object[3];

	public static void main(String[] args) {
		// Java7 이후부터는 <>로 선언해줘도 Compiler가 타입 매개변수를 추론해준다.
		Set<String> stringSet = new HashSet<>();

		UncheckWarningRemoveApp<String> uncheckWarningRemoveApp = new UncheckWarningRemoveApp<>();
		uncheckWarningRemoveApp.add(0, "AAA");

		Integer[] buffer = new Integer[2];
		Integer[] newBuffer = uncheckWarningRemoveApp.toArray(buffer);
		if (newBuffer != null) {
			for (Integer s : newBuffer) {
				System.out.println("s: " + s);
			}
		}

		Integer[] numbers = new Integer[5];
		// ArrayList의 타입과 toArray에서 반환될 타입이 다르므로 런타임 오류가 발생한다.
		List<String> list = new ArrayList<>();
		list.add("100");
		list.add("200");
		list.add("300");
		// 경고메시지 발생: Array of type 'java.lang.String[] expected
		// String 타입의 list인데 Integer타입을 넘겼기 때문
		Integer[] result = list.toArray(numbers);
		for (Integer a : result) {
			System.out.println("result: " + a);
		}
	}

	private void add(int index, E item) {
		if (index >= names.length) return;
		names[index] = item;
	}

	private <T> T[] toArray(T[] buffer) {
		if (buffer.length < names.length) {
			String orgBufferType = names.getClass().getTypeName();
			String newBufferType = buffer.getClass().getTypeName();
			// 원본과 복사본의 타입이 불일치하는경우 null을 반환했다.
			if (!orgBufferType.equals(newBufferType)) {
				// TODO null safe한 값으로 반환해야 한다.
				return null;
			}
			@SuppressWarnings("unchecked")
			T[] result = (T[]) Arrays.copyOf(names, names.length, buffer.getClass());
			// names는 E 타입이지만, buffer가 T 타입이기때문에 경고 메시지가 발생된다.
			return result;
		}
		System.arraycopy(names, 0, buffer, 0, names.length);
		if (buffer.length > names.length) {
			buffer[names.length] = null;
		}
		return buffer;
	}
}
