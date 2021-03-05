package my.demo.thread;

import java.text.SimpleDateFormat;
import java.util.Date;

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

        for (int i = 0; i < 10; i++) {
            testSynchronous();
        }


//        testSynchronized();
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

    /**
     * 同步
     * 10000 回血
     * 10000 受伤
     * 理论上应该是10000
     * 同时操作一个对象，结果不是每次都相同
     */
    public static void testSynchronous() {
        final Object someObject = new Object();

        Hero gareen = new Hero();
        gareen.name = "盖伦";
        gareen.hp = 10000;
        gareen.damage = 50;

        System.out.println("gareen hp is :" + gareen.hp);

        int n = 10000;
        Thread[] recoverThreads = new Thread[n];
        Thread[] hurtThreads = new Thread[n];

        for (int i = 0; i < n; i++) {
            Thread thread = new Thread(() -> {
                synchronized (someObject) {
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

        for (int i = 0; i < n; i++) {
            Thread thread = new Thread(() -> {
                synchronized (someObject) {
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

        for (Thread t : recoverThreads) {
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

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
