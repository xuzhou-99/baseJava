package my.demo.charactor;

/**
 * @author xuzhou
 * @version 1.0.0
 * @title ADHero
 * @description
 * @date 2020/10/21 17:22
 */
public class ADHero extends Hero implements AD,Mortal {

    @Override
    public void physicAttack() {
        System.out.println("物理攻击");
    }

    @Override
    public void die(Hero hero) {
        System.out.println(hero.name +"kill"+super.name);
    }

    public static void battleWin(){
        System.out.println("ad hero battle win");
    }

    public static void main(String[] args) {
        ADHero hero = new ADHero();
        hero.attack();
        Hero.battleWin();
        ADHero.battleWin();
        System.out.println(hero.getClass());
    }
}
