package lab8_1;

public class BankAccount {

        protected double balance;
        protected final String accountNumber;
        public static final String PREFIX = "OTP";
        protected static int numAccounts = 0;

        protected BankAccount() {
            numAccounts++;
            this.accountNumber = createAccountNumber();
        }

        private static String createAccountNumber(){
            return String.format("%s%7d",PREFIX,numAccounts).replace(' ', '0');
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
