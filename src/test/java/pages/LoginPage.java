package pages;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

import static com.codeborne.selenide.Selenide.open;

public class LoginPage {
    private static final String URL = "https://moodpanda.com/Login/";
    private static final By EMAIL_INPUT = By.id("ContentPlaceHolderContent_TextBoxEmail");
    private static final By PASSWORD_INPUT = By.id("ContentPlaceHolderContent_TextBoxPassword");
    private static final By LOGIN_BUTTON = By.id("ContentPlaceHolderContent_ButtonLogin");

    public LoginPage openPage() {
        open(URL);
        return this;
    }

    public LoginPage fillInEmailAndPasswordFields(String email, String password) {
        $(EMAIL_INPUT).sendKeys(email);
        $(PASSWORD_INPUT).sendKeys(password);
        return this;
    }

    public WorldFeedPage clickLogin() {
        $(LOGIN_BUTTON).click();
        return new WorldFeedPage();
    }

}
