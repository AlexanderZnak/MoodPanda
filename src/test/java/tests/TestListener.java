package tests;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.util.concurrent.TimeUnit;

public class TestListener implements ITestListener {

    public void onTestStart(ITestResult iTestResult) {
        System.out.println((String.format("======================================== STARTING TEST %s ========================================", iTestResult.getName())));
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide().screenshots(true).savePageSource(false).includeSelenideSteps(false));
    }

    public void onTestSuccess(ITestResult iTestResult) {
        System.out.println(String.format("======================================== FINISHED TEST %s Duration: %ss ========================================", iTestResult.getName(),
                getExecutionTime(iTestResult)));
    }

    public void onTestFailure(ITestResult iTestResult) {
        System.out.println(String.format("======================================== FAILED TEST %s Duration: %ss ========================================", iTestResult.getName(),
                getExecutionTime(iTestResult)));
    }

    public void onTestSkipped(ITestResult iTestResult) {
        System.out.println(String.format("======================================== SKIPPING TEST %s ========================================", iTestResult.getName()));
    }

    private long getExecutionTime(ITestResult iTestResult) {
        return TimeUnit.MILLISECONDS.toSeconds(iTestResult.getEndMillis() - iTestResult.getStartMillis());
    }

}
