package lab7_1;

import problem3.MyDate;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;

public class Document {
    private int id = 1;
    private String name;
    private MyDate date;
    private final StringBuffer content = new StringBuffer();

    public Document(String name, MyDate date) {
        this.name = name;
        this.date = date;
    }

    public int getId() {
        return id++;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public MyDate getDate() {
        return date;
    }

    public String getContent() {
        return content.toString();
    }

    public void appends(String line){
        content.append(line).append("\n");
    }

    private void printDocument(PrintStream ps){
        ps.print(getName() + "\n" + getDate() + " \n" + content);
    }

    public void printToSTDOutput(){
        printDocument(System.out);
    }

    public void printToFile(String fileName){
        try{
            printDocument(new PrintStream(fileName));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public int lineNum(StringBuffer content){
        String tempContent = content.toString();
        return tempContent.split("[\r\n]").length;
    }

    private boolean empty(StringBuffer content){
        String tempContent = content.toString();
        if(tempContent.isEmpty()){
            return true;
        }else{
            return false;
        }
    }

    public Document(String name, MyDate date, String fileName) {
        try(Scanner scanner = new Scanner(new File(fileName))){
            this.name = scanner.nextLine();
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return "Document{" +
                "id= " + id +
                ", name= '" + name + '\'' +
                ", date= " + date +
                ", sorok szama = " + lineNum(content) +
                '}';
    }
}
