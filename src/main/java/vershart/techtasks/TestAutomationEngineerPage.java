package vershart.techtasks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public final class TestAutomationEngineerPage extends WebPage {

    private final By profSkillsAndQualificationList =
            By.xpath("//h1[text()='Test Automation Engineer']/following::em[text()='Professional skills and qualification:']/ancestor::p/following-sibling::ul");
    private final WebElement list = wait
            .withMessage("Counting skills...")
            .until(ExpectedConditions.visibilityOfElementLocated(profSkillsAndQualificationList));

    public TestAutomationEngineerPage(WebDriver driver) {
        super(driver);
    }

    public int getProfSkillsAndQualificationsCount() {
        return list
                .findElements(new By.ByTagName("li"))
                .size();
    }

}
