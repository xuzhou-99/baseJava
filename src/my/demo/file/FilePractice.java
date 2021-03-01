package my.demo.file;

import java.io.File;
import java.util.Objects;

/**
 * @author xuzhou
 * @version 1.0.0
 * @title FilePractice
 * @date 2021/2/23 16:08
 */
public class FilePractice {

    static long minSize = Integer.MAX_VALUE;
    static long maxSize = 0;
    static File minFile = null;
    static File maxFile = null;

    public static void main(String[] args) {

//        localFile1();
//        localFile2();
//
//        localFile3();
        File f = new File("c:/windows");

        localFileRecursive(f);

        System.out.println("The max file is: " + maxFile + ", size is: " + maxFile.length() + " byte"  );
        System.out.println("The min file is: " + minFile + ", size is: " + minFile.length() + " byte"  );

    }

    private static void localFile1(){
        File file = new File("c:/windows");
        File maxFile;
        File minFile;

        if (!file.exists()) {
            System.out.println("该文件或文件夹不存在");
            return;
        }
        File[] files = file.listFiles();


        long StartTime = System.currentTimeMillis();
        File[] files1 = new File[files.length];
        int i=0;
        for(File f : files){
            if(f.isFile() && f.length() > 0){
                files1[i] = f;
                i++;
            }
        }

        maxFile = minFile = files1[0];
        for (File f :
                files1) {
            if(Objects.nonNull(f) && f.length() > maxFile.length()){
                maxFile = f;
            }
            if(Objects.nonNull(f) && f.length() < minFile.length()){
                minFile = f;
            }
        }

        long EndTime = System.currentTimeMillis();
        System.out.println("Use time : " + (EndTime - StartTime));
        System.out.println("The max file is: " + maxFile + ", size is: " + maxFile.length() + " byte"  );
        System.out.println("The min file is: " + minFile + ", size is: " + minFile.length() + " byte"  );
    }


    private static void localFile2(){
        File file = new File("c:/windows");
        File maxFile = null;
        File minFile = null;

        if (!file.exists()) {
            System.out.println("该文件或文件夹不存在");
            return;
        }
        File[] files = file.listFiles();

        long StartTime = System.currentTimeMillis();
        for (File f : files) {

            if (f.isFile() && f.length() > (Objects.isNull(maxFile) ? 0 :maxFile.length())) {
                maxFile = f;
            }
            if(f.isFile() && f.length() < (Objects.isNull(minFile) ? 1024*1024*1024 :minFile.length())){
                minFile = f;
            }
        }

        long EndTime = System.currentTimeMillis();
        System.out.println("Use time : " + (EndTime - StartTime));
        System.out.println("The max file is: " + maxFile + ", size is: " + maxFile.length() + " byte"  );
        System.out.println("The min file is: " + minFile + ", size is: " + minFile.length() + " byte"  );
    }

    private static void localFile3(){
        File f = new File("c:/windows");
        File[] fs = f.listFiles();
        if(null==fs) {
            return;
        }
        long minSize = Integer.MAX_VALUE;
        long maxSize = 0;
        File minFile = null;
        File maxFile = null;
        for (File file : fs) {
            if(file.isDirectory()) {
                continue;
            }
            if(file.length()>maxSize){
                maxSize = file.length();
                maxFile = file;
            }
            if(file.length()!=0 && file.length()<minSize){
                minSize = file.length();
                minFile = file;
            }
        }
        System.out.printf("最大的文件是%s，其大小是%,d字节%n",maxFile.getAbsoluteFile(),maxFile.length());
        System.out.printf("最小的文件是%s，其大小是%,d字节%n",minFile.getAbsoluteFile(),minFile.length());
    }

    private static void localFileRecursive(File file){

            if(file.isFile() && file.length() > maxSize){
                maxSize = file.length();
                maxFile = file;
            }
            if(file.isFile() && file.length() < minSize){
                minSize = file.length();
                minFile = file;
            }
            if(file.isDirectory()){
                File[] files = file.listFiles();
                if(files != null){
                    for(File file1 : files){
                        localFileRecursive(file1);
                    }
                }
            }
    }
}
