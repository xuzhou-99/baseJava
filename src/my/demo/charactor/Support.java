package my.demo.charactor;

/**
 * @author xuzhou
 * @version 1.0.0
 * @title Support
 * @description
 * @date 2020/10/21 17:26
 */
public class Support extends Hero implements Healer {

    @Override
    public void heal() {
     System.out.println("进行治疗");
    }
}
