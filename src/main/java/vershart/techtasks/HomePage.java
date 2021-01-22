package vershart.techtasks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public final class HomePage extends WebPage {

    private static final By linkToCareers = By.xpath("//li[@id='menu-item-127']/a");
    private final By linkToVacancies = By.xpath("//li[@id='menu-item-131']/a");

    private HomePage(WebDriver driver) {
        super(driver);
    }

    public static Either<HomePage, Exception> getInstance(WebDriver driver, String rootUrl) {
        driver.get(rootUrl);
        HomePage homePage = new HomePage(driver);
        try {
            new WebDriverWait(driver, 3)
                    .withMessage(String.format("Waiting for page to load by founding element %s", linkToCareers.toString()))
                    .until(ExpectedConditions.visibilityOfElementLocated(linkToCareers));
            return Either.left(homePage);
        } catch (Exception ex) {
            return Either.right(ex);
        }
    }

    public Either<WebElement, Exception> mouseOverCareers() {
        actionsBuilder
                .moveToElement(driver.findElement(linkToCareers))
                .build()
                .perform();

        try {
            return Either.left(wait
                    .withMessage("Waiting for link to Vacancies to appear")
                    .until(ExpectedConditions.visibilityOfElementLocated(linkToVacancies)));
        } catch (Exception ex) {
            return Either.right(ex);
        }
    }

    public Either<VacanciesPage, Exception> navigateToVacancies() {
        actionsBuilder
                .moveToElement(driver.findElement(linkToVacancies))
                .click()
                .build()
                .perform();

        return VacanciesPage.getInstance(driver);
    }
}