package oop.labor04.lab4_3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class MyArray {
    private int length;
    private double[] elements;
    private String fileName;
    private ArrayList<Double> numbers = new ArrayList<>();

    public MyArray(int length) {
        this.length = length;
    }

    public MyArray(double[] elements) {
        this.elements = elements;
    }

    public MyArray(String fileName) {
        this.fileName = fileName;
    }

    public void fillRandom(double start, double end) {
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            numbers.add(start + random.nextInt(90) / 10.0);
        }
    }

    public double mean(){
        double sum = 0.0;
        for (Double elem : numbers){
            sum += elem;
        }
        return sum/numbers.size();
    }

    public double mean2(){
        double sum = 0;
        for (Double elem : elements){
            sum += elem;
        }
        return sum/elements.length;
    }

    public double stddev() {
        double sum = 0.0;
        double stddev = 0.0;
        for (Double elem : numbers) {
            sum += elem;
        }
        double mean = sum / numbers.size();
        for (Double elem : numbers) {
            stddev += Math.pow(elem-mean,2);
        }
        return Math.sqrt(stddev/numbers.size());
    }

    public double stddev2() {
        double sum = 0.0;
        double stddev = 0.0;
        for (Double elem : elements) {
            sum += elem;
        }
        double mean = sum / elements.length;
        for (Double elem : elements) {
            stddev += Math.pow(elem-mean,2);
        }
        return Math.sqrt(stddev/elements.length);
    }

    public void sort(){
        Collections.sort(numbers);
    }

    public void sort2(){
        Arrays.sort(elements);
    }

    public void print2(String a) {
        System.out.println(a + "\t" + Arrays.toString(elements));
    }
    public void print(String a){
        System.out.println(a + ":\t" + numbers);
    }

    public void readFromFile(){
        try(Scanner scanner = new Scanner(new File(fileName))){
            length = scanner.nextInt();
            while (scanner.hasNextDouble()){
                numbers.add(scanner.nextDouble());
            }
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }
    }
}
