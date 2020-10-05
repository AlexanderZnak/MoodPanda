package pages;

import com.codeborne.selenide.Condition;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

@Log4j2
public class WorldFeedPage {
    private static final By UPDATE_MOOD_BUTTON = By.id("LinkUpdate");
    private static final String URL = "https://moodpanda.com/Feed/";

    public WorldFeedPage openPage() {
        open(URL);
        isPageOpened();
        log.info(String.format("Opening page: %s", URL));
        return this;
    }

    public WorldFeedPage isPageOpened() {
        $(UPDATE_MOOD_BUTTON).shouldBe(Condition.visible);
        log.info("World Feed Page is opened");
        return this;
    }
}
