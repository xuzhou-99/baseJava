package my.demo.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author xuzhou
 * @version 1.0.0
 * @title TestCloseStream
 * @description
 * @date 2020/11/3 14:20
 */
public class TestCloseStream {

    public static void main(String[] args) throws IOException {
        File file = new File("d:/file/lol2.txt");
        InputStream inputStream = null;
        try {
            inputStream = new FileInputStream(file);
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            assert inputStream != null;
            inputStream.close();
        }

    }
}
