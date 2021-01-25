package vershart.techtasks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverWaitHelper {

    private final IErrorListener _errorListener;
    private final WebDriverWait _wait;

    protected IErrorListener get_errorListener() {
        return _errorListener;
    }

    public WebDriverWaitHelper(WebDriver driver, IErrorListener errorListener) {
        if (errorListener == null) {
            throw new IllegalArgumentException("No error listener provided");
        }

        _errorListener = errorListener;
        _wait = new WebDriverWait(driver, 3);
    }

    private void onFailure(Exception ex) {
        _errorListener.invoke(new ExpectedConditionFailedException(ex.getMessage()));
    }

    protected WebElement waitForElement(ExpectedCondition<WebElement> condition) {
        WebElement webElement = null;
        try {
            webElement = _wait
                    .withMessage(String.format("Waiting for condition: %s", condition.toString()))
                    .until(condition);
        } catch (Exception ex) {
            onFailure(ex);
        }

        return webElement;
    }

    protected void waitUntil(ExpectedCondition<Boolean> condition) {
        try {
            _wait
                    .withMessage(String.format("Waiting for condition: %s", condition.toString()))
                    .until(condition);
        } catch (Exception ex) {
            onFailure(ex);
        }
    }

    protected WebElement waitUntilElementVisible(By by) {
        return waitForElement(ExpectedConditions.visibilityOfElementLocated(by));
    }

    protected void waitUntilElementNotVisible(By by) {
        waitUntil(ExpectedConditions.not(ExpectedConditions.visibilityOfElementLocated(by)));
    }

    protected WebElement waitUntilElementClickable(By by) {
        return waitForElement(ExpectedConditions.elementToBeClickable(by));
    }

    protected void waitUntilTitleIs(String title) {
        waitUntil(ExpectedConditions.titleIs(title));
    }


}
