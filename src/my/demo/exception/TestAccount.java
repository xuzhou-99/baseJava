package my.demo.exception;

/**
 * @author xuzhou
 * @version 1.0.0
 * @title TestAccount
 * @date 2021/2/22 17:20
 */
public class TestAccount {
    public static void main(String[] args) {
//        Account account = new Account(1000);
//        account.deposit(1000);
//
//        System.out.println(account.getBalance());
//
//        try {
//            account.withdraw(2001);
//        } catch (OverdraftException e){
//            System.err.println("透支金额：" +e.getDeficit());
//        }


        CheckAccount checkAccount = new CheckAccount(1000, 500);
        checkAccount.deposit(1000);
        System.out.println(checkAccount.getBalance());

        try {
            checkAccount.withdraw(600);
            System.out.println("取款600，余额还剩："+checkAccount.getBalance());
            checkAccount.withdraw(600);
            System.out.println("取款600，余额还剩："+checkAccount.getBalance());
            checkAccount.withdraw(600);
            System.out.println("取款600，余额还剩："+checkAccount.getBalance());
            checkAccount.withdraw(600);
            System.out.println("取款600，余额还剩："+checkAccount.getBalance());
            checkAccount.withdraw(600);
            System.out.println("取款600，余额还剩："+checkAccount.getBalance());
        } catch (OverdraftException e) {
            System.err.println("透支超额：" +e.getDeficit());
        }

    }
}
