package my.demo.exception;

/**
 * @author xuzhou
 * @version 1.0.0
 * @title OverdraftException
 * @date 2021/2/22 16:04
 */
public class OverdraftException extends Exception{
    /**
     * 透支额
     */
    private double deficit;


    public OverdraftException(){

    }

    public double getDeficit(){
        return this.deficit;
    }

    public OverdraftException(String message, double deficit){
        super(message);
        this.deficit = deficit;
    }
}
