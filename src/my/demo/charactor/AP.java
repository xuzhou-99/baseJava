package my.demo.charactor;

/**
 * @author xuzhou
 * @version 1.0.0
 * @title AP
 * @description
 * @date 2020/10/21 17:22
 */
public interface AP {
    public void magicAttack();

    default public void attack(){
        System.out.println("发出魔法攻击");
    }
}
