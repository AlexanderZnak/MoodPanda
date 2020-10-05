package steps;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import pages.LoginPage;
import pages.WorldFeedPage;

@Log4j2
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
        log.info(String.format("Login with email: %s, password: %s", email, password));
        return this;
    }

    @Step("Validate is the World Feed page opened")
    public LoginSteps validateIsPageOpened() {
        worldFeedPage.isPageOpened();
        log.info("Validate is the World Feed page opened");
        return this;
    }
}
