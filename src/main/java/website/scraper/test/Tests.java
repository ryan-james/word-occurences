package website.scraper.test;

import website.scraper.UrlWordScraper;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Map;


public class Tests {

    UrlWordScraper urlWordScraper;

    @Before
    public void setup() {
        urlWordScraper = new UrlWordScraper();
    }

    @Test
    public void shouldOnlyContainAlphaCharsAfterRegex() {
        String htmlInput = "fef4356^':.,";
        assertEquals("fef", urlWordScraper.regexToProduceWordsOnly(htmlInput).get(0));
    }

    @Test
        public void frequencyTest() {
        ArrayList<String> testWords = new ArrayList<String>();
        testWords.add("aaa");
        testWords.add("bbb");
        testWords.add("aaa");

        Map<String, Integer> wordOccurences = UrlWordScraper.hashCounter(testWords);
        assertEquals(2, wordOccurences.get("aaa").intValue());
    }

    @Test
    public void runFullTestToFindASpecificWordFromPage() {
        Map<String, Integer> uniqueWordsFromUrl = urlWordScraper.runner();
        assertEquals(60, uniqueWordsFromUrl.get("howard").intValue());
    }

}
