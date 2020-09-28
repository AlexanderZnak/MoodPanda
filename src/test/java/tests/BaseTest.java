package tests;

import com.codeborne.selenide.Configuration;
import org.testng.ITestContext;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import steps.LoginSteps;

@Listeners(TestListener.class)
public class BaseTest {
    public static final String EMAIL = "sasha_znak@mailinator.com";
    public static final String PASSWORD = "sashaznak";
    LoginSteps loginSteps;

    @BeforeMethod
    public void setUp(ITestContext context) {
        Configuration.browser = "chrome";
        Configuration.timeout = 10000;
        Configuration.clickViaJs = true;
        Configuration.startMaximized = true;
        loginSteps = new LoginSteps();
    }

}
