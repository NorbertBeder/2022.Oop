package lab6_1;

import java.util.ArrayList;

public class Customer {
    private static int numCustomers = 1;
    private final String firstName;
    private String lastName;
    private final ArrayList<BankAccount> accounts = new ArrayList<>();
    private final int id;

    public Customer(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.id = numCustomers;
        numCustomers++;
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public ArrayList<String> getAccountNumbers(){
        ArrayList<String> accountNumbers = new ArrayList<>();
        for (BankAccount account : accounts){
            accountNumbers.add(account.getAccountNumber());
        }
        return accountNumbers;
    }

    public void addAccount(BankAccount account) {
            this.accounts.add(account);
    }

    public BankAccount getAccount(String accountNumber) {
        for (BankAccount bankAccount : accounts){
            if(bankAccount.getAccountNumber().equals(accountNumber)){
                return bankAccount;
            }
        }
        return null;
    }

    public void closeAccount(String accountId){
        for (BankAccount bankAccount : accounts){
            if (bankAccount.getAccountNumber().equals(accountId)){
                accounts.remove(bankAccount);
            }
        }
    }

    @Override
    public String toString() {
        return "Customer{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", accounts=" + accounts +
                ", id=" + id +
                '}';
    }

    public int getNumAccounts() {
        return accounts.size();
    }
}
