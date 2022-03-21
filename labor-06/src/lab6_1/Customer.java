package lab6_1;

import java.util.ArrayList;

public class Customer {
    private static int numCustomers;
    private final String firstName;
    private String lastName;
    private final ArrayList<BankAccount> accounts = new ArrayList<>();
    private final int id;

    public Customer(String firstName, String lastName, int id) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.id = id;
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

    public String toString(){
        StringBuffer result = new StringBuffer();
        result.append(firstName + ' ' + lastName + " accounts:\n");
        for (BankAccount bankAccount : accounts){
            result.append("\t" + bankAccount.toString() + "\n");
        }
        return result.toString();
    }
}
