package my.demo.io;

import java.io.File;

/**
 * @author xuzhou
 * @version 1.0.0
 * @title TestFile
 * @description
 * @date 2020/11/2 14:24
 */
public class TestFile {
   static File maxFile = null;
    static long maxlength = 0;
    static File minFile = null;
    static long minlength = Long.MAX_VALUE;

    public static void checkMaxAndMin(File file){

        if(file.isFile()){
            if(file.length()>maxlength){
                maxFile = file;
                maxlength  = file.length();
            }
            if(file.length()<minlength && file.length()!=0){
                minFile = file;
                minlength = file.length();
            }
        }
        if(file.isDirectory()){
            File[] fs = file.listFiles();
            if(fs!=null){
                for(File f :fs) {

                        checkMaxAndMin(f);

                }
            }

        }
    }

    public static void main(String[] args) {

        File file = new File("C:\\Windows");

        checkMaxAndMin(file);



        System.out.println("最大的文件是："+maxFile+","+"其大小为"+maxlength);
        System.out.println("最小的文件是："+minFile+","+"其大小为"+minlength);



    }

//    static long maxL= 0;
//    static long minL=Integer.MAX_VALUE;
//    static File minF= null;
//    static File maxF= null;
//
//    public static void listFile(File file)
//    {
//
//        if(file.isFile())
//        {
//            if(file.length()>maxL)
//            {
//                maxL=file.length();
//                maxF=file;
//            }
//            if(file.length()!=0&file.length()<minL)
//            {
//                minL=file.length();
//                minF=file;
//            }
//        }
//        if(file.isDirectory())
//        {
//            File[]fs= file.listFiles();
//            if(fs!=null)
//            {
//                for(File f: fs)
//                {
//                    listFile(f);
//                }
//            }
//        }
//
//    }
//    public static void main(String[] args) {
//
//        System.out.println("遍历电脑中System文件里的最大文件和最小文件如下：");
//        File f= new File("c:\\windows");
//        listFile(f);
//        System.out.printf("得到的最大值文件路径为%s,其大小为%d",maxF.getAbsolutePath(),maxL);
//        System.out.println();
//        System.out.printf("得到的最小值文件路径为%s,其大小为%d",minF.getAbsolutePath(),minL);
//
//    }
}
