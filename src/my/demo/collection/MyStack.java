package my.demo.collection;

import java.util.LinkedList;

/**
 * @author xuzhou
 * @version 1.0.0
 * @title MyStack
 * @date 2021/3/1 18:10
 */
public class MyStack implements Stack {

    static LinkedList<Hero> heroLinkedList = new LinkedList<>();

    @Override
    public void push(Hero hero) {
        heroLinkedList.add(hero);
    }

    @Override
    public Hero pull() {
        return heroLinkedList.getLast();
    }

    @Override
    public Hero peek() {
        return heroLinkedList.removeLast();
    }
}
