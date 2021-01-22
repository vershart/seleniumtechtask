package vershart.techtasks;

import org.junit.Test;
import org.junit.After;
import org.junit.Assert;

public class AppTest extends BaseTest
{

    private final String rootUrl = "https://ctco.lv/";
    private final int profSkillsAndQualificationsCount = 5;


    @Test
    public void testCtcoDotLv() {

        HomePage homePage = new HomePage(driver, rootUrl);
        TestAutomationEngineerPage page = homePage
                .navigateToCareersPage()
                .navigateToVacanciesPage()
                .navigateToTestAutomationEngineerVacancy();

        Assert.assertEquals(page.getProfSkillsAndQualificationsCount(), profSkillsAndQualificationsCount);

    }

    @After
    public void closeDriver() {
        if (driver != null) driver.close();
    }

}