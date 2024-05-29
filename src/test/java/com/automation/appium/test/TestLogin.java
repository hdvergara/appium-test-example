package com.automation.appium.test;

import com.automation.appium.page.HomePage;
import com.automation.appium.page.LoginPage;
import com.automation.appium.page.SignUpPage;
import com.automation.appium.utilities.ReportManager;
import com.aventstack.extentreports.ExtentTest;
import com.github.javafaker.Faker;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.net.MalformedURLException;

import static com.automation.appium.configuration.ConfigureCapabilities.getMobileElementAndroidDriver;

public class TestLogin {

    private static AndroidDriver<MobileElement> driver = null;

    @BeforeAll
    static void setUp() throws MalformedURLException {
        driver = getMobileElementAndroidDriver();
        ReportManager.initializeReport();
    }

    @AfterEach
    void finishReport() {
        ReportManager.flushReport();
    }

    @AfterAll
    static void cleanup() {
        driver.quit();
    }

    @Test
    void testSignUp() {
        ExtentTest extentTest = ReportManager.createTest("TESTING SIGN-UP FUNCTIONALITY");
        Faker faker = new Faker();
        String email = faker.internet().emailAddress();
        String password = faker.internet().password();
        HomePage homePage = new HomePage(driver, extentTest);
        homePage.clickOnLoginOption();
        homePage.clickOnSignUpTab();
        SignUpPage signUpPage = new SignUpPage(driver, extentTest);
        signUpPage.signUp(email, password);
        Assertions.assertThat(signUpPage.getMessageSignUp())
                .as("")
                .isEqualTo("You successfully signed up!");
        signUpPage.tapOkButton();
    }

    @Test
    void testLogin() {
        ExtentTest extentTest = ReportManager.createTest("TESTING LOGIN FUNCTIONALITY");
        Faker faker = new Faker();
        String email = faker.internet().emailAddress();
        String password = faker.internet().password();
        HomePage homePage = new HomePage(driver, extentTest);
        homePage.clickOnLoginOption();
        homePage.clickOnLoginTab();

        LoginPage loginPage = new LoginPage(driver, extentTest);
        loginPage.login(email, password);
        Assertions.assertThat(loginPage.getMessageSignUp())
                .as("")
                .isEqualTo("You are logged in!");
        loginPage.tapOkButton();
    }
}
