package step_definitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import utilities.Driver;
import utilities.DriverFactory;
import utilities.PropertiesUtils;

import java.time.Duration;

public class Hooks {

    @Before
    public void setUp() {
        Driver.setDriver(DriverFactory.getDriver(PropertiesUtils.getBrowserType()));
        Driver.getDriverInstance().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @After
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()){
            embedFinalScreenShot(scenario);
        }
        Driver.quitDriver();
    }

    private void embedFinalScreenShot(Scenario scenario) {
        if (Driver.getDriverInstance() != null) {
            WebDriver driver = Driver.getDriverInstance();
            final byte[] finalScreenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(finalScreenshot, "image/png", "[Screenshot][After Scenario] " + scenario.getName());
        }
    }

}
