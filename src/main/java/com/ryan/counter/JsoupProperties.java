package com.ryan.counter;

/**
 * Created by RMULROONEY on 15/07/2015.
 */
// TODO Remove above comment
public class JsoupProperties {

	// TODO Using static is a bad idea in general, it circumvents OO design
	// TODO Read this link to understand final in Java https://en.wikipedia.org/wiki/Final_(Java)#Final_variables
	private final String scrapeUrl;
	private final String userAgent;

	// TODO Use a constructor as opposed to setting fields after, we want it in one known state and immutable.
	// TODO Guessing that ua means UserAgent, never use acronyms for variables, it adds a layer of complexity and a whole load of ??? for other developers or yourself in 2 months
	public JsoupProperties(String scrapeUrl, String userAgent) {
		this.scrapeUrl = scrapeUrl;
		this.userAgent = userAgent;
	}

	public String getScrapeUrl() {
		return scrapeUrl;
	}

	// TODO The correct way to set a field on an object as opposed to statically, I've left this in so you can see how to do it.
	/*
	 * public void setScrapeUrl(String scrapeUrl) { this.scrapeUrl = scrapeUrl; }
	 */

	public String getUserAgent() {
		return userAgent;
	}

}
