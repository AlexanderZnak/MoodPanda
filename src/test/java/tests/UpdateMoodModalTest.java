package tests;

import io.qameta.allure.Description;
import org.testng.annotations.Test;
import pages.UpdateMoodModal;

public class UpdateMoodModalTest extends BaseTest {

    @Test(description = "Success of working the slider", retryAnalyzer = Retry.class, dataProvider = "checkRateOfMood", dataProviderClass = UpdateMoodModal.class)
    @Description("Validation of correct working the slider")
    public void setUpMoodBySlider(int setUpRateOfMood, int validateMood) {
        loginSteps
                .logIn(EMAIL, PASSWORD)
                .validateIsPageOpened();
        updateMoodModalSteps
                .openModal()
                .setUpMoodBySlider(setUpRateOfMood)
                .validateSetUpMoodIsCorrect(validateMood);
    }

    @Test(description = "Success of working the Cancel button", retryAnalyzer = Retry.class)
    @Description("Validation of correct working the Cancel button")
    public void afterClickButtonCancelShouldBeOpenedPageWhichWasModalOpenedWith() {
        loginSteps
                .logIn(EMAIL, PASSWORD)
                .validateIsPageOpened();
        updateMoodModalSteps
                .openModal()
                .cancelUpdateMood()
                .validateIsPageOpened();
    }

    @Test(description = "Success of working the Close by clicking X", retryAnalyzer = Retry.class)
    @Description("Validation of correct working the Close by clicking X")
    public void afterClickXToCloseShouldBeOpenedPageWhichWasModalOpenedWith() {
        loginSteps
                .logIn(EMAIL, PASSWORD)
                .validateIsPageOpened();
        updateMoodModalSteps
                .openModal()
                .closeUpdateMood()
                .validateIsPageOpened();
    }

    @Test
    public void createNewUpdateMood() {
        loginSteps
                .logIn(EMAIL, PASSWORD)
                .validateIsPageOpened();
        updateMoodModalSteps
                .openModal()
                .updateMood(4, "I am fine", "Yesterday", "2 am", ":30")
                .validateIsNewUpdateMoodCreated();

    }

}
