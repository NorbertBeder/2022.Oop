package lab8_1;

public class CheckingAccount extends BankAccount {
    private double overdraftLimit;

    public CheckingAccount(double overdraftLimit) {
        this.overdraftLimit = overdraftLimit;
    }

    public double getOverdraftLimit() {
        return overdraftLimit;
    }

    public void setOverdraftLimit(double overdraftLimit) {
        this.overdraftLimit = overdraftLimit;
    }

    public boolean withdraw(double funds){
        if(funds <= overdraftLimit + balance){
            balance -= funds;
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "CheckingAccount{" +
                "balance=" + balance +
                ", accountNumber='" + accountNumber + '\'' +
                ", overdraftLimit=" + overdraftLimit +
                '}';
    }
}
