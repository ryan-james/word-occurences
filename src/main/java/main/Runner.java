package main;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.*;

public class Runner {

//    public static String scrapeUrl = "https://en.wikipedia.org/wiki/John_Howard_(fighter)";
//    public static String ua = "Mozilla/5.0 (Windows NT 6.3; rv:36.0) Gecko/20100101 Firefox/36.0";

    public void runner () {

        JsoupProperties.setScrapeUrl("https://en.wikipedia.org/wiki/John_Howard_(fighter)");
        JsoupProperties.setUa("Mozilla/5.0 (Windows NT 6.3; rv:36.0) Gecko/20100101 Firefox/36.0");

        try {
            Document doc = Jsoup.connect(JsoupProperties.getScrapeUrl()).userAgent(JsoupProperties.getUa()).get();
            String docToString = doc.toString();
            ArrayList<String> wordsOnPageList = (regex(docToString));
            hashCounter(wordsOnPageList);
        }
        catch (IOException ioe){
            System.out.println("Error using scrapeUrl. Message: " + ioe);
        }
    }

    public ArrayList<String> regex(String fullPage) {
        //remove script tags and content between
        String removePageCode = fullPage.replaceAll("<script[^>]*>([^<]*)<\\/script>", "");
        //remove style tags and content between
        removePageCode = removePageCode.replaceAll("<style[^>]*>([^<]*)<\\/style>", "");
        removePageCode = removePageCode.replaceAll("<[^>]*>", "");
        //remove all non-alphanumeric chars
        removePageCode = removePageCode.replaceAll("(\\.)|(:)|(,)|(\\[)|(\\])|(\\-)|(\\^)|(&)|(;)|(=)|(\\?)|(/)|(\\()|(\\))|(\")|(_)", " ");
        //remove all numbers
        removePageCode = removePageCode.replaceAll("\\d+.*", "");
        removePageCode = removePageCode.replaceAll(" nbsp", "");

        //create array of all words by splitting on space
        String[] wordsOnPage = removePageCode.split("\\s+");
        //convert array to ArrayList
        return new ArrayList<String>(Arrays.asList(wordsOnPage));

    }

    public static HashMap<String, Integer> hashCounter(ArrayList<String> words) {
        //unique words
        HashSet<String> hash = new HashSet<String>(words);
        //hashmap for each unique word and it's frequency
        HashMap<String, Integer> hashCounts = new HashMap<String, Integer>();

        //for each word in the hash array
        for(String word : hash) {
            //add word to hash and it's frequency
            hashCounts.put(word, Collections.frequency(words, word));
        }

        System.out.println(hashCounts);
        System.out.println("Unique words: " + hash);
        System.out.println("Unique words count: " + hash.size());
        System.out.println("Original word count: " + words.size());

        return hashCounts;
    }

}
