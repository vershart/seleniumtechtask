package vershart.techtasks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public final class VacanciesPage extends WebPage {

    private static final By linkToTestAutomationEngineer = By.xpath("//li[@id='menu-item-3249']/a");

    private VacanciesPage(WebDriver driver) {
        super(driver);
    }

    public Either<TestAutomationEngineerPage, Exception> navigateToTestAutomationEngineerVacancy() {
        actionsBuilder
                .moveToElement(driver.findElement(linkToTestAutomationEngineer))
                .click()
                .build()
                .perform();
        return TestAutomationEngineerPage.getInstance(driver);
    }

    public static Either<VacanciesPage, Exception> getInstance(WebDriver driver) {
        VacanciesPage vacanciesPage = new VacanciesPage(driver);
        try {
            new WebDriverWait(driver, 3)
                    .withMessage(String.format("Waiting for page to load by founding element %s", linkToTestAutomationEngineer.toString()))
                    .until(ExpectedConditions.visibilityOfElementLocated(linkToTestAutomationEngineer));
            return Either.left(vacanciesPage);
        } catch (Exception ex) {
            return Either.right(ex);
        }
    }
}
