package my.demo.exception;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.sun.xml.internal.ws.util.StringUtils;

/**
 * @author xuzhou
 * @version 1.0.0
 * @title TestException
 * @date 2021/2/22 15:15
 */
public class TestException {
    public static void main(String[] args) {

        method1();

    }

    private static void insert(final int pos, final String b) throws MyException{
        if(pos < 0){
            throw new IndexIsNagetiveExceprion();
        }
        if(null == b){
            throw new IndexIsOutofRangeException();
        }

    }

    private static void throwMyException() throws MyException {
        throw new MyException("抛出自定义异常");
    }

    private static int method(){
        File f = new File("D:/file/15.jpg");
        int x = 0;
        try {
            new FileInputStream(f);
            x = 1;
            System.out.println(x);
            return x;
        } catch (FileNotFoundException e) {
            x = 2;
            System.out.println(x);
            return x;
        } finally {
            x = 3;
            System.out.println(x);
            return x;
        }

    }
    private static void method1(){
        try {
            method2();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static void method2() throws FileNotFoundException {

        File f = new File("D:/file/13.jpg");
        new FileInputStream(f);

    }

    private static void method4(){

        File f = new File("D:/file/11.jpg");

        try {
            new FileInputStream(f);
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date d = simpleDateFormat.parse("2016-06") ;
        } catch (FileNotFoundException | ParseException e) {
            if(e instanceof FileNotFoundException){
                System.out.println("打开文件异常");
            }
            if(e instanceof ParseException){
                System.out.println("日期转换异常");

            }
            e.printStackTrace();
        } finally {
            System.out.println("无论文件是否存在，都执行的代码");
        }
    }


}
