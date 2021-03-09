package my.demo.network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @author xuzhou
 * @version 1.0.0
 * @title TestSocket
 * @date 2021/3/9 11:30
 */
public class TestSocket {
    public static void main(String[] args) {
        try {
            InetAddress localHost = InetAddress.getLocalHost();
            String ip = localHost.getHostAddress();
            System.out.println("this computer ip is :" + ip);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }

        try {
            Process p = Runtime.getRuntime().exec("ping " + "172.23.22.194");
            BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));
            String line = null;
            StringBuilder builder = new StringBuilder();
            while ((line = reader.readLine()) != null){
                if(line.length() != 0){
                    builder.append(line + " \r\n");
                }
            }
            System.out.println("the response message is: ");
            System.out.println(builder.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
