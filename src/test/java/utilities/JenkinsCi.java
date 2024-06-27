package utilities;

public class JenkinsCi {
    private static final String SELENIUM_HUB_URL = "SELENIUM_HUB_URL";

    private JenkinsCi() {
    }

    public static String getSeleniumHubUrl() {
        String url = System.getProperty(SELENIUM_HUB_URL) == null ? System.getenv(SELENIUM_HUB_URL) : System.getProperty(SELENIUM_HUB_URL);
        url = url == null || url.isEmpty() ? null : url;
        return url;
    }
}
