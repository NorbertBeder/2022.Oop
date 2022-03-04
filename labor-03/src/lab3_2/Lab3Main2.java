package lab3_2;
import java.util.Random;


public class Lab3Main2 {
    public static void main(String[] args) {
        Customer account1 = new Customer("John", "BLACK");
        Customer account2 = new Customer("Mary","WHITE");
        Random rand = new Random();
        for(int i = 0; i < 5; i++){
            account1.addAccount(new BankAccount("OTP0001" + i));
            account1.getAccount("OTP0001" + i).deposit(1 + rand.nextInt(1000));
        }

        for(int i = 0; i < 9; i++){
            account2.addAccount(new BankAccount("OTP0002" + i));
            account2.getAccount("OTP0002" + i).deposit(1 + rand.nextInt(1000));
        }
        System.out.println(account1.toString());
        System.out.println(account2.toString());
        account1.closeAccount("OTP00010");
        account2.closeAccount("OTP00018");
        System.out.println(account1.toString());
        System.out.println(account2.toString());
    }
}
