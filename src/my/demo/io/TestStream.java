package my.demo.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author xuzhou
 * @version 1.0.0
 * @title TestStream
 * @description
 * @date 2020/11/2 15:58
 */
public class TestStream {


    public static void split(){
        int num=0;
        File file = new File("d:/file/test.pdf");
        System.out.println(file.length());

        if(file.length()%(1024*100)==0){
            num = (int)(file.length()/(1024*100));
        }else {
            num = (int) (file.length()/(1024*100))+1;
        }
        System.out.println("分成文件的数量为"+num);

        try {
            FileInputStream fis = new FileInputStream(file);
            byte[] bytes = new byte[(int)file.length()];
            fis.read(bytes);
            for(int i = 1;i<=num;i++){
                if(i<num){
                    //前几个文件都为1024
                    FileOutputStream fos = new FileOutputStream("d:/file/test/test"+"-"+i+".pdf");
                    fos.write(bytes,(i-1)*1024*100,1024*100);
                    fos.close();
                }
                if(i==num){
                    //最后一个文件不一定满1024
                    FileOutputStream fos = new FileOutputStream("d:/file/test/test"+"-"+i+".pdf");
                    fos.write(bytes,(i-1)*1024*100,(int)file.length()-(i-1)*1024*100);
                    fos.close();
                }
            }
            fis.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static void merge() throws IOException {
        File file = new File("d:/file/test/pdf/");
        File[] files = file.listFiles();
        FileOutputStream fos = null;
        FileInputStream fis = null;


        try{
            for(File file1:files){
                fis = new FileInputStream(file1);
                byte[] bytes = new byte[(int) file1.length()];

                while (fis.read(bytes)>0){

                    fos = new FileOutputStream("d:/file/test/ccc.pdf",true);
                    fos.write(bytes);

                    fos.close();
                    fis.close();
                }

            }

        }catch (IOException e){
            e.printStackTrace();
        }finally {
            if(fis!=null){
                fis.close();
            }
            if(fos !=null){
                fos.close();
            }

        }

    }

}
