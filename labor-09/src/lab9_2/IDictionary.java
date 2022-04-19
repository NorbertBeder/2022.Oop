package lab9_2;

public interface IDictionary {
    public final static String DICTIONARY_FILE = "dictionary.txt";

    boolean add(String string);

    boolean find(String string);

    int size();
}
