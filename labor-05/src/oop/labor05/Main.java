package oop.labor05;

import oop.labor05.models.Course;
import oop.labor05.models.Student;
import oop.labor05.models.Training;
import problem3.MyDate;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<Course> courses = readCourses("courses.csv");
        ArrayList<Student> students = readStudents("students.csv");
        ArrayList<Training> trainings = new ArrayList<>();
        Random random = new Random();
        MyDate startDate = new MyDate(2022,3,21);
        MyDate endDate = new MyDate(2022,3,25);
        for (int i = 0; i < courses.size(); i++){
            int price = 1000 + random.nextInt(999);
                trainings.add(new Training(courses.get(i),startDate,endDate,price));
                while(trainings.get(i).numEnrolled() < 10){
                    if(trainings.get(i).enroll(students.get(random.nextInt(students.size())))){
                        trainings.get(i).printToFile();
                    }
                }
        }
        for(Student student : students){
            System.out.println(student.getFirstName() + " " + student.getLastName());
            for (Training training : trainings) {
                if (training.findStudentByID(student.getID()) != null) {
                    System.out.println("\t" + training.getCourse().getName() + ", " + training.getCourse().getDescription() + "\n");
                }
            }
        }


    }

    private static ArrayList<Course> readCourses(String fileName){
        ArrayList<Course> course = new ArrayList<>();
        try(Scanner scanner = new Scanner(new File(fileName))){
            while(scanner.hasNextLine()){
                String line = scanner.nextLine();
                if(line.isEmpty()){
                    continue;
                }
                String[] data = line.split(",");
                String name = data[0].trim();
                String description = data[1].trim();
                int numOfHours = Integer.parseInt(data[2].trim());
                course.add(new Course(name,description,numOfHours));
            }
        }
        catch (FileNotFoundException e){
            e.printStackTrace();
        }
        return course;
    }

    private static ArrayList<Student> readStudents(String fileName){
        ArrayList<Student> student = new ArrayList<>();
        try(Scanner scanner = new Scanner(new File(fileName))){
            while(scanner.hasNextLine()){
                String line = scanner.nextLine();
                if(line.isEmpty()){
                    continue;
                }
                String[] data = line.split(",");
                String ID = data[0].trim();
                String firstName = data[1].trim();
                String lastName = data[2].trim();
                student.add(new Student(ID,firstName,lastName));
            }
        }
        catch (FileNotFoundException e){
            e.printStackTrace();
        }
        return student;
    }
}
