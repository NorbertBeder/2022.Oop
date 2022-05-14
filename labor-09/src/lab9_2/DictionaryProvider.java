package lab9_2;

public class DictionaryProvider {

    public static IDictionary createDictionary( DictionaryType dtype ){

        IDictionary dictionary = null;
        switch (dtype){
            case ARRAY_LIST -> dictionary = ArrayListDictionary.newInstance();
            case TREE_SET -> dictionary = TreeSetDictionary.newInstance();
            case HASH_SET -> dictionary = HashSetDictionary.newInstance();
        }
        return dictionary;
    }
}
