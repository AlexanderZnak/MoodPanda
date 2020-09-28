package pages;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class WorldFeedPage {
    private static final By UPDATE_MOOD_BUTTON = By.id("LinkUpdate");

    public WorldFeedPage isPageOpened() {
        $(UPDATE_MOOD_BUTTON).shouldBe(Condition.visible);
        return this;
    }
}
