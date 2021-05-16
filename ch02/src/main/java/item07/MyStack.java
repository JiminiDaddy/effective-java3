package item07;

import java.util.Arrays;
import java.util.EmptyStackException;

/**
 * Created by Choen-hee Park
 * User : chpark
 * Date : 2021/05/16
 * Time : 1:49 PM
 */

public class MyStack<T> {
    private static final int DEFULT_STACK_SIZE = 16;
    private Object[] elements;
    private int size = 0;

    public MyStack() {
        elements = new Object[DEFULT_STACK_SIZE];
    }

    public void push(T item) {
        ensureCapacity();
        elements[size++] = item;
    }

    public Object pop() {
        if (size == 0) {
            throw new EmptyStackException();
        }
        Object item = elements[--size];
        elements[size] = null;
        return item;
    }

    public int size() {
        return size;
    }

    private void ensureCapacity() {
        if (elements.length == size) {
            elements = Arrays.copyOf(elements, 2 * size + 1);
        }
    }
}
