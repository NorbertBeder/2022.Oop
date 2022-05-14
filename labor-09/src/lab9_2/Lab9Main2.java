package lab9_2;

import java.util.Scanner;

public class Lab9Main2 {
    public static void main(String[] args) {
//        DictionaryService service = new DictionaryService(DictionaryType.ARRAY_LIST);
//        Scanner scanner = new Scanner(System.in);
//        while( true ) {
//            System.out.print("Word to find ( Enter <end> for exit): ");
//            String word = scanner.nextLine();
//            if( word.equalsIgnoreCase( "end")){
//                break;
//            }
//            System.out.println(" Find(" + word + "): " + service.findWord(word));
//        }
//        scanner.close();
//
//
//        DictionaryService service1 = new DictionaryService(DictionaryType.ARRAY_LIST);
//        System.out.println("Unknown words from a file: ");
//        System.out.println( service1.findWordsFile( "text_to_find.txt"));

        long startTime, endTime, timeElapsed;

        startTime = System.nanoTime();
        DictionaryService service = new DictionaryService(DictionaryType.ARRAY_LIST);

        //System.out.println(service.findWordsFile("bible.txt"));
        service.findWordsFile("bible.txt");


        endTime = System.nanoTime();
        timeElapsed = endTime - startTime;

        System.out.println("Execution time for ArrayList in milliseconds: " + timeElapsed / 1000000);

        startTime = System.nanoTime();
        service = new DictionaryService(DictionaryType.TREE_SET);

        //System.out.println(service.findWordsFile("bible.txt"));
        service.findWordsFile("bible.txt");

        endTime = System.nanoTime();
        timeElapsed = endTime - startTime;

        System.out.println("Execution time for TreeSet in milliseconds: " + timeElapsed / 1000000);

        startTime = System.nanoTime();
        service = new DictionaryService(DictionaryType.HASH_SET);

        //System.out.println(service.findWordsFile("bible.txt"));
        service.findWordsFile("bible.txt");


        endTime = System.nanoTime();
        timeElapsed = endTime - startTime;

        System.out.println("Execution time for HashSet in milliseconds: " + timeElapsed / 1000000);
    }
}
