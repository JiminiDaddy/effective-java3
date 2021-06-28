package item28;

import java.util.Collection;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

class ChooserArray {
	private final Object[] choiceArray;

	ChooserArray(Collection collection) {
		choiceArray = collection.toArray();
	}

	Object choose() {
		Random random = ThreadLocalRandom.current();
		return choiceArray[random.nextInt(choiceArray.length)];
	}
}
