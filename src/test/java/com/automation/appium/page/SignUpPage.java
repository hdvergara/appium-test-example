package com.automation.appium.page;

import com.automation.appium.actions.Actions;
import com.aventstack.extentreports.ExtentTest;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;


public class SignUpPage {

    private final By INPUT_EMAIL = new MobileBy.ByAccessibilityId("input-email");
    private final By INPUT_PASSWORD = new MobileBy.ByAccessibilityId("input-password");
    private final By INPUT_CONFIRM_PASSWORD = new MobileBy.ByAccessibilityId("input-repeat-password");
    private final By BUTTON_SIGN_UP = new MobileBy.ByAccessibilityId("button-SIGN UP");
    private final By LBL_MESSAGE_POP_UP = new By.ById("android:id/message");
    private final By BUTTON_OK = new By.ById("android:id/button1");
    private final Actions actions;

    public SignUpPage(AndroidDriver<MobileElement> driver, ExtentTest extentTest) {
        this.actions = new Actions(driver, extentTest);
    }

    public void signUp(String email, String password) {
        actions.sendText(INPUT_EMAIL, email);
        actions.sendText(INPUT_PASSWORD, password);
        actions.sendText(INPUT_CONFIRM_PASSWORD, password);
        actions.click(BUTTON_SIGN_UP);
    }

    public String getMessageSignUp() {
        return actions.getText(LBL_MESSAGE_POP_UP);
    }

    public void tapOkButton() {
        actions.click(BUTTON_OK);
    }
}
