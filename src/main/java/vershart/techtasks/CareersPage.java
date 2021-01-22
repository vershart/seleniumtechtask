package vershart.techtasks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public final class CareersPage extends WebPage {

    private By linkToVacancies = By.xpath("//a[text()='Vacancies']");
    // //div[1]/div[2]/div[2]/div[1]/div[1]/a

    public CareersPage(WebDriver driver) {
        super(driver);
    }

    public VacanciesPage navigateToVacanciesPage() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(linkToVacancies))
                .click();
        return new VacanciesPage(driver);
    }

}