package pages;

import com.codeborne.selenide.Condition;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.DataProvider;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.sleep;

@Log4j2
public class UpdateMoodModal {
    private static final By UPDATE_MOOD_BUTTON = By.id("LinkUpdate");
    public static final String UPDATE_MOOD_TO = "[class='btn btn-sm btn-primary ButtonUpdate']";
    private static final By TEXT_AREA_FOR_MOOD = By.id("TextBoxUpdateMoodTag");
    private static final String SLIDER = ".ui-slider-handle.ui-state-default";
    private static final String SLIDER_RANGE = ".ui-slider-range.ui-widget-header";
    private static final String CANCEL_BUTTON = ".btn-default.pull-left";
    private static final By CLOSE_X = By.xpath("//*[contains(text(),'Happiness')]/parent::div//button");
    private static final String TIME_BUTTON = "//div[contains(text(),'%s')]";
    private static final By SELECT_TIME_HOURS = By.id("ddlHistoricHour");
    private static final By SELECT_TIME_MINUTES = By.id("ddlHistoricMinute");

    public UpdateMoodModal openUpdateMoodModal() {
        $(UPDATE_MOOD_BUTTON).click();
        isModalOpened();
        log.info("Opening Update mood modal");
        return this;
    }

    public UpdateMoodModal isModalOpened() {
        $(UPDATE_MOOD_TO).shouldBe(Condition.visible);
        log.info("UpdateMood Modal is opened");
        return this;
    }

    public UpdateMoodModal selectTimeHours(String hour) {
        $(SELECT_TIME_HOURS).shouldBe(Condition.visible).selectOption(hour);
        log.info(String.format("Select hours: %s",hour));
        return this;

    }

    public UpdateMoodModal clickUpdateMoodTo() {
        $(UPDATE_MOOD_TO).click();
        log.info("Clicking Update Mood To");
        return this;
    }

    public UpdateMoodModal selectTimeMinutes(String minute) {
        $(SELECT_TIME_MINUTES).shouldBe(Condition.visible).selectOption(minute);
        log.info(String.format("Select minutes: %s",minute));
        return this;
    }

    public UpdateMoodModal chooseTime(String time) {
        String xPath = String.format(TIME_BUTTON, time);
        $(By.xpath(xPath)).click();
        log.debug(String.format("Choose time : %s by locator: %s", time,xPath));
        return this;
    }

    public UpdateMoodModal writeWhatsHappening(String text) {
        $(TEXT_AREA_FOR_MOOD).sendKeys(text);
        log.info(String.format("Inputting of words: %s",text));
        return this;
    }

    public UpdateMoodModal moveToSliderToChangeRateOfMood(int rateOfMood) {
        if (rateOfMood < 5) {
            for (int i = 5 - rateOfMood; i > 0; i--) {
                $(SLIDER).sendKeys(Keys.ARROW_LEFT);
            }
        } else if (rateOfMood > 5) {
            for (int i = rateOfMood - 5; i > 0; i--) {
                $(SLIDER).sendKeys(Keys.ARROW_RIGHT);
            }
        }
        log.info(String.format("Move by slider by specified value: %d", rateOfMood));
        return this;
    }

    public UpdateMoodModal clickButtonCancel() {
        $(CANCEL_BUTTON).click();
        log.info("Clicking Cancel for Update Mood Modal");
        return this;
    }

    public UpdateMoodModal clickXToClose() {
        $(CLOSE_X).click();
        log.info("Clicking Close for Update Mood Modal");
        return this;
    }

    @DataProvider(name = "checkRateOfMood")
    public Object[][] rateOfMood() {
        return new Object[][]{
                {0, 0},
                {1, 1},
                {4, 4},
                {6, 6},
                {9, 9},
                {10, 10}
        };

    }

}
