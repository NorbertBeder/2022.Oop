package lab12_3;

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

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setHungarian(double hungarian) {
        this.hungarian = hungarian;
    }

    public void setRomanian(double romanian) {
        this.romanian = romanian;
    }

    public void setMath(double math) {
        this.math = math;
    }

    public double calculateAverage() {
        double average;
        if (this.math < 5 || this.romanian < 5 || this.hungarian < 5) {
            average = 0;
            this.average = average;
            return average;
        }
        average = (math + romanian + hungarian) / 3;
        this.average = average;
        return average;
    }

    public double getAverage() {
        return average;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", hungarian=" + hungarian +
                ", romanian=" + romanian +
                ", math=" + math +
                ", average=" + average +
                '}';
    }
}
