package main;

/**
 * Created by RMULROONEY on 15/07/2015.
 */
public class JsoupProperties {

    private final String scrapeUrl;
    private final String userAgent;

    public JsoupProperties(String scrapeUrl, String userAgent) {
        this.scrapeUrl = scrapeUrl;
        this.userAgent = userAgent;
    }

    public String getScrapeUrl() {
        return scrapeUrl;
    }

    public String getUserAgent() {
        return userAgent;
    }


//    public static void setScrapeUrl(String scrapeUrl) {
//        JsoupProperties.scrapeUrl = scrapeUrl;
//    }
//
//    public static void setUserAgent(String userAgent) {
//        JsoupProperties.userAgent = userAgent;
//    }

}
