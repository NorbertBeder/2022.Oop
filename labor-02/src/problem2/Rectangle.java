package problem2;

public class Rectangle {
    private int length;
    private int width;
    public  Rectangle(){
        this.length = 5;
        this.width = 4;
    }
    public int area(){
        return length * width;
    }
    public int perimeter(){
        return 2 * (length + width);
    }
    public int getLength(){
        return this.length;
    }
    public int getWidth(){
        return this.width;
    }
}
