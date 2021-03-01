package my.demo.exception;

/**
 * @author xuzhou
 * @version 1.0.0
 * @title CheckAccount
 * @date 2021/2/22 17:18
 */
public class CheckAccount extends Account{

    /**
     * 透支额度
     */
    private double overdraftProtection;

    public CheckAccount(double balance) {
        super(balance);
    }

    public CheckAccount(double balance, double protect){
        super(balance);
        this.overdraftProtection = protect;
    }


    @Override
    public void withdraw(double atm) throws OverdraftException {

        if(atm > this.balance + overdraftProtection){
            double deficit = atm - (this.balance + overdraftProtection);
            throw new OverdraftException("透支额度超标", deficit);
        }

        if(atm > this.balance){
            this.balance = 0;
            overdraftProtection -= (atm - balance);
        }else {
            this.balance -= atm;
        }
    }
}
