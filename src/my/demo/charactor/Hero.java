package my.demo.charactor;

/**
 * @author xuzhou
 * @version 1.0.0
 * @title Hero
 * @description
 * @date 2020/10/10 13:46
 */
public class Hero {
    String name;
    int hp;
    int armor;
    int moveSpeed;

    public void kill(Mortal m){
        m.die(this);
    }

    public static void battleWin(){
        System.out.println("hero battle win");
    }


    public static void getHeroTypeList(){
        System.out.println("英雄联盟英雄类型有：");
        for (HeroType heroType: HeroType.values()) {

            switch (heroType){
                case PUSH:
                    System.out.println("推进");
                    break;
                case ASSIST:
                    System.out.println("辅助");
                    break;
                case RAMGED:
                    System.out.println("远程");
                    break;
                case WIZARD:
                    System.out.println("法师");
                    break;
                case FARMING:
                    System.out.println("打野");
                    break;
                case TANK:
                    System.out.println("坦克");
                    break;
                case WARRIOR:
                    System.out.println("近战");
                    break;
                case ASSASSIN:
                    System.out.println("刺客");
                    break;
                default:
            }
        }
    }


    public static void main(String[] args) {

        Hero ganlen = new Hero();
        ganlen.name = "盖伦";

        ADHero adHero = new ADHero();
        adHero.name = "小兵1";

        APHero apHero = new APHero();
        apHero.name = "小兵2";

        ADAPHero adapHero = new ADAPHero();
        adapHero.name = "小兵3";

        ganlen.kill(adHero);
        ganlen.kill(apHero);
        ganlen.kill(adapHero);

    }

}
