package lab11_1;

public class Lab11Main1 {
    public static void main(String[] args) {
        int sum = 0;
        for(String arg: args){
            try {
                sum += Integer.parseInt(arg);
            }catch (NumberFormatException e){
                System.err.println(arg+" is not an integer");
            }
        }
        System.out.println("Sum : " + sum);
    }
}
