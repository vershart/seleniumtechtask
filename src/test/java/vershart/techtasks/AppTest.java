package vershart.techtasks;

import org.junit.After;
import org.junit.Assert;
import org.junit.Test;

public class AppTest extends BaseTest {

    private final String rootUrl = "https://ctco.lv/";
    private final int profSkillsAndQualificationsCountExpected = 5;


    @Test
    public void testCtcoDotLv() {

        HomePage homePage = new HomePage(driver, rootUrl);
        homePage.mouseOverCareers();
        int profSkillsAndQualificationsCount = homePage
                .mouseOverVacancies()
                .navigateToTestAutomationEngineerVacancy()
                .getProfSkillsAndQualificationsCount();


        Assert.assertEquals(profSkillsAndQualificationsCount, profSkillsAndQualificationsCountExpected);

    }

    @After
    public void closeDriver() {
        if (driver != null) driver.close();
    }

}