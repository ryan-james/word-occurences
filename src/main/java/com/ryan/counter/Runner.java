package com.ryan.counter;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

//TODO Runner doesn't seem like the right name, perhaps UrlScraper or something would indicate more as to what it does?
public class Runner {

	// TODO Make a constant (note the variable is upper cased) as this value isn't going to change much, the resulting code is clearer
	private static final String USER_AGENT = "Mozilla/5.0 (Windows NT 6.3; rv:36.0) Gecko/20100101 Firefox/36.0";

	// TODO Base in a base url, much more flexible, also a more likely scenario that we'll want to hit different urls
	public void runner(String baseUrl) {

		JsoupProperties jsoupProperties = new JsoupProperties(baseUrl, USER_AGENT);

		Document doc;
		// TODO Minimize scope of try catch blocks where possible, no need to wrap anything. ALso don't just print out the error, try and log it (in this small project not the biggest issue)
		// TODO Also if the state is exceptional (hence the exception) and execution can't really continue (in this case we failed to get the data the rest of the system needs it's a good idea to
		// throw a runtime exception
		try {
			doc = Jsoup.connect(jsoupProperties.getScrapeUrl()).userAgent(jsoupProperties.getUserAgent()).get();
		} catch (IOException e) {
			throw new RuntimeException("Failed to connect and scrape url: " + jsoupProperties.getScrapeUrl(), e);
		}
		String docToString = doc.toString();
		// TODO No need for brackets around that method call,List is returned as opposed to ArrayList
		List<String> wordsOnPageList = regex(docToString);
		hashCounter(wordsOnPageList);

	}

	// TODO Try and veer away from using a direct implementation such as ArrayList, instead use a generic interface, for example if you have a method that accepts ArrayList then only that type can
	// ever be passed into the method
	// If you use an interface such as List (which ArrayList implements then you can pass in any type that also implements List). In English, it's more flexible to use List as opposed to concrete
	// implementation
	public List<String> regex(String fullPage) {
		// remove script tags and content between
		String removePageCode = fullPage.replaceAll("<script[^>]*>([^<]*)<\\/script>", "");
		// remove style tags and content between
		removePageCode = removePageCode.replaceAll("<style[^>]*>([^<]*)<\\/style>", "");
		removePageCode = removePageCode.replaceAll("<[^>]*>", "");
		// remove all non-alphanumeric chars
		removePageCode = removePageCode.replaceAll("(\\.)|(:)|(,)|(\\[)|(\\])|(\\-)|(\\^)|(&)|(;)|(=)|(\\?)|(/)|(\\()|(\\))|(\")|(_)", " ");
		// remove all numbers
		removePageCode = removePageCode.replaceAll("\\d+.*", "");
		removePageCode = removePageCode.replaceAll(" nbsp", "");

		// create array of all words by splitting on space
		String[] wordsOnPage = removePageCode.split("\\s+");
		// convert array to ArrayList
		// TODO You don't need to create a list as you had before, the below will do.
		return Arrays.asList(wordsOnPage);

	}

	// TODO Again use the Interface Map over the concrete implementation of HashMap
	public Map<String, Integer> hashCounter(List<String> words) {
		// unique words
		// TODO Same with set as opposted to HashSet
		Set<String> hash = new HashSet<String>(words);
		// hashmap for each unique word and it's frequency
		Map<String, Integer> hashCounts = new HashMap<String, Integer>();

		// for each word in the hash array
		for (String word : hash) {
			// add word to hash and it's frequency
			hashCounts.put(word, Collections.frequency(words, word));
		}

		System.out.println(hashCounts);
		System.out.println("Unique words: " + hash);
		System.out.println("Unique words count: " + hash.size());
		System.out.println("Original word count: " + words.size());

		return hashCounts;
	}

}
