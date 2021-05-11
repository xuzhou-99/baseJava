package my.demo.property;

/**
 * @author xuzhou
 * @version 1.0.0
 * @title LifePotion
 * @description
 * @date 2020/10/21 17:38
 */
public class LifePotion extends Item {

    @Override
    public void effect(){
        System.out.println("血瓶使用后，可以回血");
    }
}
