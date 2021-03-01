package my.demo.stream;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author xuzhou
 * @version 1.0.0
 * @title TestStream
 * @date 2021/2/23 17:43
 */
public class TestStream {
    public static void main(String[] args) {
        String path = "D:/projects/test/testfile.docx";
        closeStreamInTry(path);
        closeStreamInFinally(path);

    }

    /**
     * 关闭流
     *
     * try
     * 在try中关闭流
     * 如果抛出异常，则不会执行最后的close方法，导致存在隐患
     * @param path 文件路径
     */
    public static void closeStreamInTry(String path){
        File file = new File(path);

        try {
            // Open a stream
            FileInputStream fis = new FileInputStream(path);
            byte[] bytes = new byte[(int) file.length()];
            fis.read(bytes);

            // stream closed
            fis.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 关闭流
     *
     * finally
     * 在finally中关闭流，最后一定会执行
     * 关闭流的时候也要捕捉异常
     * @param path 文件路径
     */
    public static void closeStreamInFinally(final String path){
        File file = new File(path);
        FileInputStream fis = null;
        try {
            System.out.println("Open a stream");
            fis = new FileInputStream(file);
            byte[] bytes = new byte[(int) file.length()];
            fis.read(bytes);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(fis != null){
                try {
                    fis.close();
                    System.out.println("stream closed");
                } catch (IOException e) {
                    System.out.println("close stream fail: " + e.getMessage());
                }
            }
        }
    }

    /**
     * 关闭流
     *
     * try-with-resources
     * 在try中打开流会在结束的时候自动关闭（1.7以后支持）
     * @param path 文件路径
     */
    public static void closeStreamInTry2(final String path){
        File file = new File(path);
        try (FileInputStream fis = new FileInputStream(file)) {
            byte[] bytes = new byte[(int) file.length()];
            fis.read(bytes);

        }catch (IOException e){
            e.printStackTrace();
        }
    }


    public static void inputStream(){
        // 要读取的文件
        File file = new File("D:/projects/test/test1.txt");
        try {
            // 创建文件的输入流
            FileInputStream fileInputStream = new FileInputStream(file);
            // 创建字节数组，数组长度为文件长度
            byte[] bytes = new byte[(int) file.length()];
            // 以字节流的形式读取文件所有内容
            fileInputStream.read(bytes);

            for(byte b : bytes){
                // 打印出文件中内容对应的字节
                System.out.println(b);
            }
            // 关闭流
            fileInputStream.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void outputStream(){
        // 要写入的文件
        File file = new File("D:/projects/test/test1.txt");
        try {
            // 文件路径
            if(!file.getParentFile().exists()){
                // 创建空文件前创建父目录
                file.getParentFile().mkdirs();
            }
            // 创建基于目标文件的输出流
            FileOutputStream fos = new FileOutputStream(file);
            // 要写入的内容，字节数组的格式
            byte[] bytes = {65, 97};

            // 将数据写入输出流
            fos.write(bytes);
            // 关闭流
            fos.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Boolean splitFile(String path) throws IOException{
        File file = new File(path);

        int length = (int) file.length();
        byte[] bytes = new byte[length];

        FileInputStream fis = null;
        fis = new FileInputStream(file);
        fis.read(bytes);
        fis.close();
        file.delete();

        int childFileLen = length/4;
        for(int i = 0; i < 4;i++){
            File chilefile = new File(path + "-" + i);
            FileOutputStream fos = new FileOutputStream(chilefile);
            fos.write(bytes, childFileLen*i, childFileLen);
            if(i == 3 && length % 4 > 0){
                fos.write(bytes, childFileLen * 3, length % 4);
                fos.close();
            }
        }
        return true;

    }
    public static Boolean splitFile2(String path) {
        File file = new File(path);

        int length = (int) file.length();
        byte[] bytes = new byte[length];

        FileInputStream fis = null;
        try {
            fis = new FileInputStream(file);
            fis.read(bytes);

            file.delete();

            int childFileLen = length/4;
            for(int i = 0; i < 4;i++) {
                File chilefile = new File(path + "-" + i);

                FileOutputStream fos = null;
                try {
                    fos = new FileOutputStream(chilefile);
                    fos.write(bytes, childFileLen * i, childFileLen);
                    if (i == 3 && length % 4 > 0) {
                        fos.write(bytes, childFileLen * 3, length % 4);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    fos.close();
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            assert fis != null;
            try {
                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return true;

    }
    public static Boolean mergeFile(String path) {
        File file = new File(path);
        try(FileOutputStream fos = new FileOutputStream(file)) {
            file.createNewFile();
            for(int i= 0;i<4;i++){
                File childFile = new File(path + "-" + i);
                FileInputStream fis = new FileInputStream(childFile);
                byte[] bytes = new byte[(int) childFile.length()];
                fis.read(bytes);
                fis.close();

                fos.write(bytes);
                childFile.delete();
            }
        }catch (IOException e){
            e.printStackTrace();
        }
        return true;
    }

}
