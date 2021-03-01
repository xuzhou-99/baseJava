package my.demo.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * FileUtils
 *
 * @author xuzhou
 * @version 1.0.0
 * @title 文件拷贝工具类
 * @date 2021/2/24 17:05
 */
public class FileUtils {

    static final String SPLIT_FILE = "/";

    public static void main(String[] args) {
        String srcPath = "D:/projects/testFile/src/test.txt";
        String targetPath = "D:/projects/testFile/target/test.txt";
        String srcFolder = "D:/projects/testFile/src";
        String targetFolder = "D:/projects/testFile/target";

        File file = new File(srcFolder);
        searchFile(file, "te");
//        searchString(file, "a");
    }

    /**
     * 查询文件名
     *
     * @param file 文件或文件夹
     * @param name 要查询的字符串
     */
    public static void searchFile(File file, String name){
        if(file.isFile()){
            if(file.getName().contains(name)){
                System.out.println(file.getAbsolutePath());
            }
        }else {
            File[] listFiles = file.listFiles();
            assert listFiles != null;
            for (File f :
                    listFiles) {
                searchFile(f, name);
            }

        }
    }


    /**
     * 查询文件中或者文件夹中包含指定字符串的文件
     * 全匹配
     * @param file 文件
     * @param string 查询的字符串
     */
    public static void searchString(File file, String string){
        if(file.isFile()){
            try (FileInputStream fis = new FileInputStream(file); InputStreamReader reader = new InputStreamReader(fis)) {
                char[] chars = new char[(int) file.length()];
                reader.read(chars);
                String txt = new String(chars);
                if(txt.contains(string)){
                    System.out.println(file.getAbsolutePath());
                }
            }catch (IOException e){
                e.printStackTrace();
            }
        }else {
            File[] files = file.listFiles();
            for (File f :
                    files) {
                searchString(f, string);
            }
        }
    }

    /**
     * 文件夹拷贝
     *
     * Folder to Folder
     * 使用递归的方式，将原文件夹下所有文件及子文件夹拷贝到目标文件夹下
     * @param srcFolder 原文件夹
     * @param targetFolder 目标文件夹
     */
    public static void copyFolder(String srcFolder, String targetFolder){
        File srcFile = new File(srcFolder);
        File targetFile = new File(targetFolder);

        if(!targetFile.exists()){
            targetFile.mkdirs();
        }
        assert srcFile.isDirectory();

        File[] files = srcFile.listFiles();
        if(null == files){
            return;
        }
        for (File oldFile : files) {
            String newFilePath = targetFolder + SPLIT_FILE + oldFile.toString().substring(oldFile.toString().lastIndexOf("\\") + 1);
            File newFile = new File(newFilePath);
            if (oldFile.isFile()) {
                copyFile(oldFile, newFile);
            }else {
                copyFolder(oldFile.toString(), newFilePath);
            }
        }


    }

    /**
     * 文件拷贝
     *
     * path to path
     * {@linkplain FileInputStream} copy to {@linkplain FileOutputStream}
     * @param srcPath 原文件路径
     * @param targetPath 目标文件路径
     */
    public static void copyFile(String srcPath, String targetPath){
        File srcFile = new File(srcPath);
        File targetFile = new File(targetPath);
        if(!targetFile.exists()){
            targetFile.getParentFile().mkdirs();
        }

        copyFile(srcFile, targetFile);
    }

    /**
     * 文件拷贝
     *
     * File to File
     * {@linkplain FileInputStream} copy to {@linkplain FileOutputStream}
     * @param srcFile 原文件
     * @param targetFile 目标文件
     */
    public static void copyFile(File srcFile, File targetFile){
        try (
                FileInputStream fis = new FileInputStream(srcFile);
                FileOutputStream fos = new FileOutputStream(targetFile)
        ) {

            int byteRead;
            byte[] buffer = new byte[1024];
            while ((byteRead = fis.read(buffer)) > 0){
                fos.write(buffer, 0, byteRead);
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
