package my.demo.collection;

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
}
