package lab3_2;

import lab3_1.BankAccount;

public class Customer {
    private String firstName;
    private String lastName;
    public static final int MAX_ACCOUNTS = 10;
    private int numOfAccounts;
    private BankAccount[] accounts = new BankAccount[MAX_ACCOUNTS];

    public Customer(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getNumOfAccounts() {
        return numOfAccounts;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void addAccount(BankAccount account) {
        if (numOfAccounts < MAX_ACCOUNTS) {
            this.accounts[this.numOfAccounts] = account;
            this.numOfAccounts++;
        }
    }

    public String getAccount(String accountNumber) {
        for (int i = 0; i < numOfAccounts; i++){
            if(accounts[i].getAccountNumber().equals(accountNumber)) {
                return accounts[i].getAccountNumber();
            }
        }
        return null;
    }

    public void closeAccount(String accountId){
        for (int i = 0; i < numOfAccounts; i++){
            if(accounts[i].getAccountNumber().equals(accountId)){
                accounts[i] = accounts[accounts.length - 1];
                this.numOfAccounts--;
                return;
            }
        }
    }

    public String toString(){
        StringBuffer result = new StringBuffer();
        result.append(firstName + ' ' + lastName + "accounts:\n");
        for (int i = 0; i < numOfAccounts; i++){
            result.append("\t" + accounts[i].toString() + "\n");
        }
        return result.toString();
    }
}
