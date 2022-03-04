package lab3_1;

public class Lab3Main1 {
    public static void main(String[] args) {
        Customer customer1 = new Customer("John","BLACK");
        System.out.println(customer1.toString());
        customer1.setAccount(new BankAccount("OTP00001"));
        System.out.println(customer1.toString());
        customer1.getAccount().deposit(1000);
        System.out.println(customer1);

        Customer customer2 = new Customer("Marry","WHITE");
        customer2.setAccount(new BankAccount("OTP00002"));
        System.out.println(customer2);
        customer2.getAccount().deposit(2000);
        customer2.getAccount().withdraw(1500);
        //customer2.closeAccount();
        System.out.println(customer2);
        customer2.setLastName("BLACK");
        customer2.getAccount().deposit(customer1.getAccount().getBalance());
        //customer2.setAccount(customer1.getAccount());
        System.out.println(customer1.toString());
        System.out.println(customer2.toString());
    }
}
