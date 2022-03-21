package lab6_1;

public class BankAccount {

        private double balance;
        private final String accountNumber;
        public static final String PREFIX = "OTP";
        private static int numAccounts = 0;
        public static int ACCOUNT_NUMBER_LENGTH = 10;

        public BankAccount() {
            numAccounts++;
            this.accountNumber = createAccountNumber();
        }

        private static String createAccountNumber(){
            return String.format("%s%s%7d",PREFIX,"",numAccounts).replace(' ', '0');
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



        @Override
        public String toString() {
            return "BankAccount{" +
                    "accountNumber=" + accountNumber +
                    ", balance='" + balance + '\'' +
                    '}';
        }
}
