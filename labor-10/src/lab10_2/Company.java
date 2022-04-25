package lab10_2;

import lab10_1.MyDate;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

public class Company {
    private String name;
    private ArrayList<Employee> employees;

    public Company(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void hire(Employee employee){
        employees.add(employee);
    }
    public void hireAll(String fileName){
        try(Scanner scanner = new Scanner(new File(fileName))){
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (line.isEmpty()) {
                    continue;
                }
                String[] items = line.split(",");
                String firstName = items[0].trim();
                String lastName = items[1].trim();
                double salary = Integer.parseInt(items[2].trim());
                int year = Integer.parseInt(items[3].trim());
                int month = Integer.parseInt(items[4].trim());
                int day = Integer.parseInt(items[5].trim());
                MyDate date = new MyDate(year,month,day);
                if(items.length == 7){
                    String department = items[6].trim();
                    employees.add(new Manager(firstName,lastName,salary,date,department));
                }else{
                    employees.add(new Employee(firstName,lastName,salary,date));
                }
            }
        }catch (FileNotFoundException e){
            e.getStackTrace();
        }
    }

    public void fire(int index){
        employees.remove(index);
    }

}
