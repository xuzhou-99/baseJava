package my.demo.charactor;

/**
 * @author xuzhou
 * @version 1.0.0
 * @title APHero
 * @description
 * @date 2020/10/21 17:23
 */
public class APHero extends Hero implements AP,Mortal {
    @Override
    public void magicAttack() {
        System.out.println("魔法攻击");
    }

    @Override
    public void die(Hero hero) {
        System.out.println(hero.name +"击杀"+super.name);
    }
}
