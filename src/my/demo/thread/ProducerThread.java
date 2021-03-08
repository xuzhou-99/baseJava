package my.demo.thread;

import my.demo.collection.MyStack;

/**
 * @author xuzhou
 * @version 1.0.0
 * @title Producer
 * @date 2021/3/8 14:45
 */
public class ProducerThread extends Thread {
    private MyStack<Character> stack;

    public ProducerThread(MyStack<Character> stack, String name) {
        super(name);
        this.stack = stack;
    }

    @Override
    public void run() {
        while (true) {
            char c = randomChar();
            System.out.println(this.getName() + " push into: " + c);
            stack.push(c);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

    private char randomChar() {
        return (char) ('A' + Math.random() * ('Z' + 1 - 'A'));
    }
}
