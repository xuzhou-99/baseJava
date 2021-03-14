package my.demo.collection;

import my.demo.entity.Hero;

import java.util.*;

/**
 * @author xuzhou
 * @version 1.0.0
 * @title CollectionUtils
 * @date 2021/3/1 17:25
 */
public class CollectionUtils {
    public static int contents(List list, Hero hero) {
        for (int i = 0; i < list.size(); i++) {
            if((((Hero)list.get(i)).name).equals(hero.name)){
                return i;
            }
        }
        return -1;
    }

    /**
     * 冒泡排序 升序
     * @param a 要排序的数组
     */
    public static void bubbleSort(int[] a){
        int temp = 0;
        for(int i = 0;i<a.length-1;i++){
            for(int j = 0;j<a.length-i-1;j++){
                if(a[j] > a[j+1]){
                    temp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = temp;
                }
            }
        }
    }

    /**
     * 选择排序 升序
     * @param a
     */
    public static void selectSort(int[] a){
        int temp = 0;
        for(int i=0;i<a.length-1;i++){
            for (int j = i + 1; j < a.length; j++) {
                if (a[i] > a[j]) {
                    temp = a[i];
                    a[i] = a[j];
                    a[j] = temp;
                }
            }
        }
    }

    /**
     * 获取一定长度的随机字符串
     *
     * @param num 字符串长度
     * @return String
     */
    public static String randomCreateString(int num) {
        Random random = new Random();
        char[] chars = new char[num];
        String letterOrDigital = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";

        for (int i = 0; i < num; i++) {
            chars[i] = letterOrDigital.charAt(random.nextInt(letterOrDigital.length()));
        }
        return new String(chars);
    }

    /**
     * 获取一定长度的随机字符串
     *
     * @param length 字符串长度
     * @return String
     */
    public static String randomString(int length) {
        Random random = new Random();
        StringBuilder pool = new StringBuilder();
        for (short i = '0'; i <= '9'; i++) {
            pool.append((char) i);
        }
        for (short i = 'a'; i <= 'z'; i++) {
            pool.append((char) i);
        }
        for (short i = 'A'; i <= 'Z'; i++) {
            pool.append((char) i);
        }
        char[] cs = new char[length];
        for (int i = 0; i < cs.length; i++) {
            int index = random.nextInt(pool.length());
            cs[i] = pool.charAt(index);
        }
        return new String(cs);
    }

    /**
     * 0-9999之间的随机数，要求不能有重复的
     *
     * @param num 生成的个数
     * @return Set<Integer>
     */
    public static Set randomCreateDiffInt(int num) {
        if (num == 0) {
            return Collections.EMPTY_SET;
        }

        Set<Integer> set = new HashSet<>(num);
        int count = 0;
        int tt = 0;
        while (count < num){
            int a = (int)(Math.random() * 9999);
            if(set.add(a)){
                count++;
            }
            tt++;
        }
        return set;
    }
}
