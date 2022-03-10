package oop.labor04.lab4_3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class MyArray {
    private int length;
    private double[] elements;

    public MyArray(int length) {
        this.length = length;
    }

    public MyArray(double[] elements) {
        this.elements = elements;
    }

    public MyArray(String fileName) {
        try (Scanner scanner = new Scanner(new File(fileName))) {
            length = scanner.nextInt();
            elements = new double[length];
            for (int i = 0; i < length; i++) {
                elements[i] = scanner.nextDouble();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public MyArray(MyArray a3){
        length = a3.length;
        elements = new double[length];
        for (int i = 0; i < length; i++){
            elements[i] = a3.elements[i];
        }
    }

    public void fillRandom(double start, double end) {
        Random random = new Random();
        elements = new double[length];
        for (int i = 0; i < elements.length; i++) {
            elements[i] = (start + random.nextInt(900) / 100.00);
        }
    }

    public double mean() {
        double sum = 0;
        for (Double elem : elements) {
            sum += elem;
        }
        return sum / elements.length;
    }

    public double stddev() {
        double sum = 0.0;
        double stddev = 0.0;
        for (Double elem : elements) {
            sum += elem;
        }
        double mean = sum / elements.length;
        for (Double elem : elements) {
            stddev += Math.pow(elem - mean, 2);
        }
        return Math.sqrt(stddev / elements.length);
    }

    public void sort() {
        Arrays.sort(elements);
    }

    public void print(String a) {
        System.out.println(a + ":\t" + Arrays.toString(elements));
    }
}
