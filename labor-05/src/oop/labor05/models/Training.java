package oop.labor05.models;

import problem3.MyDate;

import java.util.ArrayList;

public class Training {
    private final Course course;
    private final MyDate startDate;
    private final MyDate endDate;
    private final double pricePerStudent;
    private ArrayList<Student> enrolledStudents = new ArrayList<>();

    public Training(Course course, MyDate startDate, MyDate endDate, double pricePerStudent) {
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
