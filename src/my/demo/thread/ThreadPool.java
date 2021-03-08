package my.demo.thread;

import java.util.LinkedList;

/**
 * @author xuzhou
 * @version 1.0.0
 * @title ThreadPool
 * @date 2021/3/8 15:07
 */
public class ThreadPool {
    /**
     * thread pool size
     */
    int threadPoolSize;

    /**
     * task container
     */
    LinkedList<Runnable> tasks = new LinkedList<>();

    public ThreadPool() {
        threadPoolSize = 10;
        // start 10 thread to consumer task
        synchronized (tasks) {
            for (int i = 0; i < threadPoolSize; i++) {
                new TaskConsumerThread("task consumer thread " + i).start();
            }
        }
    }

    public void add(Runnable r) {
        synchronized (tasks) {
            tasks.add(r);
            // wake up all taskConsumerThreads
            tasks.notifyAll();
        }
    }


    class TaskConsumerThread extends Thread {
        Runnable task;

        public TaskConsumerThread(String name) {
            super(name);
        }

        @Override
        public void run() {
            System.out.println("start: " + this.getName());
            while (true) {
                synchronized (tasks) {
                    while (tasks.isEmpty()) {
                        try {
                            tasks.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                    task = tasks.removeLast();
                    // wake up all taskConsumerThreads
                    tasks.notifyAll();

                }
                System.out.println(this.getName() + " get task and execute");
                task.run();
            }
        }
    }
}
