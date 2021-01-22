package vershart.techtasks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public final class HomePage extends WebPage {
    private By linkToCareers = By.xpath("//li[@id='menu-item-127']/a");

    public HomePage(WebDriver driver, String rootUrl) {
        super(driver);
        driver.get(rootUrl);
    }

    public CareersPage navigateToCareersPage() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(linkToCareers))
                .click();
        return new CareersPage(driver);
    }

}