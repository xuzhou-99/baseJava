package my.demo.exception;

/**
 * @author xuzhou
 * @version 1.0.0
 * @title MyException
 * @date 2021/2/22 15:46
 */
public class MyException extends Exception{
    public MyException(){

    }
    public MyException(String message){
        super(message);
    }
}
