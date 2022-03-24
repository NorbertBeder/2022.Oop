package lab6_1;

import java.util.ArrayList;
import java.util.Random;

public class Lab6main1 {
    public static void main(String[] args) {
        ArrayList<BankAccount> bankAccounts = new ArrayList<>();
        ArrayList<Customer> customers = new ArrayList<>();
        ArrayList<String> accountNumbers;
        Random rand = new Random();

//        for (int i = 0 ; i < 150; i++){
//            bankAccounts.add(new BankAccount());
//        }
//        for (BankAccount bankAccount : bankAccounts){
//            System.out.println(bankAccount);
//        }


//        customers.add(new Customer("Black","Maria",3));
//        for (Customer customer : customers){
//            customer.addAccount(new BankAccount());
//        }
//        for(Customer customer: customers){
//            System.out.println(customer);
//        }

        Bank bank = new Bank("OTP");
        bank.addCustomer(new Customer("John","White"));
        bank.addCustomer(new Customer("Jones","McKenzie"));

        bank.getCustomer(1).addAccount(new BankAccount());
        bank.getCustomer(1).addAccount(new BankAccount());
        bank.getCustomer(2).addAccount(new BankAccount());
        bank.getCustomer(2).addAccount(new BankAccount());
        System.out.println(bank.getCustomer(1));
        for (int i = 1; i <= bank.numCustomers(); i++){
            accountNumbers = bank.getCustomer(i).getAccountNumbers();
            for (String accountNumber : accountNumbers){
                bank.getCustomer(i).getAccount(accountNumber).deposit(rand.nextInt(1000));
            }
        }
        System.out.println(bank.getCustomer(2));
        bank.printCustomersToFile("bank_customers.csv");
    }
}
