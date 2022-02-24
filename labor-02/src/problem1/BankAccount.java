package problem1;

public class BankAccount{

    private double balance;
    private String accountNumber;
    public BankAccount(String accountNumber){
        this.accountNumber = accountNumber;
    }
    public String getAccountNumber(){
        return this.accountNumber;
    }
    public double getBalance(){
        return this.balance;
    }
    public void deposit(double money){
        if(money > 0){
            this.balance += money;
        }
    }
    public boolean withdraw(double funds){
        if(funds <= balance){
            balance -= funds;
            return true;
        }
        return false;
    }
}
