package my.demo.socket;


import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * GreetingClient
 *
 * @author xuzhou
 * @version v1.0.0
 * @create 2021/5/27 10:09
 */
public class GreetingClient {


    public static void main(String[] args) {
//        String serverName = args[0];
//        int port = Integer.parseInt(args[1]);

        String serverName = "172.23.22.58";
        int port = 6066;


        try {
            System.out.println("Connecting to " + serverName + " on port " + port);
            Socket client = new Socket(serverName, port);

            System.out.println("Just connected to " + client.getRemoteSocketAddress());
            OutputStream outToServer = client.getOutputStream();
            DataOutputStream out = new DataOutputStream(outToServer);

            out.writeUTF("Hello from " + client.getLocalSocketAddress());

            InputStream inFromServer = client.getInputStream();
            DataInputStream in = new DataInputStream(inFromServer);

            System.out.println("Server says " + in.readUTF());
            client.close();


        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
