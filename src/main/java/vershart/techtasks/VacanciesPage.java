package vershart.techtasks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public final class VacanciesPage extends WebPage {

    // //a[text()='Test Automation Engineer']
    private final By linkToTestAutomationEngineer = By.xpath("//li[@id='menu-item-3249']/a");
    private final WebElement link = wait
            .withMessage("Waiting for link to Test Automation Engineer to appear")
            .until(ExpectedConditions.visibilityOfElementLocated(linkToTestAutomationEngineer));

    public VacanciesPage(WebDriver driver) {
        super(driver);
    }

    public TestAutomationEngineerPage navigateToTestAutomationEngineerVacancy() {
        link.click();
        return new TestAutomationEngineerPage(driver);
    }

}
