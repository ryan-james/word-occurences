package main;

/**
 * Created by RMULROONEY on 15/07/2015.
 */
public class JsoupProperties {

    private static String scrapeUrl;
    private static String ua;


    public static String getScrapeUrl() {
        return scrapeUrl;
    }

    public static void setScrapeUrl(String scrapeUrl) {
        JsoupProperties.scrapeUrl = scrapeUrl;
    }

    public static String getUa() {
        return ua;
    }

    public static void setUa(String ua) {
        JsoupProperties.ua = ua;
    }

}
