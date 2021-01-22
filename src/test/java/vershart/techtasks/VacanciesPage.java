package vershart.techtasks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public final class VacanciesPage extends WebPage {

    // //a[text()='Test Automation Engineer']
    private By linkToTestAutomationEngineer = By.xpath("//li[@id='menu-item-3249']/a");

    public VacanciesPage(WebDriver driver) {
        super(driver);
    }

    public TestAutomationEngineerPage navigateToTestAutomationEngineerVacancy() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(linkToTestAutomationEngineer))
                .click();
        return new TestAutomationEngineerPage(driver);
    }

}
