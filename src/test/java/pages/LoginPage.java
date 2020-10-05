package pages;

import com.codeborne.selenide.Condition;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

import static com.codeborne.selenide.Selenide.open;

@Log4j2
public class LoginPage {
    private static final String URL = "https://moodpanda.com/Login/";
    private static final By EMAIL_INPUT = By.id("ContentPlaceHolderContent_TextBoxEmail");
    private static final By PASSWORD_INPUT = By.id("ContentPlaceHolderContent_TextBoxPassword");
    private static final By LOGIN_BUTTON = By.id("ContentPlaceHolderContent_ButtonLogin");

    public LoginPage openPage() {
        open(URL);
        isPageOpened();
        log.info(String.format("Opening page: %s", URL));
        return this;
    }

    public LoginPage isPageOpened() {
        $(LOGIN_BUTTON).shouldBe(Condition.visible);
        log.info("Login page is opened");
        return this;
    }

    public LoginPage fillInEmailAndPasswordFields(String email, String password) {
        $(EMAIL_INPUT).sendKeys(email);
        $(PASSWORD_INPUT).sendKeys(password);
        log.info(String.format("Inputting email: %s, password: %s", email, password));
        return this;
    }

    public WorldFeedPage clickLogin() {
        $(LOGIN_BUTTON).click();
        log.info("Clicking login");
        return new WorldFeedPage();
    }

}
