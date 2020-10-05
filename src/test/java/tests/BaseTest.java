package tests;

import com.codeborne.selenide.Configuration;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import steps.LoginSteps;
import steps.UpdateMoodModalSteps;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

@Listeners(TestListener.class)
public class BaseTest {
    public static final String EMAIL = "sasha_znak@mailinator.com";
    public static final String PASSWORD = "sashaznak";
    LoginSteps loginSteps;
    UpdateMoodModalSteps updateMoodModalSteps;

    @BeforeMethod
    public void setUp(ITestContext context) {
        Configuration.browser = "chrome";
        Configuration.timeout = 15000;
        Configuration.clickViaJs = true;
        Configuration.startMaximized = true;
//        Configuration.headless = true; //#configuration to run tests without browser
        loginSteps = new LoginSteps();
        updateMoodModalSteps = new UpdateMoodModalSteps();
    }

    @AfterMethod(alwaysRun = true)
    public void closeBrowser() {
        getWebDriver().quit();
    }

}
