package my.demo.collection;

import java.util.LinkedList;

/**
 * @author xuzhou
 * @version 1.0.0
 * @title MyStack
 * @date 2021/3/1 18:10
 */
public class MyStack<T> {

    LinkedList<T> values = new LinkedList<>();


    public void push(T t) {
        values.add(t);
    }


    public T pull() {
        return values.removeLast();
    }


    public T peek() {
        return values.getLast();
    }
}
