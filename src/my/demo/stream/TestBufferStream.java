package my.demo.stream;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;



/**
 * @author xuzhou
 * @version 1.0.0
 * @title TestBufferStream
 * @date 2021/2/24 14:15
 */
public class TestBufferStream {

    static String path = "D:/projects/test.txt";
    static String path1 = "D:/projects/javacc.java";

    public static void main(String[] args) {

        File file = new File(path1);
        removeComments(file);
    }

    public static void removeComments(File javaFile){
        File dir = javaFile.getParentFile();
        String name = javaFile.getName().substring(0, javaFile.getName().lastIndexOf(".")) + "-removeComments";
        File newFile = new File(dir + File.separator + name + ".java");


        try (FileReader fr = new FileReader(javaFile);
             BufferedReader br = new BufferedReader(fr);
             FileWriter fw = new FileWriter(newFile);
             PrintWriter pw = new PrintWriter(fw)) {


            while (true){
                String line = br.readLine();
                if(null == line){
                    break;
                }
                if(line.startsWith("//")){
                    continue;
                }
                pw.println(line);
            }
        }catch (IOException e){
            e.printStackTrace();
        }




    }

    /**
     * 缓存流的写入
     * flush一次就写入到文件（硬盘）中一次
     * @param path 文件路径
     */
    public static void printWriteWithFlush(final String path){
        File file = new File(path);
        System.out.println("Start a stream with flush: ");
        try (
                FileWriter fw = new FileWriter(file);
                PrintWriter pw = new PrintWriter(fw)
        ) {
            // print a line into file
            pw.println("This is first line");
            pw.flush();
            bufferReader(path);
            pw.println("This is second line");
            pw.flush();
            bufferReader(path);
            pw.println("This is third line");
            pw.flush();
            bufferReader(path);
            pw.print(false);
            pw.flush();
            bufferReader(path);
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    /**
     * 缓存流写入
     * 没有是用flush，流写完才会写入到文件中
     * @param path 文件路径
     */
    public static void printWrite(final String path){
        File file = new File(path);

        System.out.println("Start a stream: ");
        try (
                // create stream
                FileWriter fw = new FileWriter(file);
                // create printWrite base on stream
                PrintWriter pw = new PrintWriter(fw)
        ) {
            // print a line into file
            pw.println("This is first line");
            bufferReader(path);
            pw.println("This is second line");
            bufferReader(path);
            pw.println("This is third line");
            bufferReader(path);
            pw.print(false);
            bufferReader(path);
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    /**
     * 读取缓存流
     * @param path 文件路径
     */
    public static void bufferReader(String path){
        File file = new File(path);
        try (
                // create stream
                FileReader fr = new FileReader(file);
                // create bufferStream base on stream which is exists
                BufferedReader br = new BufferedReader(fr)
        ) {
            while (true){
                // read a line
                String lineStr = br.readLine();
                if (null == lineStr){
                    // when the line is null ,the process end
                    break;
                }
                // print line content
                System.out.println(lineStr);
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
