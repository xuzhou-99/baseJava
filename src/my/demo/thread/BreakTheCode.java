package my.demo.thread;

import my.demo.collection.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xuzhou
 * @version 1.0.0
 * @title BreakTheCode
 * @date 2021/3/5 17:09
 */
public class BreakTheCode {
    public static void main(String[] args) {
        testBreakCode();
        testBreakCode2();

    }

    /**
     * 多线程-继承Thread
     * <p>
     * 1. 生成一个长度是3的随机字符串，把这个字符串当作 密码
     * <p>
     * 2. 创建一个破解线程，使用穷举法，匹配这个密码
     * <p>
     * 3. 创建一个日志线程，打印都用过哪些字符串去匹配，这个日志线程设计为守护线程
     */
    public static void testBreakCode() {
        String password = CollectionUtils.randomString(3);
        System.out.println("密码是:" + password);
        List<String> passwords = new ArrayList<>();

        new PasswordThread(password, passwords).start();
        new LogThread(passwords).start();
    }

    /**
     * 多线程-匿名类
     * <p>
     * 1. 生成一个长度是3的随机字符串，把这个字符串当作 密码
     * <p>
     * 2. 创建一个破解线程，使用穷举法，匹配这个密码
     * <p>
     * 3. 创建一个日志线程，打印都用过哪些字符串去匹配，这个日志线程设计为守护线程
     */
    public static void testBreakCode2() {
        String code = CollectionUtils.randomCreateString(3);
        System.out.println("the code is :" + code);
        System.out.println("start breaking...");
        breakCode(code);
    }

    /**
     * 破解密码
     *
     * @param code 密码
     */
    public static void breakCode(String code) {

        List<String> codes = new ArrayList<>();

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
        String letterOrDigital = new String(pool);

        Thread breakthread = new Thread(() -> {
            String breakcode;
            char[] chars = new char[3];
            int count = 0;

            for (int i = 0; i < letterOrDigital.length(); i++) {
                for (int k = 0; k < letterOrDigital.length(); k++) {
                    for (int m = 0; m < letterOrDigital.length(); m++) {
                        chars[0] = letterOrDigital.charAt(i);
                        chars[1] = letterOrDigital.charAt(k);
                        chars[2] = letterOrDigital.charAt(m);
                        breakcode = new String(chars);
                        codes.add(breakcode);
                        count++;
                        if (code.equals(breakcode)) {
                            System.out.println("try times：" + count);
                            System.out.println("the right code is :" + breakcode);
                            break;
                        }
                    }
                }
            }
        });

        Thread logthread = new Thread(() -> {
            while (true) {
                if (codes.size() > 0) {
                    String remove = codes.remove(0);
                    System.out.println(remove);
                } else {
                    try {
                        Thread.sleep(50);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        logthread.setDaemon(true);
        breakthread.start();
        logthread.start();
    }
}
