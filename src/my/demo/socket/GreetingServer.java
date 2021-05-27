package my.demo.socket;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * GreetingServer
 *
 * @author xuzhou
 * @version v1.0.0
 * @create 2021/5/27 10:16
 */
public class GreetingServer extends Thread {


    private ServerSocket serverSocket;

    public GreetingServer(int port) throws IOException {
        serverSocket = new ServerSocket(port);
        serverSocket.setSoTimeout(10 * 1000);
    }

    @Override
    public void run() {
        while (true) {

            try {
                System.out.println("Waiting for client on port " + serverSocket.getLocalPort());
                Socket server = serverSocket.accept();

                System.out.println("Just connected to " + server.getRemoteSocketAddress());

                DataInputStream in = new DataInputStream(server.getInputStream());
                System.out.println(in.readUTF());

                DataOutputStream out = new DataOutputStream(server.getOutputStream());
                out.writeUTF("Thank you for connecting to " + server.getLocalSocketAddress() + "\nGoodbye!");

                server.close();

            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

}
