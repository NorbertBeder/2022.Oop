package lab9_2;

public class DictionaryProvider {

    public static IDictionary createDictionary( DictionaryType dtype ){

        IDictionary dictionary = null;
        if (dtype == DictionaryType.ARRAY_LIST) {
            dictionary = ArrayListDictionary.newInstance();
        }
        return dictionary;
    }
}
