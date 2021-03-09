package my.demo.entity;

import java.io.Serializable;

/**
 * @author xuzhou
 * @version 1.0.0
 * @title Hero
 * @date 2021/2/24 15:04
 */
public class Hero implements Serializable {
    /**
     * 表示这个类当前的版本，如果有变化，应该修改版本号
     */
    private static final long serialVersionUID = 1L;
    /**
     * 名称
     */
    public String name;
    /**
     * 血量
     */
    public float hp;
    /**
     * 伤害
     */
    public int damage;

    static String copyright;
    static {
        System.out.println("初始化 copyright");
        copyright = "The Light own the right";
    }

    public Hero() {

    }

    public Hero(String name, float hp, int damage) {
        this.name = name;
        this.hp = hp;
        this.damage = damage;
    }

    public Hero(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    /**
     * 重写toString方法
     */
    @Override
    public String toString() {
        return "Hero{" +
                "name='" + name + '\'' +
                ", hp=" + hp +
                ", damage=" + damage +
                '}' + "\r\n";
    }

    /**
     * 比较
     *
     * @param anotherHero 比较对象
     * @return int
     */
    public int compareTo(Hero anotherHero) {
        if (damage < anotherHero.damage) {
            return 1;
        } else {
            return -1;
        }
    }

    /**
     * 英雄有可以放一个技能叫做: 波动拳-a du gen。
     * 每隔一秒钟，可以发一次，但是只能连续发3次。
     * <p>
     * 发完3次之后，需要充能5秒钟，充满，再继续发。
     */
    public void aDuGen() {
        Thread thread = new Thread(() -> {

            int count = 3;
            while (count > 0) {
                System.out.format("波动拳第%d发%n", 3 - count + 1);
                count--;
                try {
                    Thread.sleep(1000);
                    if (count == 0) {
                        System.out.println("开始充能5秒...");
                        Thread.sleep(5 * 1000);
                        count = 3;
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        });
        thread.start();
    }


    /**
     * 攻击
     *
     * @param hero 攻击对象
     */
    public void attackHero(Hero hero) {
        try {
            // 攻击需要耗时
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        hero.hp -= damage;
        System.out.format("%s is attacking %s ,%s hp is %.0f%n", name, hero.name, hero.name, hero.hp);

        if (hero.isDead()) {
            System.out.println(hero.name + "is dead!");
        }
    }

    /**
     * recover hp
     * add modifier synchronized before the method
     * effect: the synchronization object is this
     */
    public synchronized void recover() {
        if (this.hp == 1000) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        hp = hp + 1;
        System.out.printf("%s 加血1点,增加血后，%s的血量是%.0f%n", name, name, hp);

        // notify those threads waiting on this object to wake up
        this.notify();
    }

    /**
     * 受伤
     * use this object as synchronization object
     */
    public synchronized void hurt() {
        if (hp == 1) {
            try {
                // release the possession of this
                // waiting for wake
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        hp = hp - 1;
        System.out.printf("%s 减血1点,减少血后，%s的血量是%.0f%n", name, name, hp);

        this.notify();
    }

    /**
     * 存活状态
     *
     * @return Boolean
     */
    public boolean isDead() {
        return 0 >= hp;
    }

}
