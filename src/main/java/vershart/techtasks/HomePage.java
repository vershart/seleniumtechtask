package vershart.techtasks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public final class HomePage extends WebPage {

    private final By linkToCareers = By.xpath("//li[@id='menu-item-127']/a");
    private final By linkToVacancies = By.xpath("//li[@id='menu-item-131']/a");

    public HomePage(WebDriver driver, IErrorListener errorListener) {
        super(driver, errorListener);

        waitUntilTitleIs("C.T.Co People");
    }

    public HomePage mouseOverCareers() {
        actionsBuilder
                .moveToElement(waitUntilElementVisible(linkToCareers))
                .build()
                .perform();

        return this;
    }

    public VacanciesPage navigateToVacancies() {
        actionsBuilder
                .moveToElement(waitUntilElementClickable(linkToVacancies))
                .click()
                .build()
                .perform();

        return new VacanciesPage(driver, get_errorListener());
    }
}