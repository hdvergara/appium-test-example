package com.automation.appium.actions;

import com.aventstack.extentreports.ExtentTest;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;

@Log4j2
public class Actions {

    private final WebDriverWait wait;
    private final ExtentTest extentTest;

    /**
     * Constructs an instance of the {@code Actions} class with the specified {@link AndroidDriver} and {@link ExtentTest}.
     *
     * <p>This constructor initializes the {@link WebDriverWait} with a timeout of 20 seconds and sets the {@code extentTest}
     * for logging and reporting purposes.</p>
     *
     * @param driver     the {@link AndroidDriver} instance used to interact with the mobile application.
     * @param extentTest the {@link ExtentTest} instance used for logging and reporting.
     */
    public Actions(AndroidDriver<MobileElement> driver, ExtentTest extentTest) {
        this.wait = new WebDriverWait(driver, 20);
        this.extentTest = extentTest;
    }

    /**
     * Sends the specified text to the given element.
     *
     * <p>This method waits until the specified element is clickable, then sends the provided text to it.
     * It also logs this action for reporting and debugging purposes.</p>
     *
     * @param element the {@link By} locator of the element to which the text will be sent.
     * @param text    the text to send to the element.
     */
    public void sendText(By element, String text) {
        wait.until(elementToBeClickable(element)).sendKeys(text);
        extentTest.info("Sent text '" + text + "' to element: " + element);
        log.info("Sent text '" + text + "' to element: " + element);
    }

    /**
     * Clicks on the specified element.
     *
     * <p>This method waits until the specified element is clickable, then performs a click action on it.
     * It also logs this action for reporting and debugging purposes.</p>
     *
     * @param element the {@link By} locator of the element to click.
     */
    public void click(By element) {
        wait.until(elementToBeClickable(element)).click();
        extentTest.info("Clicked on element: " + element);
        log.info("Clicked on element: " + element);
    }

    /**
     * Retrieves the text from the specified element.
     *
     * <p>This method waits until the specified element is clickable, then retrieves and returns its text.
     * It also logs this action for reporting and debugging purposes.</p>
     *
     * @param element the {@link By} locator of the element from which the text will be retrieved.
     * @return the text from the specified element.
     */
    public String getText(By element) {
        extentTest.info("The text was obtained from the element: " + element);
        log.info("The text was obtained from the element: " + element);
        return wait.until(elementToBeClickable(element)).getText();
    }

    /**
     * Checks if the specified element is visible.
     *
     * <p>This method waits until the specified element is clickable, then checks and returns if it is displayed.
     * It also logs this action for reporting and debugging purposes.</p>
     *
     * @param element the {@link By} locator of the element to check.
     * @return {@code true} if the element is visible, {@code false} otherwise.
     */
    public boolean isElementVisible(By element) {
        return wait.until(elementToBeClickable(element)).isDisplayed();
    }
}
