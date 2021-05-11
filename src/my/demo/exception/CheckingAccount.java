package my.demo.exception;

/**
 * @author xuzhou
 * @version 1.0.0
 * @title CheckingAccount
 * @description
 * @date 2020/11/2 13:56
 */
public class CheckingAccount extends Account {
    /**
     * 透支额度
     */
    public double overdraftProtection;


    public CheckingAccount(double balance,double protest){
        super(balance);
        this.overdraftProtection = protest;
    }

    @Override
    public void withdraw(double amt) throws OverDraftException {
        if(amt > this.balance){
            double overMoney = amt - this.balance;
            if(overMoney>this.overdraftProtection){
                throw new OverDraftException("已超过透支额度",overMoney - this.overdraftProtection);
            }else {
                this.balance = 0.0;
                this.overdraftProtection -= overMoney;
                System.out.println("账户余额为"+this.balance + "元");
                System.out.println("已透支额度"+this.overdraftProtection + "元");
            }
        }else {
            this.balance -= amt;
            System.out.println("账户余额为"+this.balance);
        }
    }

    /**
     * 构造函数
     *
     * @param balance 余额
     */
    public CheckingAccount(double balance) {
        super(balance);
    }


}
