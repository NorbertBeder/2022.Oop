package lab10_3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Storage{
    private final ArrayList<Product> storage = new ArrayList<>();

    public Storage(String fileName) {
        try (Scanner scanner = new Scanner(new File(fileName))){
            while (scanner.hasNextLine()){
                String line = scanner.nextLine();
                if(line.isEmpty()){
                    continue;
                }
                String[] items = line.split(" ");
                int id = Integer.parseInt(items[0].trim());
                String name = items[1].trim();
                int amount = Integer.parseInt(items[2].trim());
                int price = Integer.parseInt(items[3].trim());
                storage.add(new Product(id,name,amount,price));
            }
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }
    }

    public Product search(int id){
        for (Product product : storage){
            if(product.getID() == id){
                return product;
            }
        }
        return null;
    }

    public void update(String fileName){
        int counter = 0;
        try (Scanner scanner = new Scanner(new File(fileName))){
            while (scanner.hasNextLine()){
                String line = scanner.nextLine();
                if(line.isEmpty()){
                    continue;
                }
                String[] items = line.split(" ");
                int id = Integer.parseInt(items[0].trim());
                int newAmount = Integer.parseInt(items[1].trim());
                for (Product product : storage){
                    if(product.getID() == id){
                        product.increaseAmount(newAmount);
                        counter++;
                    }
                }
            }
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }
        System.out.println("Updated products:" + counter);
    }
    @Override
    public String toString() {
        return "Storage{" +
                "storage=" + storage +
                '}';
    }
}