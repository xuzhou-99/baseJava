package my.demo.stream;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author xuzhou
 * @version 1.0.0
 * @title TestFileReader
 * @date 2021/2/24 10:02
 */
public class TestFileReader {

    static String path = "D:/projects/test.txt";
    static String path1 = "D:/projects/encoding.txt";
    static String path2 = "D:/projects/encoded.txt";
    static String path3 = "D:/projects/decoded.txt";

    public static void main(String[] args) {

        writeS(path1);
        encodeFile(path1, path2);
        decodeFile(path2, path3);
    }

    public static void test(){

    }

    public static void encodeFile(String encodingFilePath, String encodedFilePath){
        File encodingFile = new File(encodingFilePath);
        File encodedFile = new File(encodedFilePath);
        char[] chars = new char[(int) encodingFile.length()];
        char[] charsEncoded = new char[(int) encodingFile.length()];

        try (FileReader fr = new FileReader(encodingFile);FileWriter fw = new FileWriter(encodedFile)) {
            fr.read(chars);
            System.out.println(chars);
            int i=0;
            for (char c :
                    chars) {
                if (c >= '0' && c <= '9') {
                    c = (char) (((c -'0') + 1) % 10 + '0');
                }
                if (c >= 'a' && c <= 'z') {
                    c = (char) (((c - 'a') + 1) % 26 +'a');
                }
                if(c >= 'A' && c <= 'Z'){
                    c = (char) (((c - 'A') + 1) % 26 +'A');
                }

                charsEncoded[i] = c;
                i++;
            }
            System.out.println(charsEncoded);


            fw.write(charsEncoded);
        }catch (IOException e){
            e.printStackTrace();
        }

    }
    public static void decodeFile(String encodedFilePath, String decodedFilePath){
        File decodedFile = new File(decodedFilePath);
        File encodedFile = new File(encodedFilePath);
        char[] charsNoEncoded = new char[(int) encodedFile.length()];
        char[] charsEncoded = new char[(int) encodedFile.length()];

        try (FileReader fr = new FileReader(encodedFile);FileWriter fw = new FileWriter(decodedFile)) {
            fr.read(charsEncoded);
            System.out.println(charsEncoded);
            int i=0;
            for (char c :
                    charsEncoded) {
                if(c == '0'){
                    c = '9';
                }
                if (c >= '0' && c < '9') {
                    c = (char) (c - 1);
                }
                if(c == 'a'){
                    c = 'z';
                }
                if(c == 'A'){
                    c = 'Z';
                }
                if (c >= 'a' && c < 'z') {
                    c = (char) (c - 1);
                }
                if(c >= 'A' && c < 'Z'){
                    c = (char) (c - 1);
                }

                charsNoEncoded[i] = c;
                i++;
            }
            System.out.println(charsNoEncoded);


            fw.write(charsNoEncoded);
        }catch (IOException e){
            e.printStackTrace();
        }

    }

    /**
     * 文件读取
     * 字符流
     * @param path 文件路径
     */
    public static void readS(final String path){
        // 准备文件
        File file = new File(path);
        // 创建基于文件的Reader
        try (FileReader fileReader = new FileReader(file)) {
            // 创建字符数组，其长度为文件的长度
            char[] chars = new char[(int) file.length()];
            // 以字符流的形式读取文件所有内容
            fileReader.read(chars);
            for (char c : chars) {
                System.out.println(c);
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    /**
     * 文件写入
     * 字符流
     * @param path 文件路径
     */
    public static void writeS(final String path){
        // 准备文件
        File file = new File(path);
        // 创建基于文件的Writer
        try (FileWriter fileWriter = new FileWriter(file)) {
            // 要写入文件的内容
            String str = "ABCDabcd0123";
            char[] chars = str.toCharArray();

            // 以字符流的形式写入文件
            // 写入字符数组
            fileWriter.write(chars);
            // 写入字符串
            fileWriter.write(str);
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public static void inputStream(final String path){
        File file = new File(path);
        try(FileInputStream fileInputStream = new FileInputStream(file);) {
            // 创建文件的输入流

            // 创建字节数组，数组长度为文件长度
            byte[] bytes = new byte[(int) file.length()];
            // 以字节流的形式读取文件所有内容
            fileInputStream.read(bytes);

            for(byte b : bytes){
                // 打印出文件中内容对应的字节
                System.out.println(b);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
