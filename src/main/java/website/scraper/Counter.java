package website.scraper;

import java.util.*;

/**
 * Created by RMULROONEY on 14/07/2015.
 */
public class Counter {

    public static void hashCounter(ArrayList<String> words) {
        HashSet<String> hash = new HashSet<String>(words);

        for(String word : hash) {
            System.out.println(word + ": " + Collections.frequency(words, word));
        }

        System.out.println("Unique words: \n" + hash);
        System.out.println("Unique words count: " + hash.size());
        System.out.println("Original word count: " + words.size());

    }

}
