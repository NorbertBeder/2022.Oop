package lab8_1;

import java.util.ArrayList;
import java.util.Random;

public class Lab8Main1 {
    public static void main(String[] args) {

        Bank bank = new Bank("OTP");
        bank.addCustomer(new Customer("Nagy","Sandor"));
        bank.addCustomer(new Customer("Fekete","Zoltan"));
        double interestRate = 10;
        double overdraftLimit = 200;

        bank.getCustomer(1).addAccount(new SavingsAccount(interestRate));
        bank.getCustomer(1).addAccount(new CheckingAccount(overdraftLimit));

        bank.getCustomer(2).addAccount(new SavingsAccount(interestRate));
        bank.getCustomer(2).addAccount(new CheckingAccount(overdraftLimit));

        ArrayList<String > accountNumbers;
        Random rand = new Random();

        for (int i = 1; i <= bank.numCustomers(); i++) {
            accountNumbers = bank.getCustomer(i).getAccountNumbers();
            for (String accountNumber : accountNumbers) {
                bank.getCustomer(i).getAccount(accountNumber).deposit(rand.nextInt(1000));
            }
            System.out.println(bank.getCustomer(i));
        }
        System.out.println();
        for (int i = 1; i <= bank.numCustomers(); i++){
            accountNumbers = bank.getCustomer(i).getAccountNumbers();
            for (String accountNumber : accountNumbers){
                BankAccount bankAccount = bank.getCustomer(i).getAccount(accountNumber);
                if(bankAccount instanceof SavingsAccount){
                    ((SavingsAccount)bankAccount).addInterestRate(interestRate);
                }
                bankAccount.withdraw(10000);
            }
            System.out.println(bank.getCustomer(i));
        }
    }
}
