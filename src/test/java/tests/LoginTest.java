package tests;

import io.qameta.allure.Description;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test(description = "Success login", retryAnalyzer = Retry.class)
    @Description("Validation of correct working the login with the valid data")
    public void worldFeedPageShouldBeOpenedAfterLogIn() {
        loginSteps
                .logIn(EMAIL, PASSWORD)
                .validateIsPageOpened();
    }

}
