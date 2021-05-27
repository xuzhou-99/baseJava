package my.demo.socket;

import java.io.IOException;

/**
 * TestSocket
 *
 * @author xuzhou
 * @version v1.0.0
 * @create 2021/5/27 10:22
 */
public class TestSocket {

    public static void main(String[] args) {
//        int port = Integer.parseInt(args[0]);
        int port = 6066;

        GreetingServer server = null;
        try {
            server = new GreetingServer(port);
            server.start();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
