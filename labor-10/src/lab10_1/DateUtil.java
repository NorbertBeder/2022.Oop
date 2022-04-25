package lab10_1;

public class DateUtil {
    public static boolean leapYear(int year){
        if (year % 400 == 0) {
            return true;
        }
        else if (year % 100 == 0) {
            return false;
        }
        else return year % 4 == 0;
    }
    public static boolean isValidDate(int year, int month, int day) {
        if(year <= 0 || year >= 2023){
            return false;
        }
        if(month <= 0 || month >= 13){
            return false;
        }
        if(day <= 0 || day >= 32){
            return false;
        }
        if (month == 2 && day > 29) {
            return false;
        }
        if (!leapYear(year) && month == 2 && day == 29) {
            return false;
        }
        if ((month == 4 || month == 6 || month == 9 || month == 11) && day == 31) {
            return false;
        }
        return true;
    }
}
