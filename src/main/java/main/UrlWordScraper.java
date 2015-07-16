package main;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.*;

public class UrlWordScraper {

    public static String scrapeUrl = "https://en.wikipedia.org/wiki/John_Howard_(fighter)";
    private static String USER_AGENT = "Mozilla/5.0 (Windows NT 6.3; rv:36.0) Gecko/20100101 Firefox/36.0";

    public Map<String, Integer> runner() {

        JsoupProperties jsoupProperties = new JsoupProperties(scrapeUrl, USER_AGENT);

        Document doc;

        try {
            doc = Jsoup.connect(jsoupProperties.getScrapeUrl()).userAgent(jsoupProperties.getUserAgent()).get();
        }
        catch (IOException ioe){
            throw new RuntimeException("Error using scrapeUrl " + jsoupProperties.getScrapeUrl() + ioe);
        }

        String docToString = doc.toString();
//        System.out.println(docToString);
        List<String> wordsOnPageList = (regexToProduceWordsOnly(docToString));

        return hashCounter(wordsOnPageList);
    }

    public List<String> regexToProduceWordsOnly(String fullPage) {
//        //remove script tags and content between
//        String removePageCode = fullPage.replaceAll("<script[^>]*>([^<]*)<\\/script>", "");
//        //remove style tags and content between
//        removePageCode = removePageCode.replaceAll("<style[^>]*>([^<]*)<\\/style>", "");
//        removePageCode = removePageCode.replaceAll("<[^>]*>", "");
//        //remove all non-alphanumeric chars
//        removePageCode = removePageCode.replaceAll("(\\.)|(:)|(,)|(\\[)|(\\])|(\\-)|(\\^)|(&)|(;)|(=)|(\\?)|(/)|(\\()|(\\))|(\")|(_)", " ");
//        //remove all numbers
//        removePageCode = removePageCode.replaceAll("\\d+.*", "");
//        removePageCode = removePageCode.replaceAll(" nbsp", "");


        //remove everything in between head tags
        String removePageCode = fullPage.replaceAll("<head[^>]*>([^<]*)<\\/head>", "");
        //remove everything in between script tags
        removePageCode = removePageCode.replaceAll("<script[^>]*>([^<]*)<\\/script>", "");
        //remove all tags and their contents
        removePageCode = removePageCode.replaceAll("<[^>]*>", "");
        //remove all gash characters
        removePageCode = removePageCode.replaceAll("[^a-zA-Z]", " ");

        //create array of all words by splitting on space
        String[] wordsOnPage = removePageCode.split("\\s+");
        //convert array to ArrayList
        return Arrays.asList(wordsOnPage);


    }

    public static Map<String, Integer> hashCounter(List<String> words) {
        //unique words
        Set<String> uniqueWords = new HashSet<String>(words);
        //hashmap for each unique word and it's frequency
        Map<String, Integer> wordFrequencies = new HashMap<String, Integer>();

        //for each word in the hash array
        for(String word : uniqueWords) {
            //add word to hash and it's frequency
            wordFrequencies.put(word, Collections.frequency(words, word));
        }

        System.out.println(wordFrequencies);
        System.out.println("Unique words: " + uniqueWords);
        System.out.println("Unique words count: " + uniqueWords.size());
        System.out.println("Original word count: " + words.size());

        return wordFrequencies;
    }

}
