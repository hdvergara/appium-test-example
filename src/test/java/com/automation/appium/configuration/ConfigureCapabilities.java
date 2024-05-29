package com.automation.appium.configuration;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Paths;

@Log4j2
public class ConfigureCapabilities {

    /**
     * Configures and returns an {@link AndroidDriver} for Mobile Elements with specified capabilities.
     *
     * <p>This method sets up the desired capabilities for an Android driver, including the platform name,
     * device name, automation name, and application path. It then initializes and returns an {@link AndroidDriver}
     * instance configured with these capabilities.</p>
     *
     * @return an {@link AndroidDriver} instance configured with the specified capabilities.
     * @throws MalformedURLException if the URL for the Appium server is malformed.
     */
    public static AndroidDriver<MobileElement> getMobileElementAndroidDriver() throws MalformedURLException {
        log.info("Configuring capabilities");
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platformName", ConfigProperties.getProperty("PLATFORM_NAME"));
        caps.setCapability("deviceName", ConfigProperties.getProperty("DEVICE_NAME"));
        caps.setCapability("appium:automationName", ConfigProperties.getProperty("AUTOMATION_NAME"));
        caps.setCapability("appium:noReset", false);
        String appPath = Paths.get("src", "test", "resources", "apk", "android_test.apk").toAbsolutePath().toString();
        caps.setCapability("appium:app", appPath);
        log.info("Configured capabilities");
        return new AndroidDriver<>(new URL(ConfigProperties.getProperty("URL_APPIUM")), caps);
    }
}
