package my.demo.entity;

import java.io.Serializable;

/**
 * Hero2
 *
 * @author xuzhou
 * @version v1.0.0
 * @create 2021/5/12 11:17
 */
public class Hero2 implements Serializable {


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

    /**
     * 伤害
     */
    public int type;

    public Hero2() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getHp() {
        return hp;
    }

    public void setHp(float hp) {
        this.hp = hp;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }
}
