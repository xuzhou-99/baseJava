package my.demo.wisdom;

import java.util.Scanner;

import com.sun.org.slf4j.internal.Logger;
import com.sun.org.slf4j.internal.LoggerFactory;

/**
 * TestBaiZe
 *
 * @author xuzhou
 * @version v1.0.0
 * @create 2021/5/24 9:05
 */
public class TestBaiZe {
    public final static Logger log = LoggerFactory.getLogger(TestBaiZe.class);

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        GameInfo gameInfo = new GameInfo();
        Integer end = 0;

        System.out.println("游戏初始化：");
        System.out.println("请输入石子总数量：");
        Integer count = scanner.nextInt();
        gameInfo.setCount(count);

        System.out.println("请输入每次可以获取的最大值（最小为1，不能超过总数）：");
        Integer takeNum = scanner.nextInt();
        gameInfo.setTakeNum(takeNum);


        System.out.println("游戏初始化成功：");
        System.out.println("有一堆石子共 " + gameInfo.getCount() + " 颗，你和白泽轮流取，每次最少取 1 颗，最多取 " + gameInfo.getTakeNum() + " 颗，最后一次取光石子的获胜！");

        BaiZe baiZe = new BaiZe();

        while (end == 0) {
            Integer take = checkTaken(gameInfo);
            count -= take;
            if (count <= 0) {
                end = 1;
                count = 0;
                gameInfo.setCount(count);
                System.out.println("剩余：" + count);
                break;
            }
            gameInfo.setCount(count);
            System.out.println("剩余：" + count);


            baiZe.setGameInfo(gameInfo);
            take = baiZe.take();
            if (take == 0) {
                end = 1;
                System.out.println("You win!");
                break;
            }
            count -= take;
            System.out.println("Baize 取走：" + take);
            if (count <= 0) {
                end = 2;
                count = 0;
                gameInfo.setCount(count);

                System.out.println("剩余：" + count);
                break;
            }
            gameInfo.setCount(count);

            System.out.println("剩余：" + count);

            gameInfo = baiZe.getGameInfo();

        }
        if (end == 1) {
            System.out.println("You win!");
        } else {
            System.out.println("BaiZe win!");
        }


    }

    public static Integer checkTaken(GameInfo gameInfo) {
        Scanner scanner = new Scanner(System.in);
        boolean checked = false;
        System.out.println("请选择取走的石子数量：");
        Integer take = scanner.nextInt();

        while (!checked) {
            if (take < 1 || take > gameInfo.getTakeNum()) {
                System.out.println("请重新输入，在1 - " + gameInfo.getTakeNum() + " 之间！");
                take = scanner.nextInt();
            } else {
                checked = true;
            }
        }
        return take;
    }
}
