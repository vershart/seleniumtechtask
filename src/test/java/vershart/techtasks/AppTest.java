package vershart.techtasks;

import org.junit.After;
import org.junit.Assert;
import org.junit.Test;

public class AppTest extends BaseTest {

    private void onTestFailed(ExpectedConditionFailedException ex) {
        Assert.fail(ex.getMessage());
    }

    @Test
    public void testCtcoDotLv() {

        int profSkillsAndQualificationsCount;
        final int profSkillsAndQualificationsCountExpected = 5;
        final String rootUrl = "https://ctco.lv/";

        driver.get(rootUrl);

        profSkillsAndQualificationsCount = new HomePage(driver, this::onTestFailed)
                .mouseOverCareers()
                .navigateToVacancies()
                .navigateToTestAutomationEngineerVacancy()
                .getProfSkillsAndQualificationsCount();

        Assert.assertEquals(profSkillsAndQualificationsCount, profSkillsAndQualificationsCountExpected);

    }

    @After
    public void closeDriver() {
        if (driver != null) {
            driver.close();
        }
    }

}