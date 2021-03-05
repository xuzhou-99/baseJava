package my.demo.thread;

import my.demo.entity.Hero;

/**
 * 多线程-实现Runnable
 *
 * @author xuzhou
 * @version 1.0.0
 * @title Battle
 * @date 2021/3/5 14:51
 */
public class Battle implements Runnable {
    private Hero hero1;
    private Hero hero2;

    public Battle(Hero h1, Hero h2) {
        this.hero1 = h1;
        this.hero2 = h2;
    }

    @Override
    public void run() {
        while (!hero2.isDead()) {
            hero1.attackHero(hero2);
        }
    }
}
