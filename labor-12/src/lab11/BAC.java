package lab11;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

enum SUBJECT {
    ROMANIAN("roman.txt"), HUNGARIAN("magyar.txt"), MATH("matek.txt");
    private final String name;

    SUBJECT(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
};

public class BAC {
    private final Map<Integer, Student> map = new HashMap<>();


    public BAC() {
        readNames();
        int counter = 0;
        for (SUBJECT subject : SUBJECT.values()) {
            readMarks(subject);
        }
        for (Integer id : map.keySet()) {
            if (calcAve(id)){
                counter++;
            }
        }
        System.out.println(counter);
    }

    public void readNames() {
        try (Scanner scanner = new Scanner(new File("nevek1.txt"))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (line.isEmpty()) {
                    continue;
                }
                String[] items = line.split(" ");
                int id = Integer.parseInt(items[0].trim());
                String firstName = items[1].trim();
                String lastName = items[2].trim();
                map.put(id, new Student(id, firstName, lastName));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void readMarks(SUBJECT subject) {
        try (Scanner scanner = new Scanner(new File(subject.getName()))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (line.isEmpty()) {
                    continue;
                }
                String[] items = line.split(" ");

                int id = Integer.parseInt(items[0].trim());

                double mark = Double.parseDouble(items[1].trim());

                if (map.get(id) != null) {
                    switch (subject) {
                        case MATH -> map.get(id).setMath(mark);

                        case ROMANIAN -> map.get(id).setRomanian(mark);

                        case HUNGARIAN -> map.get(id).setHungarian(mark);
                    }
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public boolean calcAve(Integer id) {
        if (map.get(id).getHungarian() < 5 || map.get(id).getRomanian() < 5 || map.get(id).getMath() < 5) {
            return false;
        }
        double average = (map.get(id).getHungarian() + map.get(id).getRomanian() + map.get(id).getMath()) / 3;
        if(average < 6){
            return false;
        }else {
            map.get(id).setAverage(average);
            return true;
        }

    }
}
