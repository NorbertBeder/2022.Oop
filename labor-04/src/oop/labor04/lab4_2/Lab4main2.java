package oop.labor04.lab4_2;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Lab4main2 {
    public static void main(String[] args) {
        ArrayList<Customer> customers = readFromFile("lab4_2_input.txt");
        for (Customer customer : customers){
            System.out.println(customer);
        }
    }
    public static ArrayList<Customer> readFromFile(String fileName) {
        ArrayList<Customer> customers = new ArrayList<>();
        String firstName;
        String lastName;
        int i = -1;
        try (Scanner scanner = new Scanner(new File(fileName))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (line.isEmpty()) {
                    continue;
                }
                String[] items = line.split(",");
                if (items[0].trim().equals("Customer")) {
                    firstName = items[1].trim();
                    lastName = items[2].trim();
                    customers.add(new Customer(firstName, lastName));
                    i++;
                }
                if (items[0].trim().equals("Account")) {
                    customers.get(i).addAccount(new BankAccount(items[1].trim()));
                    customers.get(i).getAccount(items[1].trim()).deposit(Integer.parseInt(items[2].trim()));
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return customers;
    }
}