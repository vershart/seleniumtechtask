package vershart.techtasks;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class WebPage {

    protected WebDriver driver;
    protected WebDriverWait wait;
    protected Actions actionsBuilder;

    protected WebPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 3);
        actionsBuilder = new Actions(driver);
    }

}