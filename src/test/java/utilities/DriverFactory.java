package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.net.MalformedURLException;
import java.net.URI;

public class DriverFactory {

    /**
     * The method takes a string as @param
     * It will decide what type of driver to create
     * @return WebDriver
     * */
    public static WebDriver getDriver(String browserType)  {
        if (JenkinsCi.getSeleniumHubUrl() != null) {
            try {
                ChromeOptions options = new ChromeOptions();
                return new RemoteWebDriver(URI.create(JenkinsCi.getSeleniumHubUrl()).toURL(), options);
            } catch (MalformedURLException e) {
                // TODO Handle exception here
                return null;
            }

        } else {
            switch (browserType.toUpperCase()) {
                case "FIREFOX":
                    return new FirefoxDriver();
                case "SAFARI":
                    return new SafariDriver();
                case "EDGE":
                    return new EdgeDriver();
                default:
                    return new ChromeDriver();
            }
        }
    }

}
