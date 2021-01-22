package vershart.techtasks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public final class TestAutomationEngineerPage extends WebPage {

    private static final By profSkillsAndQualificationList =
            By.xpath("//h1[text()='Test Automation Engineer']/following::em[text()='Professional skills and qualification:']/ancestor::p/following-sibling::ul");


    private TestAutomationEngineerPage(WebDriver driver) {
        super(driver);
    }

    public static Either<TestAutomationEngineerPage, Exception> getInstance(WebDriver driver) {
        TestAutomationEngineerPage testAutomationEngineerPage = new TestAutomationEngineerPage(driver);
        try {
            new WebDriverWait(driver, 3)
                    .withMessage(String.format("Waiting for page to load by founding element %s", profSkillsAndQualificationList))
                    .until(ExpectedConditions.visibilityOfElementLocated(profSkillsAndQualificationList));
            return Either.left(testAutomationEngineerPage);
        } catch (Exception ex) {
            return Either.right(ex);
        }
    }

    public Either<Integer, Exception> getProfSkillsAndQualificationsCount() {
        try {
            WebElement list = wait
                    .withMessage("Counting skills...")
                    .until(ExpectedConditions.visibilityOfElementLocated(profSkillsAndQualificationList));
            return Either.left(list
                    .findElements(new By.ByTagName("li"))
                    .size());
        } catch (Exception ex) {
            return Either.right(ex);
        }

    }

}
