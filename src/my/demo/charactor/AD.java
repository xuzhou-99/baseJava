package my.demo.charactor;

/**
 * @author xuzhou
 * @version 1.0.0
 * @title AD
 * @description
 * @date 2020/10/21 17:09
 */
public interface AD {
    public void physicAttack();

    default public void attack(){
        System.out.println("发出物理攻击");
    }
}
