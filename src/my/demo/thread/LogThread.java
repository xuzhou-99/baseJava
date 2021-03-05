package my.demo.thread;

import java.util.List;

/**
 * @author xuzhou
 * @version 1.0.0
 * @title LogThread
 * @date 2021/3/5 17:47
 */
public class LogThread extends Thread {
    private boolean found = false;

    private List<String> passwords;

    public LogThread(List<String> passwords) {
        this.passwords = passwords;
        //把记日志的这个线程，设置为守护线程
        this.setDaemon(true);
    }

    @Override
    public void run() {
        while (true) {
            while (passwords.isEmpty()) {
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }

            String password = passwords.remove(0);
            System.out.println("穷举法本次生成的密码是：" + password);
        }
    }
}
