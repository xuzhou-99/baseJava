package my.demo.file;

import java.io.File;
import java.io.IOException;
import java.util.Date;

/**
 * @author xuzhou
 * @version 1.0.0
 * @title TestFile
 * @date 2021/2/22 17:48
 */
public class TestFile {
    public static void main(String[] args) {
        File file = new File("d:/LOLFolder/LOL.exe");
        File file1 = new File("D:/projects/test.txt");
//        fileProperty(file);
        fileMethod();

    }

    private static void testFile(){
        File f1 = new File("d:/LOLFolder");
        System.out.println("f1的绝对路径：" + f1.getAbsolutePath());

        File f2 = new File("d:/LOL.exe");
        System.out.println("f2的绝地路径：" + f2.getAbsolutePath());

        File f3 = new File(f1, "LOL.exe");
        System.out.println("f3的绝对路径：" + f3.getAbsolutePath());
    }

    private static void fileProperty(File file){

        System.out.println("当前文件是：" + file);
        System.out.println("是否存在：" + file.exists());
        System.out.println("判断是否为文件夹：" + file.isDirectory());
        System.out.println("判断是否为文件：" + file.isFile());
        System.out.println("File's length:" + file.length());

        long time = file.lastModified();
        Date date = new Date(time);
        System.out.println("File lastModified:" + file.lastModified() + "，转为时间为：" + date);
        file.setLastModified(0);

        File file1 = new File("d:/LOLFloder/DOTA.exe");
        file.renameTo(file1);
        System.out.println("文件改为为：" + file);

    }

    private static void fileMethod(){
        File f = new File("d:/LOLFolder/skin/garen.ski");

        // 以字符串数组的形式，返回当前文件夹下的所有文件（不包含子文件及子文件夹）
        f.list();

        // 以文件数组的形式，返回当前文件夹下的所有文件（不包含子文件及子文件夹）
        File[] fs= f.listFiles();

        // 以字符串形式返回获取所在文件夹
        f.getParent();

        // 以文件形式返回获取所在文件夹
        f.getParentFile();
        // 创建文件夹，如果父文件夹skin不存在，创建就无效
        f.mkdir();

        // 创建文件夹，如果父文件夹skin不存在，就会创建父文件夹
        f.mkdirs();

        // 创建一个空文件,如果父文件夹skin不存在，就会抛出异常
        try {
            f.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 所以创建一个空文件之前，通常都会创建父目录
        f.getParentFile().mkdirs();

        // 列出所有的盘符c: d: e: 等等
        f.listRoots();

        // 刪除文件
        f.delete();

        // JVM结束的时候，刪除文件，常用于临时文件的删除
        f.deleteOnExit();
    }

}
