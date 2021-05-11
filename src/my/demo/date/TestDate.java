package my.demo.date;

import java.util.Date;
import java.util.Random;

/**
 * @author xuzhou
 * @version 1.0.0
 * @title TestDate
 * @description
 * @date 2020/10/22 18:06
 */
public class TestDate {

    public static void cout(String str){
        System.out.println(str);
    }

    public static int getRandom(int start,int end){
        Random random= new Random();
        int dist = end-start+1;
        return start + random.nextInt(dist);
    }

    public static int getRandom(long start,long end){
        Random random= new Random();
        return 0;
    }

    public static void main(String[] args) {
        Date date = new Date();
        System.out.println("当前时间：");
        System.out.println(date);
        System.out.println();

        Date date1 = new Date(5000);
        System.out.println("从1970年1月1日 早上8点0分0秒 开始经历了5秒的时间");
        System.out.println(date1.getTime());
        System.out.println(System.currentTimeMillis());
    }
}
