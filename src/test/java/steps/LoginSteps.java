package steps;

import io.qameta.allure.Step;
import pages.LoginPage;
import pages.WorldFeedPage;

public class LoginSteps {
    LoginPage loginPage;
    WorldFeedPage worldFeedPage;

    public LoginSteps() {
        loginPage = new LoginPage();
        worldFeedPage = new WorldFeedPage();
    }

    @Step("Login with email: '{email}', password: '{password}'")
    public LoginSteps logIn(String email, String password) {
        loginPage
                .openPage()
                .fillInEmailAndPasswordFields(email, password)
                .clickLogin();
        return this;
    }

    @Step("Validate is the World Feed page opened")
    public LoginSteps validateIsPageOpened() {
        worldFeedPage.isPageOpened();
        return this;
    }
}
