package lock.backAccount;

public class BankAccountExample {
    public static void main(String[] args) throws InterruptedException {
        SynchronizedBankAccount synchronizedBankAccount = new SynchronizedBankAccount();

        Runnable r1 = () -> {
            for (int i = 0; i < 1000; i++) {
                synchronizedBankAccount.deposit(3);
            }
        };


        Runnable r2 = () -> {
            for (int i = 0; i < 1000; i++) {
                synchronizedBankAccount.withdraw(2);
            }
        };

        Thread t1 = new Thread(r1);
        Thread t2 = new Thread(r2);


        t1.start();
        t2.start();


        t1.join();
        t2.join();

        System.out.println("银行账户余额为" + synchronizedBankAccount.getBalance());
    }
}
