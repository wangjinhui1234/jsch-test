package lock.backAccount;

public class SynchronizedBankAccount {
    private double balance = 0.0;

    //村存款方式
    public synchronized void deposit(double amount) {
        balance += amount;
    }

    //取款
    public synchronized void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
        }
    }

    //获取余额
    public synchronized double getBalance() {
        return balance;
    }
}
