package item26;

import java.util.*;

public class UnboundedWildCardType {
	public static void main(String[] args) {
		Set<Integer> numbers = new HashSet<>();
		for (int i = 1; i <= 10; ++i) {
			if (i % 2 == 0)	 {
				numbers.add(i);		// 2, 4, 6, 8, 10
			}
		}

		Set<Integer> numbers2 = new HashSet<>();
		for (int i = 1; i <= 10; ++i) {
			if (i % 4 == 0) {
				numbers2.add(i);	// 4, 8
			}
		}
		System.out.println("number2: " + getDuplicatedNumberCount(numbers, numbers2));
		for (Integer number : numbers2) {
			System.out.println("item: " + number);
		}

		Set<String> numbers3 = new HashSet<>();
		for (int i = 1; i <= 10; ++i) {
			if (i % 4 == 0) {
				numbers3.add(String.valueOf(i));	// "4", "8"
			}
		}

		//System.out.println("number3: " + getDuplicatedNumberCount(numbers, numbers3));
		// number3의 제네릭 타입은 String인데 getDuplicatedNumberCount에서 Integer 타입이 원소에 추가되었으므로
		// Runtime 중 ClassCastException이 발생한다.
		for (String number : numbers3) {
			System.out.println("item: " + number);
		}

		// 아래와 같이 비한정적 와일드카드를 사용하면 모든 타입을 받을 수 있는 Collection을 매개변수로 사용할 수 있지만,
		// 타입을 체크하여 타입 불변식을 보장한다.
		// 따라서 null이 아닌 원소 타입을 추가하려고 할 경우 컴파일 오류가 발생한다.
		System.out.println("number3: " + getDuplicatedNumberCountWithWildcard(numbers, numbers3));
	}

	private static int getDuplicatedNumberCount(Set numbers, Set numbers2) {
		int count = 0;
		for  (Object o1 : numbers) {
			if (numbers2.contains(o1))	 {
				++count;
			} else {
				numbers2.add(o1);
			}
		}
		return count;
	}

	private static int getDuplicatedNumberCountWithWildcard(Set<?> numbers, Set<?> numbers2) {
		int count = 0;
		for  (Object o1 : numbers) {
			if (numbers2.contains(o1))	 {
				++count;
			}
			/*
			else {
				numbers2.add(o1);	// type error
			}
			*/
		}
		return count;
	}
}
