package vershart.techtasks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public final class TestAutomationEngineerPage extends WebPage {

    private final By profSkillsAndQualificationList =
            By.xpath("//h1[text()='Test Automation Engineer']/following::em[text()='Professional skills and qualification:']/ancestor::p/following-sibling::ul");

    public TestAutomationEngineerPage(WebDriver driver, IErrorListener errorListener) {
        super(driver, errorListener);

        waitUntilTitleIs("Test Automation Engineer | C.T.Co People");
    }

    public int getProfSkillsAndQualificationsCount() {
        return waitUntilElementVisible(profSkillsAndQualificationList)
                .findElements(new By.ByTagName("li"))
                .size();
    }

}
