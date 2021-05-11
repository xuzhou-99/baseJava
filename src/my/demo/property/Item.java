package my.demo.property;

/**
 * @author xuzhou
 * @version 1.0.0
 * @title Item
 * @description
 * @date 2020/10/10 13:52
 */
public class Item {
    String name;
    int price;

    public void buy(){
        System.out.println("购买");
    }

    public void effect(){
        System.out.println("物品使用后，可以有效果");
    }

    public static void main(String[] args) {
        Item i = new Item();
        i.effect();

        LifePotion lifePotion = new LifePotion();
        lifePotion.effect();
    }

//    /**
//     * private
//     * 私有化构造
//     */
//    private Item(){
//
//    }
//
//    /**
//     * 类变量
//     * 为Item加一个实例化对象，暂时指向null
//     */
//    private static Item item;
//
//    /**
//     * public static 方法，返回一个实例化对象
//     * @return Item
//     */
//    public static Item getItem(){
//        //第一次访问时，实例化一个对象
//        if(null == item){
//            item = new Item();
//        }
//        return item;
//    }



}
