package vershart.techtasks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public final class HomePage extends WebPage {

    private final By linkToCareers = By.xpath("//li[@id='menu-item-127']/a");
    private final By linkToVacancies = By.xpath("//li[@id='menu-item-131']/a");

    public HomePage(WebDriver driver, String rootUrl) {
        super(driver);
        driver.get(rootUrl);
        wait
                .withMessage("Waiting for link to Careers to appear")
                .until(ExpectedConditions.visibilityOfElementLocated(linkToCareers));

    }

    public void mouseOverCareers() {
        actionsBuilder
                .moveToElement(driver.findElement(linkToCareers))
                .build()
                .perform();
        wait
                .withMessage("Waiting for link to Vacancies to appear")
                .until(ExpectedConditions.visibilityOfElementLocated(linkToVacancies));
    }

    public VacanciesPage mouseOverVacancies() {
        actionsBuilder
                .moveToElement(driver.findElement(linkToVacancies))
                .click()
                .build()
                .perform();

        return new VacanciesPage(driver);
    }

}