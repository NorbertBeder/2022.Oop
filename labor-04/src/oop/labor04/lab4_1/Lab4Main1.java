package oop.labor04.lab4_1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Lab4Main1 {
    public static void main(String[] args) {
        //readFilePrintItsLineNumbered("lab4_1_input.txt");
        ArrayList<Person> persons1 = readFromCSVFile("lab4_1_input.csv");
        for (Person person: persons1){
            System.out.println(person);
        }
    }

    public static void readFilePrintItsLineNumbered(String fileName) {
        try (Scanner scanner = new Scanner(new File(fileName))) {
            while (scanner.hasNextLine()) {
                System.out.println(scanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            //System.out.println("File not found: " + fileName);
            e.printStackTrace();
        }
    }

    public static ArrayList<Person> readFromCSVFile(String fileName) {
        ArrayList<Person> persons = new ArrayList<>();
//        persons.add(new Person("Denes","David",1999));
//        persons.add(new Person("Biro","Julianna",2002));
//        System.out.println(persons.size());
//        System.out.println("Person arraylist:");
//        for (Person person: persons){
//            System.out.println("\t" + person);
//        }

        try(Scanner scanner = new Scanner(new File(fileName))){
        while( scanner.hasNextLine() ){
            String line = scanner.nextLine();
            if( line.isEmpty() ){
                continue;
            }
            String[] items = line.split(",");
// trim: eliminates leading and trailing spaces
            String firstName = items[0].trim();
            String lastName = items[1].trim();
// Convert String → int: Integer.parseInt( String)
            int birtYear = Integer.parseInt(items[2].trim());
            persons.add( new Person(firstName, lastName, birtYear));
        }

        } catch (FileNotFoundException e) {
            //System.out.println("File not found: " + fileName);
            e.printStackTrace();
        }
        return persons;
    }
}
