package vershart.techtasks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.support.ui.ExpectedConditions;

public final class HomePage extends WebPage {

    private By linkToCareers = By.xpath("//li[@id='menu-item-127']/a");
    private By linkToVacancies = By.xpath("//li[@id='menu-item-131']/a");
    private By linkToTestAutomationEngineer = By.xpath("//li[@id='menu-item-3249']/a");

    public HomePage(WebDriver driver, String rootUrl) {
        super(driver);
        driver.get(rootUrl);
    }

    public void mouseOverCareers() {
        actionsBuilder
                .moveToElement(driver.findElement(linkToCareers))
                .build()
                .perform();
    }

    public VacanciesPage mouseOverVacancies() {
        actionsBuilder
                .moveToElement(driver.findElement(linkToVacancies))
                .click()
                .build()
                .perform();

        wait.until(ExpectedConditions.visibilityOfElementLocated(linkToTestAutomationEngineer));
        return new VacanciesPage(driver);
    }

}