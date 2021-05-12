package my.demo.exception;

/**
 * @author xuzhou
 * @version 1.0.0
 * @title Account
 * @date 2021/2/22 15:59
 */
public class Account {
    /**
     * 余额
     */
    protected double balance;

    public Account(double balance){
        this.balance = balance;
    }

    /**
     * 获取余额
     * @return double
     */
    public double getBalance(){
        return this.balance;
    }

    /**
     * 存钱
     * @param atm 金额
     */
    public void deposit(double atm){
        this.balance += atm;
    }

    /**
     * 取钱
     * @param atm 金额
     */
    public void withdraw(double atm) throws OverdraftException {
        if(this.balance < atm){
            throw new OverdraftException("余额不足", atm - this.balance);
        }
        this.balance -= atm;
    }

}
