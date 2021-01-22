package vershart.techtasks;

import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.TimeoutException;

public class AppTest extends BaseTest {


    @Test
    public void testCtcoDotLv() {

        int profSkillsAndQualificationsCount = 0;
        int profSkillsAndQualificationsCountExpected = 5;

        try {
            String rootUrl = "https://ctco.lv/";
            HomePage homePage = new HomePage(driver, rootUrl);
            homePage.mouseOverCareers();
            profSkillsAndQualificationsCount = homePage
                    .mouseOverVacancies()
                    .navigateToTestAutomationEngineerVacancy()
                    .getProfSkillsAndQualificationsCount();
        } catch (TimeoutException exception) {
            Assert.fail(exception.getMessage());
        }

        Assert.assertEquals(profSkillsAndQualificationsCount, profSkillsAndQualificationsCountExpected);

    }

    @After
    public void closeDriver() {
        if (driver != null) driver.close();
    }

}