package my.demo.charactor;

/**
 * @author xuzhou
 * @version 1.0.0
 * @title ADAPHero
 * @description
 * @date 2020/10/21 17:24
 */
public class ADAPHero extends Hero implements AP,AD,Mortal{
    @Override
    public void physicAttack() {
        System.out.println("物理攻击");
    }

    @Override
    public void magicAttack() {
        System.out.println("魔法攻击");
    }

    @Override
    public void attack() {

    }


    @Override
    public void die(Hero hero) {
        System.out.println(hero.name+"kill"+super.name);
    }

    @Override
    public void revive() {

    }

}
