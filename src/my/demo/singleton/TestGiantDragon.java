package my.demo.singleton;

/**
 * @author xuzhou
 * @version 1.0.0
 * @title TestGiantDragon
 * @description
 * @date 2020/10/21 16:08
 */
public class TestGiantDragon {
    public static void main(String[] args) {

        GiantDragon g1= GiantDragon.getInstance();
        GiantDragon g2 = GiantDragon.getInstance();
        GiantDragon g3 = GiantDragon.getInstance();
        System.out.println(g1);
        System.out.println(g2);
        System.out.println(g3);
    }
}
