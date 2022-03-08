package oop.labor04.lab4_3;

public class Lab4Main3 {
    public static void main(String[] args) {
        MyArray a1 = new MyArray(5);
        a1.print("a1");
        a1.fillRandom(0.00, 9.00);
        a1.print("a1");
        a1.sort();
        a1.print("a1");
        System.out.printf("\tMean:   %10.2f \n\tStddev: %10.2f\n",
                a1.mean(), a1.stddev());
        double[] t = {4, 9, 0, -34, 28, 76, 100, -1};
        MyArray a2 = new MyArray(t);
        a2.print2("a2");
        a2.sort2();
        a2.print2("a2");
        System.out.printf("\tMean: %10.2f \n\tStddev: %10.2f\n",
                a2.mean2(), a2.stddev2());
        MyArray a3 = new MyArray("data.txt");
        a3.readFromFile();
        a3.print("a3");
        a3.sort();
        a3.print("a3");
        System.out.printf("\tMean:   %10.2f \n\tStddev: %10.2f\n",
                a3.mean(), a3.stddev());
    }
}