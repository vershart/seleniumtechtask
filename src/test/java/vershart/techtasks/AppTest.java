package vershart.techtasks;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AppTest 
{

    private final String rootUrl = "https://ctco.lv/";
    private final int profSkillsAndQualificationsCount = 5;

    @Test
    public void testCtcoDotLv() throws InterruptedException {

        // Assuming chromedriver is installed and available in PATH environment variable
        // System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Selenium\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        HomePage homePage = new HomePage(driver, rootUrl);
        TestAutomationEngineerPage page = homePage
                .navigateToCareersPage()
                .navigateToVacanciesPage()
                .navigateToTestAutomationEngineerVacancy();

        Assert.assertTrue(page.getProfSkillsAndQualificationsCount() == profSkillsAndQualificationsCount);
        driver.close();

    }
}