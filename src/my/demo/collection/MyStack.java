package my.demo.collection;

import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author xuzhou
 * @version 1.0.0
 * @title MyStack
 * @date 2021/3/1 18:10
 */
public class MyStack<T> {

    LinkedList<T> values = new LinkedList<>();

    Lock lock = new ReentrantLock();
    private Condition codition = lock.newCondition();

    public synchronized void push(T t) {
        while (values.size() >= 200) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        values.add(t);

        this.notifyAll();
    }

    public synchronized T pull() {
        while (values.size() == 0) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.notifyAll();
        return values.removeLast();
    }

    public void push1(T t) {

        try {
            lock.lock();
            values.add(t);
        } finally {
            lock.unlock();
        }
    }

    public T pull1() {

        try {
            lock.lock();
            return values.removeLast();
        } finally {
            lock.unlock();
        }
    }


    public void push2(T t) {
        while (values.size() >= 200) {
            try {
                lock.lock();
                codition.await();
                lock.unlock();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        lock.lock();
        values.addLast(t);
        codition.signalAll();
        lock.unlock();
    }

    public T pull2() {
        while (values.size() == 0) {
            try {
                lock.lock();
                codition.await();
                lock.unlock();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        lock.lock();
        codition.signalAll();
        T t = values.removeLast();
        lock.unlock();
        return t;
    }

    public synchronized T peek() {
        return values.getLast();
    }
}
