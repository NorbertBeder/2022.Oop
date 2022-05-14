package lab12_2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Storage {
    Map<Integer,Product> storage = new HashMap<>();

    public Storage(String fileName) {
        try (Scanner scanner = new Scanner(new File(fileName))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (line.isEmpty()) {
                    continue;
                }
                String[] items = line.split(" ");
                int id = Integer.parseInt(items[0].trim());
                String name = items[1].trim();
                int amount = Integer.parseInt(items[2].trim());
                int price = Integer.parseInt(items[3].trim());
                storage.put(id,new Product(id,name,amount,price));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void update(String fileName) {
        int counter = 0;
        try (Scanner scanner = new Scanner(new File(fileName))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (line.isEmpty()) {
                    continue;
                }
                String[] items = line.split(" ");
                int id = Integer.parseInt(items[0].trim());
                int newAmount = Integer.parseInt(items[1].trim());

                if(storage.get(id) != null){
                    storage.get(id).increaseAmount(newAmount);
                    counter++;
                }
            }
            System.out.println("Updated products: " + counter);
        }catch (FileNotFoundException e){
            e.getStackTrace();
        }
    }

    @Override
    public String toString() {
        return "Storage{" +
                "storage=" + storage +
                '}';
    }
}
