package my.demo.collection;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author xuzhou
 * @version 1.0.0
 * @title CollestionUtils
 * @date 2021/3/1 17:25
 */
public class CollestionUtils {
    public static int contents(List list, Hero hero){
        for(int i=0; i<list.size();i++){
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
            for(int j =i+1;j<a.length;j++){
                if(a[i]> a[j]){
                    temp = a[i];
                    a[i] = a[j];
                    a[j] = temp;
                }
            }
        }
    }

    public static String randomCreateString(int num){
        char[] chars = new char[num];
        String letterOrDigital = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";

        for(int i = 0; i < num; i++){
            chars[i] = letterOrDigital.charAt((int)(Math.random() * letterOrDigital.length()));
        }
        return new String(chars);
    }

    /**
     * 0-9999之间的随机数，要求不能有重复的
     * @param num 生成的个数
     * @return Set<Integer>
     */
    public static Set randomCreateDiffInt(int num){
        if (num ==0){
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
