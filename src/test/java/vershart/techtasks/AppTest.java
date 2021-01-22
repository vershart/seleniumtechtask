package vershart.techtasks;

import org.junit.After;
import org.junit.Assert;
import org.junit.Test;

public class AppTest extends BaseTest {

    @Test
    public void testCtcoDotLv() {

        int profSkillsAndQualificationsCount;
        final int profSkillsAndQualificationsCountExpected = 5;
        final String rootUrl = "https://ctco.lv/";

        HomePage homePage = HomePage.getInstance(driver, rootUrl)
                .map(
                        (left) -> left,
                        (right) -> {
                            Assert.fail(right.getMessage());
                            return null;
                        });

        homePage.mouseOverCareers()
                .mapRight(
                        (right) -> {
                            Assert.fail(right.getMessage());
                            return right;
                        });

        VacanciesPage vacanciesPage = homePage.navigateToVacancies()
                .map(
                        (left) -> left,
                        (right) -> {
                            Assert.fail(right.getMessage());
                            return null;
                        });

        TestAutomationEngineerPage testAutomationEngineerPage = vacanciesPage.navigateToTestAutomationEngineerVacancy()
                .map(
                        (left) -> left,
                        (right) -> {
                            Assert.fail(right.getMessage());
                            return null;
                        });

        profSkillsAndQualificationsCount = testAutomationEngineerPage.getProfSkillsAndQualificationsCount()
                .map(
                        (left) -> left,
                        (right) -> {
                            Assert.fail(right.getMessage());
                            return 0;
                        }
                );

        Assert.assertEquals(profSkillsAndQualificationsCount, profSkillsAndQualificationsCountExpected);


    }

    @After
    public void closeDriver() {
        if (driver != null) driver.close();
    }

}