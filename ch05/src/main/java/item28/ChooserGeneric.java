package item28;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

class ChooserGeneric<T> {
	//private final T[] choices;
	private final List<T> choices;

	ChooserGeneric(Collection<T> collection) {
		//this.choices = (T[]) collection.toArray();		// Type unchecked warning
		this.choices = new ArrayList<>(collection);		// choices와 collection은 같은 타입이 되므로 타입 안정성이 보장된다.
	}

	// Object가 아닌 T 타입으로 반환하므로 호출하는 쪽에서 형변환이 필요없다. 타입이 다르면 컴파일 오류를 내뱉을 것이다.
	T choose() {
		Random random = ThreadLocalRandom.current();
		//return choices[random.nextInt(choices.length)];
		return choices.get(random.nextInt(choices.size()));
	}
}
