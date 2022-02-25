package problem2;
import java.util.Random;

public class Lab2Main2 {
    public static void main(String[] args) {
        Rectangle[] rectangles = new Rectangle[10];
        Random rand = new Random();
        double maxArea = 0;
        for(int i = 0; i < 10; i++){
            double length = 1 + rand.nextInt(10);
            double width = 1 + rand.nextInt(10);
            rectangles[ i ] = new Rectangle(length, width);
            maxArea += rectangles[i].area();
            System.out.println("Length:" + rectangles[i].getLength() + "\nWidth:" + rectangles[i].getWidth() + "\nArea:" + rectangles[i].area() + "\nPerimeter:" + rectangles[i].perimeter() + "\n");
        }
        System.out.println("Max Area:" + maxArea);
    }
}
