package steps;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import pages.UpdateMoodModal;
import pages.WorldFeedPage;

import static com.codeborne.selenide.Selenide.$;
import static org.testng.Assert.assertEquals;

@Log4j2
public class UpdateMoodModalSteps {
    UpdateMoodModal updateMoodModal;
    WorldFeedPage worldFeedPage;

    public UpdateMoodModalSteps() {
        updateMoodModal = new UpdateMoodModal();
        worldFeedPage = new WorldFeedPage();
    }

    @Step("Setting up the rate of mood: '{rateOfMood}' by slider")
    public UpdateMoodModalSteps setUpMoodBySlider(int rateOfModal) {
        updateMoodModal.moveToSliderToChangeRateOfMood(rateOfModal);
        log.info(String.format("Setting up the rate of mood: %d by slider", rateOfModal));
        return this;
    }

    @Step("Opening the update mood modal")
    public UpdateMoodModalSteps openModal() {
        updateMoodModal.openUpdateMoodModal();
        log.info("Opening the update mood modal");
        return this;
    }

    @Step("Validate is the rate of mood: '{rateOfMood}' set up correct")
    public UpdateMoodModalSteps validateSetUpMoodIsCorrect(int rateOfMood) {
        String textUpdateMoodTo = $(UpdateMoodModal.UPDATE_MOOD_TO).text();
        int actualResult = 0;
        for (int i = 0; i <= 10; i++) {
            if (textUpdateMoodTo.contains(String.valueOf(i))) {
                actualResult = i;
            }
        }
        assertEquals(actualResult, rateOfMood);
        log.info("Validate is the rate of mood: %d set up correct", rateOfMood);
        return this;
    }

    @Step("Canceling the update mood modal")
    public UpdateMoodModalSteps cancelUpdateMood() {
        updateMoodModal.clickButtonCancel();
        log.info("Canceling the update mood modal");
        return this;
    }

    @Step("Validate is the World Feed page opened")
    public UpdateMoodModalSteps validateIsPageOpened() {
        worldFeedPage.isPageOpened();
        log.info("Validate is the World Feed page opened");
        return this;
    }

    @Step("Closing the update mood modal")
    public UpdateMoodModalSteps closeUpdateMood() {
        updateMoodModal.clickXToClose();
        log.info("Closing the update mood modal");
        return this;
    }

    @Step("Filling in Update Mood set up rate of mood: '{rateOfMood}', write what's happening: '{someText}', choose time: '{time}', select hours: '{hour}', select minutes: '{minute}'")
    public UpdateMoodModalSteps updateMood(int rateOfMood, String someText, String time, String hour, String minute) {
        updateMoodModal
                .moveToSliderToChangeRateOfMood(rateOfMood)
                .writeWhatsHappening(someText)
                .chooseTime(time)
                .selectTimeHours(hour)
                .selectTimeMinutes(minute)
                .clickUpdateMoodTo();
        log.info(String.format("Filling in Update Mood set up rate of mood: %d, write what's happening: %s, choose time: %s, select hours: %s, select minutes: %s", rateOfMood,someText,time,hour,minute));
        return this;
    }

    public UpdateMoodModalSteps validateIsNewUpdateMoodCreated() {
        return this;
    }

}
