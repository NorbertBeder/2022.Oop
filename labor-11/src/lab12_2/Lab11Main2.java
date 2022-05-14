package lab12_2;

import lab10_1.DateUtil;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;

public class Lab11Main2 {
    public static void main(String[] args) {
        File file = new File("students.csv");

        try (Scanner scanner = new Scanner(file)) {
            PrintStream ps = new PrintStream("warning.csv");

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (line.isEmpty()) {
                    continue;
                }
                String[] items = line.split(",");
                try {
                    if (items.length < 7) {
                        throw new Exception("INCOMPLETE LINE");
                    }

                    int credits;

                    try {
                        credits = Integer.parseInt(items[3].trim());
                    } catch (NumberFormatException e) {
                        throw new Exception("NUMBER FORMAT EXCEPTION");
                    }
                    int year, month, day;

                    try {
                        year = Integer.parseInt(items[4].trim());
                        month = Integer.parseInt(items[5].trim());
                        day = Integer.parseInt(items[6].trim());
                    } catch (NumberFormatException e) {
                        throw new Exception("INVALID DATE AND NUMBER FORMAT EXCEPTION");
                    }

                    if (!DateUtil.isValidDate(year, month, day)) {
                        throw new Exception("INVALID DATE");
                    }
                    if (credits < 30) {
                        for (String item : items) {
                            ps.print(item);
                        }
                        ps.println();
                    }


                } catch (Exception e) {
                    System.out.println();
                    System.out.println(e.getMessage());
                    System.out.println(line);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
