package lab10_1;

import java.util.*;

public class Lab10Main1 {
    public static void main(String[] args) {
        Random rand = new Random();
        ArrayList<MyDate> dates = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            int year = rand.nextInt(2022 - 2018) + 2018;
            int month = 1 + rand.nextInt(12);
            int day = 1 + rand.nextInt(31);
            if (DateUtil.isValidDate(year, month, day)) {
                dates.add(new MyDate(year, month, day));
            }
        }
        for (MyDate date : dates) {
            if (date != null) {
                System.out.println(date);
            }
        }

        System.out.println();
        Collections.sort(dates);
        for (MyDate date : dates) {
            if (date != null) {
                System.out.println(date);
            }
        }
        System.out.println();
        Collections.sort(dates, new Comparator<MyDate>() {
            @Override
            public int compare(MyDate o1, MyDate o2) {
                if (o1.getYear() != o2.getYear()) {
                    return o2.getYear() - o1.getYear();
                }
                if (o1.getMonth() != o2.getMonth()) {
                    return o2.getMonth() - o1.getMonth();
                }
                return o2.getDay() - o1.getDay();
            }
        });
        for (MyDate date : dates) {
            if (date != null) {
                System.out.println(date);
            }
        }
    }
}
