package problem1;

public class Lab2Main1 {
    public static void main(String[] args) {
        BankAccount account1 = new BankAccount("OTP000001");
        System.out.println(account1.getAccountNumber() + ": " + account1.getBalance());
        account1.deposit(1000);
        System.out.println(account1.getAccountNumber() + ": " + account1.getBalance());
        boolean result = account1.withdraw(500);
        if (!result) {
            System.out.println("You do not have sufficient funds for this operation!");
        }else{
            System.out.println(account1.getAccountNumber()+": "+account1.getBalance());
        }
        result = account1.withdraw(1000);
        if (!result) {
            System.out.println("You do not have sufficient funds for this operation!");
        }else{
            System.out.println(account1.getAccountNumber() + ": " + account1.getBalance());
        }
        BankAccount account2 = new BankAccount("OTP000002");
        System.out.println(account2.getAccountNumber() + ": " + account2.getBalance());
        account2.deposit(2000);
        System.out.println(account2.getAccountNumber() + ": " + account2.getBalance());
    }
}
