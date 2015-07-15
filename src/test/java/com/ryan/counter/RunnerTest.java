package com.ryan.counter;

//TODO Add static import for assertions, looks neater below
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.ryan.counter.Runner;

//TODO Try for slightly more descriptive class name, also see that we are following java conventions by placing all tests withi a /src/test/java folder 
public class RunnerTest {

	Runner runner;

	@Before
	public void setup() {
		runner = new Runner();
	}

	@Test
	public void simpleRun() {
		runner.runner("https://en.wikipedia.org/wiki/John_Howard_(fighter)");
	}

	@Test
	public void onlyAlphaCharsShouldRemain() {
		String reggyString = "fef4356^':.,";
		assertEquals("fef", runner.regex(reggyString).get(0));
		System.out.println(runner.regex(reggyString).get(0));
	}

	@Test
	public void frequenctTest() {
		List<String> testWords = new ArrayList<String>();
		testWords.add("aaa");
		testWords.add("bbb");
		testWords.add("aaa");

		Map<String, Integer> testMap = runner.hashCounter(testWords);
		int convertToInt = testMap.get("aaa");

		assertEquals(2, convertToInt);
	}

}
