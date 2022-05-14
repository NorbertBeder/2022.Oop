package lab9_2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;

public class HashSetDictionary implements IDictionary{
    private final HashSet<String> words = new HashSet<>();
    private static HashSetDictionary instance = null;

    public HashSetDictionary() {
        try(Scanner scanner = new Scanner(new File(IDictionary.DICTIONARY_FILE))){
            while (scanner.hasNext()){
                String line = scanner.nextLine();
                if(line.isEmpty()){
                    continue;
                }
                words.add(line);
            }

        }catch (FileNotFoundException e){
            e.getStackTrace();
        }
    }

    public static IDictionary newInstance(){
        if(instance == null){
            instance = new HashSetDictionary();
        }
        return instance;
    }

    @Override
    public boolean add(String string) {
        return words.add(string);
    }

    @Override
    public boolean find(String string) {
        string = string.toLowerCase();
        return words.contains(string);
    }

    @Override
    public int size() {
        return words.size();
    }
}
