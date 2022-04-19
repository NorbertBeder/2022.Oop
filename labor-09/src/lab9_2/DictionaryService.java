package lab9_2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class DictionaryService {

    private final IDictionary dictionary;

    public DictionaryService(DictionaryType type) {
        this.dictionary = DictionaryProvider.createDictionary(type);
    }

    public boolean findWord(String word){
        return dictionary.find(word);
    }

    public ArrayList<String> findWordsFile(String fileName){
        ArrayList<String> nonValidWords = new ArrayList<>();
        try(Scanner sc = new Scanner(new File(fileName))){
            while(sc.hasNext()){
                String word = sc.next().trim();
                if(word.isEmpty()){
                    continue;
                }
                if(!dictionary.find(word)){
                    nonValidWords.add(word);
                }
            }
            return nonValidWords;
        }
        catch (FileNotFoundException e){
            e.printStackTrace();
        }
        return null;
    }
}
