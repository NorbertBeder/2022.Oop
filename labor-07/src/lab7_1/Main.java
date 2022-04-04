package lab7_1;

import problem3.MyDate;

public class Main {
    public static void main(String[] args) {
        MyDate date = new MyDate(2020,3,5);
        Document document = new Document("Dokument",date);
        String fileName = document.getName() + ".txt";

        document.appends("Kek az eg");
        document.appends("Repulnek a madarak");

        document.printToSTDOutput();

        document.appends("Ez a fileba megy");
        document.printToFile(fileName);

        System.out.println("\n" + document.toString());

        Document document2 = new Document("Dokument2",date,fileName);

        document2.printToSTDOutput();
    }
}
