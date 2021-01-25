package vershart.techtasks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public final class VacanciesPage extends WebPage {

    private final By linkToTestAutomationEngineer = By.xpath("//li[@id='menu-item-3249']/a");

    public VacanciesPage(WebDriver driver, IErrorListener errorListener) {
        super(driver, errorListener);

        waitUntilTitleIs("Vacancies | C.T.Co People");
    }

    public TestAutomationEngineerPage navigateToTestAutomationEngineerVacancy() {
        actionsBuilder
                .moveToElement(waitUntilElementClickable(linkToTestAutomationEngineer))
                .click()
                .build()
                .perform();

        return new TestAutomationEngineerPage(driver, get_errorListener());
    }

}
