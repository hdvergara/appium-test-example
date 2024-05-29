package com.automation.appium.page;

import com.aventstack.extentreports.ExtentTest;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import com.automation.appium.actions.Actions;

public class HomePage {

    private final By optLogin = new MobileBy.ByAccessibilityId("Login");
    private final By optSignUp = new By.ByXPath("//android.widget.TextView[@text='Sign up']");
    private final By optLoginTab = new By.ByXPath("//android.widget.TextView[@text='Login']");

    private final Actions actions;

    public HomePage(AndroidDriver<MobileElement> driver, ExtentTest extentTest) {
        this.actions = new Actions(driver,extentTest);
    }
    public void clickOnLoginOption() {
        actions.click(optLogin);
    }
    public void clickOnSignUpTab() {
        actions.click(optSignUp);
    }
    public void clickOnLoginTab() {
        actions.click(optLoginTab);
    }
}
