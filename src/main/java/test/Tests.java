package test;

import main.Runner;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;


public class Tests {

    Runner runner;

    @Before
    public void setup() {
        runner = new Runner();
    }

    @Test
    public void simpleRun() {
        runner.runner();
    }

    @Test
    public void onlyAlphaCharsShouldRemain() {
        String reggyString = "fef4356^':.,";
        Assert.assertEquals("fef", runner.regex(reggyString).get(0));
        System.out.println(runner.regex(reggyString).get(0));
    }

    @Test
        public void frequenctTest() {
        ArrayList<String> testWords = new ArrayList<String>();
        testWords.add("aaa");
        testWords.add("bbb");
        testWords.add("aaa");

        HashMap<String, Integer> testMap = Runner.hashCounter(testWords);
        int convertToInt = testMap.get("aaa");

        Assert.assertEquals(2, convertToInt);
    }

}
