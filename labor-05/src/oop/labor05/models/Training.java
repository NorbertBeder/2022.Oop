package oop.labor05.models;

import problem3.MyDate;

import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;

public class Training {
    private final Course course;
    private final MyDate startDate;
    private final MyDate endDate;
    private final int pricePerStudent;
    private final ArrayList<Student> enrolledStudents = new ArrayList<>();

    public Training(Course course, MyDate startDate, MyDate endDate, int pricePerStudent) {
        this.course = course;
        this.startDate = startDate;
        this.endDate = endDate;
        this.pricePerStudent = pricePerStudent;
    }
    public boolean enroll(Student student){
        if(findStudentByID(student.getID()) == null){
            enrolledStudents.add(student);
            return true;
        }
        return false;
    }

    public Student findStudentByID(String ID){
        for (Student student : enrolledStudents){
            if(student.getID().equals(ID)){
                return student;
            }
        }
        return null;
    }

    public Course getCourse() {
        return course;
    }


    public int numEnrolled(){
        return enrolledStudents.size();
    }

    public void printToFile() {
        String filename = String.format("%s_%s.%s.%s_%s.%s.%s.csv", course.getName() ,startDate.getYear(), startDate.getMonth() ,startDate.getDay() , endDate.getYear() ,endDate.getMonth() , endDate.getDay());
        try(PrintStream ps = new PrintStream(filename)){
            ps.println("Training\n\t" + course.toString() + "\n\t" + startDate.toString() + "\n\t" + endDate.toString());
            for(Student student : enrolledStudents){
                ps.println("\t\t" + student);
            }
        }catch (FileNotFoundException e){
            e.getStackTrace();
        }
    }

    @Override
    public String toString() {
        return "Training{" +
                "course=" + course +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", pricePerStudent=" + pricePerStudent +
                ", enrolledStudents=" + enrolledStudents +
                '}';
    }
}
