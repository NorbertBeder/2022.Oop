package lab11;

public class Student {
    private final int id;
    private final String firstName;
    private final String lastName;
    private double hungarian;
    private double romanian;
    private double math;
    private double average;


    public Student(int id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }

    public double getHungarian() {
        return hungarian;
    }

    public void setHungarian(double hungarian) {
        this.hungarian = hungarian;
    }

    public double getRomanian() {
        return romanian;
    }

    public void setRomanian(double romanian) {
        this.romanian = romanian;
    }

    public double getMath() {
        return math;
    }

    public void setMath(double math) {
        this.math = math;
    }

    public double getAverage() {
        return average;
    }

    public void setAverage(double average) {
        this.average = average;
    }
}
