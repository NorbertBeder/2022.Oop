package lab9_2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class ArrayListDictionary implements IDictionary{

    private final ArrayList<String> words = new ArrayList<>();
    private static ArrayListDictionary instance = null;

    private ArrayListDictionary(){
        try(Scanner scanner = new Scanner(new File(IDictionary.DICTIONARY_FILE))){
            while (scanner.hasNextLine()){
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
            instance = new ArrayListDictionary();
        }
        return instance;
    }

    @Override
    public boolean add(String word) {
        int index = (Collections.binarySearch(words, word) + 1) * -1;
        if(index >= 0) {
            words.add(index, word);
            return true;
        }
        return false;

    }

    @Override
    public boolean find(String word) {
        word = word.toLowerCase();
        return Collections.binarySearch(words, word) >= 0;
    }

    @Override
    public int size() {
        return words.size();
    }
}
