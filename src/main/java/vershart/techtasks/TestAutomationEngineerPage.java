package vershart.techtasks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public final class TestAutomationEngineerPage extends WebPage {

    private By profSkillsAndQualificationList =
            By.xpath("//h1[text()='Test Automation Engineer']/following::em[text()='Professional skills and qualification:']/ancestor::p/following-sibling::ul");

    public TestAutomationEngineerPage(WebDriver driver) {
        super(driver);
    }

    public int getProfSkillsAndQualificationsCount() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(profSkillsAndQualificationList))
                .findElements(new By.ByTagName("li"))
                .size();
    }

}
