package my.demo.thread;

import my.demo.entity.Hero;

/**
 * 多线程-继承Thread
 *
 * @author xuzhou
 * @version 1.0.0
 * @title KillThread
 * @date 2021/3/5 14:42
 */
public class KillThread extends Thread {
    private Hero hero1;
    private Hero hero2;

    public KillThread(Hero hero1, Hero hero2) {
        this.hero1 = hero1;
        this.hero2 = hero2;
    }

    @Override
    public void run() {
        while (!hero2.isDead()) {
            hero1.attackHero(hero2);
        }
    }
}
