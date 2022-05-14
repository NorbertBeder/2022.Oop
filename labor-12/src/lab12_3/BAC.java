package lab12_3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

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
        int counter1 = 0, counter2 = 0;
        for (SUBJECT subject : SUBJECT.values()) {
            readMarks(subject);
        }
        for (Integer id : map.keySet()) {
            counter1++;
            if (map.get(id).calculateAverage() >= 6) {
                counter2++;
            }
        }
        System.out.println(counter2 + " out of a total of " + counter1 + " students passed the Bac.\n");
        System.out.println("The failed students: ");
        printFailed();
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

    public void printFailed(){
        TreeSet<Student> failed = new TreeSet<>((Comparator.comparing(o -> o.getFirstName().concat(o.getLastName()))));

        for (Integer id : map.keySet()) {
            if (map.get(id).getAverage() < 6) {
                failed.add(map.get(id));
            }
        }
        for (Student student : failed){
            System.out.println(student);
        }
    }

}
