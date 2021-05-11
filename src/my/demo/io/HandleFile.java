package my.demo.io;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;

import sun.misc.BASE64Decoder;

/**
 * @author xuzhou
 * @version 1.0.0
 * @title File
 * @description
 * @date 2020/10/23 12:16
 */
public class HandleFile {
    static BASE64Decoder decoder = new BASE64Decoder();

    public static String fileToBase64(String typeData,String codeData){
        InputStream is = null;
        ByteArrayInputStream bais = null;
        ByteArrayOutputStream baos = null;

        String resultCode = "00";
        return "";

    }
}
