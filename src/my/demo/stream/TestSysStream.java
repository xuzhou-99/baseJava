package my.demo.stream;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

/**
 * @author xuzhou
 * @version 1.0.0
 * @title TestSysStream
 * @date 2021/2/24 16:19
 */
public class TestSysStream {

    private static final String MODEL_FILE_PATH = "D:/projects/testFile/Model.txt";

    public static void main(String[] args) {
        createClass(MODEL_FILE_PATH);
    }

    private static void createClass(final String path){
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入类名：");
        String className = scanner.nextLine();

        System.out.println("请输入属性：");
        String type = scanner.nextLine();

        System.out.println("请输入属性名称：");
        String property = scanner.nextLine();



        File modelFile = new File(path);
        String modelContent;
        String fileName = toUpperFirstLetter(className) + ".java";
        File file = new File(modelFile.getParent(), fileName);


        try (FileReader fr = new FileReader(modelFile);FileWriter fw = new FileWriter(file)) {
            char[] chars = new char[(int) modelFile.length()];
            fr.read(chars);
            modelContent = new String(chars);

            String fileContent = modelContent.replace("@class@", toUpperFirstLetter(className));
            fileContent = fileContent.replace("@type@", type);
            fileContent = fileContent.replace("@property@", property);
            fileContent = fileContent.replace("@Uproperty@", toUpperFirstLetter(property));

            System.out.println("替换后的内容：");
            System.out.println(fileContent);

            fw.write(fileContent);
        }catch (IOException e){
            e.printStackTrace();
        }

        System.out.println("文件保存路径为：" + file.getAbsolutePath());
    }

    public static String toUpperFirstLetter(String str){
        char firstLetter = Character.toUpperCase(str.charAt(0));
        String rest = str.substring(1);
        return firstLetter + rest;
    }

    private static void scanner(){
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        System.out.println(line);

        String string = scanner.next();
        System.out.println(string);

        System.out.println("请输入整数：");
        int num = scanner.nextInt();
        System.out.println(num);
    }

    private static void systemIn(){
        try (InputStream in = System.in) {
            int i = in.read();
            System.out.println(i);
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
