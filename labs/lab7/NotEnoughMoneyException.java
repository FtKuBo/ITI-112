public class NotEnoughMoneyException extends IllegalStateException {

    private double balance;
    private double amount;

    NotEnoughMoneyException(double balance, double amount) {
        this.balance = balance;
        this.amount = amount;
    }

    public double getAmount() {
        return this.amount;
    }

    public double getBalance() {
        return this.balance;
    }

    public double getMissingAmount() {
        return this.amount - this.balance;
    }

    public String getMessage() {
        return "you have not enought money to withdraw " + getAmount() + "$";
    }

}
