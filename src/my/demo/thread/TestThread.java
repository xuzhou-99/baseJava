package my.demo.thread;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

import my.demo.collection.MyStack;
import my.demo.entity.Hero;

/**
 * @author xuzhou
 * @version 1.0.0
 * @title TestThread
 * @date 2021/3/5 14:36
 */
public class TestThread {
    public static void main(String[] args) {
//        singleThread();

//        multithreading();

//        multithreading2();

//        multithreading3();

//        testThread();

//        testDaemonThread();

//        Hero gg = new Hero("gg");
//        gg.aDuGen();

//        for (int i = 0; i < 10; i++) {
//            testSynchronous();
//        }

//        deadlock();
//        deadlock2();

//        testSynchronous3();

//        testSynchronized();

//        producerAndConsumer();

//        testThreadPool();

//        testThreadPool2();

//        testThreadPool3();

//        testLock();

//        testTryLock();

        testLockCondition();
    }

    /**
     * 同步-lock condition
     * await, signal, signalAll
     */
    public static void testLockCondition() {
        ReentrantLock lock = new ReentrantLock();
        Condition condition = lock.newCondition();

        Thread t1 = new Thread(() -> {

            try {
                log("线程启动");
                log("试图占有对象：lock");

                lock.lock();

                // try to occupy the lock
                log("占有对象：lock");
                log("进行5秒的操作");
                Thread.sleep(5 * 1000);
                log("临时释放对象lock，并等待");
                condition.await();
                log("重写占有对象lock，并进行5秒的业务操作");
                Thread.sleep(5 * 1000);

            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {

                log("释放对象：lock");
                // release the lock
                lock.unlock();
            }
            log("线程结束");
        });
        t1.setName("t1");
        t1.start();

        Thread t2 = new Thread(() -> {
            try {
                log("线程启动");
                log("试图占有对象：lock");

                lock.lock();

                // try to occupy the lock
                log("占有对象：lock");
                log("进行5秒的操作");
                Thread.sleep(5 * 1000);
                log("临时释放对象lock，并等待");
                condition.signal();
                log("重写占有对象lock，并进行5秒的业务操作");
                Thread.sleep(5 * 1000);

            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {

                log("释放对象：lock");
                // release the lock
                lock.unlock();

            }
            log("线程结束");
        });
        t2.setName("t2");
        t2.start();
    }

    /**
     * 同步-try lock
     * lock()  unlock()
     */
    public static void testTryLock() {
        ReentrantLock lock = new ReentrantLock();

        Thread t1 = new Thread(() -> {
            boolean locked = false;
            try {
                log("线程启动");
                log("试图占有对象：lock");

                // try to occupy the lock
                locked = lock.tryLock(1, TimeUnit.SECONDS);
                if (locked) {
                    log("占有对象：lock");
                    log("进行5秒的操作");
                    Thread.sleep(5 * 1000);
                } else {
                    log("经过1秒的努力，还是没有占有对象，放弃占有");
                }

            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                if (locked) {
                    log("释放对象：lock");
                    // release the lock
                    lock.unlock();
                }
            }
            log("线程结束");
        });
        t1.setName("t1");
        t1.start();

        Thread t2 = new Thread(() -> {
            boolean locked = false;
            try {
                log("线程启动");
                log("试图占有对象：lock");

                // try to occupy the lock
                locked = lock.tryLock(1, TimeUnit.SECONDS);
                if (locked) {
                    log("占有对象：lock");
                    log("进行5秒的操作");
                    Thread.sleep(5 * 1000);
                } else {
                    log("经过1秒的努力，还是没有占有对象，放弃占有");
                }

            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                if (locked) {
                    log("释放对象：lock");
                    // release the lock
                    lock.unlock();
                }
            }
            log("线程结束");
        });
        t2.setName("t2");
        t2.start();
    }

    /**
     * 同步-lock
     * lock()  unlock()
     */
    public static void testLock() {
        ReentrantLock lock = new ReentrantLock();

        Thread t1 = new Thread(() -> {
            try {
                log("线程启动");
                log("试图占有对象：lock");

                // occupy the lock
                lock.lock();

                log("占有对象：lock");
                log("进行5秒的操作");
                Thread.sleep(5 * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                log("释放对象：lock");
                // release the lock
                lock.unlock();
            }
            log("线程结束");
        });
        t1.setName("t1");
        t1.start();

        Thread t2 = new Thread(() -> {
            try {
                log("线程启动");
                log("试图占有对象：lock");

                // occupy the lock
                lock.lock();

                log("占有对象：lock");
                log("进行5秒的操作");
                Thread.sleep(5 * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                log("释放对象：lock");
                // release the lock
                lock.unlock();
            }
            log("线程结束");
        });
        t2.setName("t2");
        t2.start();
    }


    /**
     * 线程池-使用java自带的
     */
    public static void testThreadPool3() {
        ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(10, 15, 60,
                TimeUnit.SECONDS, new LinkedBlockingDeque<>());
        poolExecutor.execute(() -> System.out.println("task"));

    }

    public static void testThreadPool2() {
        ThreadPool threadPool = new ThreadPool();
        int sleep = 1000;
        int count = 0;
        while (count < 200) {
            Runnable runnable = () -> {
                // task
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            };

            threadPool.add(runnable);
            count++;

            try {
                Thread.sleep(sleep);
                sleep = sleep > 100 ? sleep - 100 : sleep;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 线程池-自定义
     */
    public static void testThreadPool() {
        ThreadPool threadPool = new ThreadPool();

        for (int i = 0; i < 5; i++) {
            Runnable runnable = () -> {
                // task
            };

            threadPool.add(runnable);

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * producer and consumer
     */
    public static void producerAndConsumer() {
        MyStack<Character> stack = new MyStack<>();
        new ProducerThread(stack, "Producer1").start();
        new ProducerThread(stack, "Producer2").start();
        new ConsumerThread(stack, "Consumer1").start();
        new ConsumerThread(stack, "Consumer2").start();
        new ConsumerThread(stack, "Consumer3").start();
    }

    /**
     * 同步
     * 1 回血
     * 1 受伤
     * 理论上应该是1000
     */
    public static void testSynchronous3() {

        Hero gareen = new Hero();
        gareen.name = "盖伦";
        gareen.hp = 500;
        gareen.damage = 50;

        System.out.println("gareen hp is :" + gareen.hp);


        // thread to add hp
        Thread t1 = new Thread(() -> {
            while (true) {
                gareen.recover();
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        });
        t1.start();


        // thread to reduce hp
        Thread t2 = new Thread(() -> {
            while (true) {
                gareen.hurt();
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        });
        t2.start();

    }

    /**
     * Deadlock
     */
    public static void deadlock2() {
        final Hero a = new Hero();
        a.name = "a";

        final Hero b = new Hero();
        b.name = "b";

        final Hero c = new Hero();
        c.name = "c";

        Thread t1 = new Thread(() -> {
            synchronized (a) {
                System.out.println("t1 already occupy a");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println("t1 try to occupy b");
                System.out.println("t1 is waiting...");
                synchronized (b) {
                    System.out.println("t1 do something");
                }
            }
        });

        Thread t2 = new Thread(() -> {
            synchronized (b) {
                System.out.println("t2 already occupy b");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println("t2 try to occupy c");
                System.out.println("t2 is waiting...");
                synchronized (c) {
                    System.out.println("t2 do someting");
                }
            }
        });

        Thread t3 = new Thread(() -> {
            synchronized (c) {
                System.out.println("t3 already occupy c");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println("t3 try to occupy a");
                System.out.println("t3 is waiting...");
                synchronized (a) {
                    System.out.println("t3 do someting");
                }
            }
        });

        t1.start();
        t2.start();
        t3.start();

    }

    /**
     * Deadlock
     */
    public static void deadlock() {
        final Hero ahri = new Hero();
        ahri.name = "九尾妖狐";

        final Hero annie = new Hero();
        annie.name = "安妮";

        Thread t1 = new Thread(() -> {
            synchronized (ahri) {
                System.out.println("t1 already occupy ahri");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println("t1 try to occupy annie");
                System.out.println("t1 is waiting...");
                synchronized (annie) {
                    System.out.println("t1 do something");
                }
            }
        });

        Thread t2 = new Thread(() -> {
            synchronized (annie) {
                System.out.println("t2 already occupy annie");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println("t2 try to occupy ahri");
                System.out.println("t2 is waiting...");
                synchronized (ahri) {
                    System.out.println("t2 do someting");
                }
            }
        });

        t1.start();
        t2.start();

    }

    public static void testSynchronized() {
        final Object someObject = new Object();

        Thread t1 = new Thread(() -> {
            System.out.println(now() + " t1 start run");
            System.out.println(now() + " t1 try to own Object: someObject");
            synchronized (someObject) {
                System.out.println(now() + " t1 own Object: someObject");
                try {
                    Thread.sleep(5 * 1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(now() + " t1 release Object: someObject");
            }
            System.out.println(now() + " t1 is end");
        });
        t1.setName(" t1");
        t1.start();


        Thread t2 = new Thread(() -> {
            System.out.println(now() + " t2 start run");
            System.out.println(now() + " t2 try to own Object: someObject");
            synchronized (someObject) {
                System.out.println(now() + " t2 own Object: someObject");
                try {
                    Thread.sleep(5 * 1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(now() + " t2 release Object: someObject");
            }
            System.out.println(now() + " t2 is end");
        });
        t2.setName(" t2");
        t2.start();
    }

    public static String now() {
        return new SimpleDateFormat("HH:mm:ss").format(new Date());
    }

    public static void log(String msg) {
        System.out.printf("%s %s %s %n", now(), Thread.currentThread().getName(), msg);
    }

    /**
     * 同步
     * 10000 回血
     * 10000 受伤
     * 理论上应该是10000
     * 同时操作一个对象，结果不是每次都相同
     */
    public static void testSynchronous() {
        // only one thread can occupy at the same time
        // other threads must wait
        final Object someObject = new Object();

        Hero gareen = new Hero();
        gareen.name = "盖伦";
        gareen.hp = 10000;
        gareen.damage = 50;

        System.out.println("gareen hp is :" + gareen.hp);

        int n = 10000;
        Thread[] recoverThreads = new Thread[n];
        Thread[] hurtThreads = new Thread[n];

        // n thread to add hp
        for (int i = 0; i < n; i++) {
            Thread thread = new Thread(() -> {
                synchronized (someObject) {
                    // try to occupy the object
                    // if it is occupied, wait forever
                    gareen.recover();
                }
//                gareen.recover();
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
            thread.start();
            recoverThreads[i] = thread;
        }

        // n thread to reduce hp
        for (int i = 0; i < n; i++) {
            Thread thread = new Thread(() -> {
                synchronized (someObject) {
                    // try to occupy the object
                    // if it is occupied, wait forever
                    gareen.hurt();
                }
//                gareen.hurt();
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
            thread.start();
            hurtThreads[i] = thread;
        }

        // waiting for all added threads to end
        for (Thread t : recoverThreads) {
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // waiting for all reduction threads to end
        for (Thread t : hurtThreads) {
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.format("%d个回血进程和%d个受伤进程结束后，盖伦的血量是：%.0f %n", n, n, gareen.hp);
    }

    /**
     * 守护线程
     */
    public static void testDaemonThread() {
        Thread thread = new Thread(() -> {

            int second = 0;
            while (true) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.format("Already play LOL about %d second %n", second++);
            }
        });
        // Set as a daemon thread
        thread.setDaemon(true);
        thread.start();
    }

    /**
     * 线程
     */
    public static void testThred() {
        Thread thread = new Thread(() -> {

            int second = 0;
            while (true) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.format("Already play LOL about %d second %n", second++);
            }
        });
        thread.start();
    }

    /**
     * 单线程
     */
    public static void singleThread() {
        Hero gareen = new Hero();
        gareen.name = "盖伦";
        gareen.hp = 600;
        gareen.damage = 50;

        Hero teemo = new Hero();
        teemo.name = "提莫";
        teemo.hp = 300;
        teemo.damage = 30;

        Hero bh = new Hero();
        bh.name = "赏金猎人";
        bh.hp = 500;
        bh.damage = 65;

        Hero leesion = new Hero();
        leesion.name = "盲僧";
        leesion.hp = 455;
        leesion.damage = 80;

        while (!teemo.isDead()) {
            gareen.attackHero(teemo);
        }

        while (!leesion.isDead()) {
            bh.attackHero(leesion);
        }
    }

    /**
     * 多线程-继承Thread
     */
    public static void multithreading() {
        Hero gareen = new Hero();
        gareen.name = "盖伦";
        gareen.hp = 600;
        gareen.damage = 50;

        Hero teemo = new Hero();
        teemo.name = "提莫";
        teemo.hp = 300;
        teemo.damage = 30;

        Hero bh = new Hero();
        bh.name = "赏金猎人";
        bh.hp = 500;
        bh.damage = 65;

        Hero leesion = new Hero();
        leesion.name = "盲僧";
        leesion.hp = 455;
        leesion.damage = 80;

        KillThread k1 = new KillThread(gareen, teemo);
        k1.start();

        KillThread k2 = new KillThread(bh, leesion);
        k2.start();

    }

    /**
     * 多线程-实现Runnable
     */
    public static void multithreading2() {
        Hero gareen = new Hero();
        gareen.name = "盖伦";
        gareen.hp = 600;
        gareen.damage = 50;

        Hero teemo = new Hero();
        teemo.name = "提莫";
        teemo.hp = 300;
        teemo.damage = 30;

        Hero bh = new Hero();
        bh.name = "赏金猎人";
        bh.hp = 500;
        bh.damage = 65;

        Hero leesion = new Hero();
        leesion.name = "盲僧";
        leesion.hp = 455;
        leesion.damage = 80;

        Battle k1 = new Battle(gareen, teemo);
        new Thread(k1).start();

        Battle k2 = new Battle(bh, leesion);
        new Thread(k2).start();

    }

    /**
     * 多线程-匿名类
     */
    public static void multithreading3() {
        Hero gareen = new Hero();
        gareen.name = "盖伦";
        gareen.hp = 600;
        gareen.damage = 50;

        Hero teemo = new Hero();
        teemo.name = "提莫";
        teemo.hp = 300;
        teemo.damage = 60;

        Hero bh = new Hero();
        bh.name = "赏金猎人";
        bh.hp = 500;
        bh.damage = 60;

        Hero leesion = new Hero();
        leesion.name = "盲僧";
        leesion.hp = 455;
        leesion.damage = 80;

        Thread t1 = new Thread(() -> {
            while (!teemo.isDead()) {
                gareen.attackHero(teemo);
            }
        });


        Thread t2 = new Thread(() -> {
            while (!leesion.isDead()) {
                Thread.yield();

                bh.attackHero(leesion);
            }
        });

//        try {
//            t1.join();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        t1.setPriority(5);
        t2.setPriority(5);
        t1.start();
        t2.start();

    }
}
