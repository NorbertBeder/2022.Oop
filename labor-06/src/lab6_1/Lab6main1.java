package lab6_1;

import java.util.ArrayList;

public class Lab6main1 {
    public static void main(String[] args) {
        ArrayList<BankAccount> bankAccounts = new ArrayList<>();
        for (int i = 0 ; i < 150; i++){
            bankAccounts.add(new BankAccount());
        }
        for (BankAccount bankAccount : bankAccounts){
            System.out.println(bankAccount);
        }

    }
}
