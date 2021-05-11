package my.demo.digit;

import java.util.Arrays;
import java.util.Date;
import java.util.Random;
import java.util.Scanner;

/**
 * @author xuzhou
 * @version 1.0.0
 * @title TestNumber
 * @description
 * @date 2020/10/22 14:22
 */
public class TestNumber {


    public static void main(String[] args) {


        String string = "let there be light";
        String[] strings=string.split(" ");
        for(int i=0;i<strings.length;i++){
            char[] chars=strings[i].toCharArray();
            chars[0] =  Character.toUpperCase(chars[0]);
            strings[i]=String.valueOf(chars);
        }
        String s=Arrays.toString(strings);
        System.out.printf(s);


    }

    /**
     * 生成一定长度密码
     * 破解密码
     */
    public static void decode(){

        Scanner scanner =new Scanner(System.in);
        System.out.print("请输入密码长度：");
        int length = scanner.nextInt();
        scanner.close();

        char[] chars = radomChars(length);
        String string = String.valueOf(chars);
        System.out.println("随机生成的密码为："+string);

        System.out.println("开始解密：");
        Date startDate = new Date();

        char[] chars1=new char[length];

        char c;
        //使用tab标记for循环
        tab: for(int i=0;i<length;i++){
            for(c='a';c<='z';c++){
                if(c==chars[i]){
                    chars1[i]=c;
                    //跳出到外层的for循环
                    continue tab;
                }
            }
            for( c = '0';c<='9';c++){
                if(c==chars[i]){
                    chars1[i]=c;
                    continue tab;
                }
            }
            for( c = 'A';c<='Z';c++){
                if(c==chars[i]){
                    chars1[i]=c;
                    continue tab;
                }
            }
        }
        long time;
        Date endTime  = new Date();
        time = endTime.getTime()-startDate.getTime();
        if(string.equals(String.valueOf(chars1))){

            System.out.println("解密完成，密码为："+ Arrays.toString(chars1));
        }else {

            System.out.println("解密失败");
        }

        System.out.println("共计用时："+time);
    }

    /**
     * 字符数组按照首字母排序
     * @param strings 字符数组
     */
    public static void orderByFirstChar(String[] strings){

        char[] chars;
        char[] chars1;

        for(int i=0;i<8;i++){
            int temp =i;
            char c;
            chars1 = strings[i].toCharArray();
            c=chars1[0];
            for(int k=i;k<8;k++){
                chars = strings[k].toCharArray();
                if(compareChar(c,chars[0])){
                    temp = k;
                    c=chars[0];
                }
            }
            if(temp!=i){
                String string = strings[temp];
                strings[temp] = strings[i];
                strings[i]=string;
            }

        }
    }

    /**
     * 字符比较，a>b为真
     * @param a a
     * @param b b
     * @return boolean
     */
    public static boolean compareChar(char a,char b){
        if('A'<=a && a<='Z'){
            a = (char) (a-'A'+'a');
        }
        if('A'<=b && b<='Z'){
            b = (char) (b-'A'+'a');
        }

        return a > b;
    }
    /**
     * 随机生成char[]
     * @param num 数组长度
     * @return char[]
     */
    public static char[] radomChars(int num){
        char[] chars = new char[num];

        int rang1= 'z'-'a';
        int rang2 = 'Z'-'A';
        int rang3 = '9'-'0';
        Random random=new Random();

        for(int i=0;i<num;i++){
            int m;
            int k =  random.nextInt(3);
            switch (k){
                case 0:
                    m=random.nextInt(rang1);
                    chars[i]= (char) ('a'+m);
                    break;
                case 1:
                    m=random.nextInt(rang2);
                    chars[i]= (char) ('A'+m);
                    break;
                case 2:
                    m= random.nextInt(rang3);
                    chars[i]= (char) ('0'+m);
                    break;
                default:
            }
        }

        return chars;
    }

    /**
     * 判断是否为质数
     * @param a 参数
     * @return boolean
     */
    public static boolean isPrime(int a) {

        boolean flag = true;

        if (a < 2) {
            // 素数不小于2
            return false;
        } else {

            for (int i = 2; i <= Math.sqrt(a); i++) {

                if (a % i == 0) {
                    // 若能被整除，则说明不是素数，返回false

                    flag = false;
                    break;// 跳出循环
                }
            }
        }
        return flag;
    }
}
