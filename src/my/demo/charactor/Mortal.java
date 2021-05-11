package my.demo.charactor;

/**
 * @author xuzhou
 * @version 1.0.0
 * @title Mortal
 * @description
 * @date 2020/10/21 17:43
 */
public interface Mortal {
    public void die(Hero hero);

    default public void revive(){
        System.out.println("本英雄复活啦。");
    }
}
