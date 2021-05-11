package my.demo.property;

/**
 * @author xuzhou
 * @version 1.0.0
 * @title MagicPotion
 * @description
 * @date 2020/10/21 17:40
 */
public class MagicPotion extends Item{
    @Override
    public void effect(){
        System.out.println("蓝屏使用后，可以回魔法");
    }

}
