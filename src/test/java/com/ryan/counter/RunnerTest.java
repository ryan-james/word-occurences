package com.ryan.counter;

//TODO Add static import for assertions, looks neater below
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

//TODO Try for slightly more descriptive class name, also see that we are following java conventions by placing all tests withi a /src/test/java folder 
public class RunnerTest {

	Runner runner;

	@Before
	public void setup() {
		runner = new Runner();
	}

	@Test
	// TODO This test needs to assert something
	public void simpleRun() {
		// TODO this ought to be asserting the output from hashCounter (so .runner needs to return it, hashcounter ought to be private)
		Map<String, Integer> wordOccurences = runner.runner("https://en.wikipedia.org/wiki/John_Howard_(fighter)");

		// TODO Make the following work, when I do search via CHrome on the John Howard page it tells me I get 60 matches, this code prints out 37
		// assertEquals(60, wordOccurences.get("Howard").intValue());
	}

	@Test
	// TODO SLight name change
	public void shouldOnlyContainAlphaCharsAfterRegex() {
		// TODO We know it's a string
		String htmlInput = "fef4356^':.,";
		assertEquals("fef", runner.regex(htmlInput).get(0));

		// TODO DOn't print out stuff if you, your assertions ought to be the code to what is wrong or right
		// System.out.println(runner.regex(htmlInput).get(0));
	}

	@Test
	public void frequenctTest() {
		List<String> testWords = Arrays.asList("aaa", "bbb", "aaa");

		// TODO Don't use testMap, using what is being returned (word occurences) makes it easier to reason about
		Map<String, Integer> wordOccurences = runner.hashCounter(testWords);
		// TODO Rather than define that intermediate variable, just do the assertion straight below
		// int convertToInt = ;
		assertEquals(2, wordOccurences.get("aaa").intValue());
	}

}
