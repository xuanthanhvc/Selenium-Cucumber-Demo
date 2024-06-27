package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class GoogleHomePage {

    private WebDriver driver;

    public GoogleHomePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "[name=q]")
    public WebElement inputTextArea;

    @FindBy(css = ".FPdoLc [name=btnK]")
    public WebElement searchButton;

    @FindBy(css = "a [jsname=bVqjv]")
    public WebElement searchResultsTab;

}
