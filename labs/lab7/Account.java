public class Account {
    private double balance;

    public Account() {
        balance = 0;
    }

    public void deposit(double money) {
        this.balance += money;
        System.out.println(this.balance);
    }

    public void withdraw(double money) throws NotEnoughMoneyException {
        if (this.balance < money) {
            throw new NotEnoughMoneyException(this.balance, money);
        }
        this.balance -= money;
        System.out.println(this.balance);
    }

    public double getBalance() {
        return balance;
    }

}
