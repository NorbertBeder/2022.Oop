package problem3;
import java.util.Random;

public class Lab2Main3 {
    public static void main(String[] args) {
        Random rand = new Random();
        MyDate[] date = new MyDate[1000];
        int counter = 0;
        for (int i = 0; i < 1000; i++){
            int year = 1 + rand.nextInt(2022);
            int month = 1 + rand.nextInt(50);
            int day = 1 + rand.nextInt(50);
            date[i] = new MyDate(year,month,day);
            if(DateUtil.isValidDate(date[i].getYear(),date[i].getMonth(),date[i].getDay())){
                System.out.println(date[i].toString());
            }else{
                counter++;
            }
        }
        System.out.println("Counter for invalid dates: " + counter);
    }
}