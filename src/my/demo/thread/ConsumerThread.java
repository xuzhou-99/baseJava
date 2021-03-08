package my.demo.thread;

import my.demo.collection.MyStack;

/**
 * @author xuzhou
 * @version 1.0.0
 * @title ConsumerThread
 * @date 2021/3/8 14:53
 */
public class ConsumerThread extends Thread {
    private MyStack<Character> stack;

    public ConsumerThread(MyStack<Character> stack, String name) {
        super(name);
        this.stack = stack;
    }

    @Override
    public void run() {
        while (true) {
            char c = stack.pull();
            System.out.println(this.getName() + "pull :" + c);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
