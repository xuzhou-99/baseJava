package my.demo.singleton;

/**
 * @author xuzhou
 * @version 1.0.0
 * @title GiantDragon
 * @description
 * @date 2020/10/21 16:05
 */
public class GiantDragon {

    /**
     * 私有化构造方法
     */
    private GiantDragon(){

    }

    /**
     * 类属性
     * 指向一个实例化对象
     * 唯一
     */
    private static GiantDragon instance = new GiantDragon();

    public static GiantDragon getInstance(){
        return instance;
    }
}
