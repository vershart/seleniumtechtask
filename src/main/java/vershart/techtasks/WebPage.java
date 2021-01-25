package vershart.techtasks;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public abstract class WebPage extends WebDriverWaitHelper {

    protected final WebDriver driver;
    protected final Actions actionsBuilder;

    public WebPage(WebDriver driver, IErrorListener errorListener) {
        super(driver, errorListener);

        this.driver = driver;
        this.actionsBuilder = new Actions(driver);
    }

}