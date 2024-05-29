package com.automation.appium.utilities;

import com.automation.appium.configuration.ConfigProperties;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ReportManager {
    private static ExtentReports extent;
    public static final String REPORT_PATH = "reports/";
    private static final String NAME_REPORT = "ExtentReport";

    /**
     * Initializes the report for automated test results.
     *
     * <p>This method sets up the {@link ExtentSparkReporter} with the specified configurations such as the theme,
     * document title, encoding, and report name. It then initializes the {@link ExtentReports} instance and attaches
     * the reporter to it. Additionally, it sets system information including the operating system, environment,
     * and user.</p>
     */
    public static void initializeReport() {
        ExtentSparkReporter htmlReporter = new ExtentSparkReporter(REPORT_PATH + NAME_REPORT + dateFormat() + ".html");
        htmlReporter.config().setTheme(Theme.STANDARD);
        htmlReporter.config().setDocumentTitle("Automated Test Report");
        htmlReporter.config().setEncoding("utf-8");
        htmlReporter.config().setReportName("Automated Test Results");
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
        extent.setSystemInfo("OS", ConfigProperties.getProperty("OS"));
        extent.setSystemInfo("Environment", ConfigProperties.getProperty("Environment"));
        extent.setSystemInfo("User", ConfigProperties.getProperty("User"));
    }

    /**
     * Creates a new test entry in the report with the specified test name.
     *
     * <p>This method uses the {@link ExtentReports} instance to create a new test with the given name and returns
     * the corresponding {@link ExtentTest} instance.</p>
     *
     * @param testName the name of the test to be created in the report.
     * @return the {@link ExtentTest} instance representing the created test.
     */
    public static ExtentTest createTest(String testName) {
        return extent.createTest(testName);
    }

    /**
     * Flushes the report to ensure all information is written to the output file.
     *
     * <p>This method calls the {@link ExtentReports#flush()} method to write all the logs, details,
     * and results to the configured report output. This should be called at the end of the test suite
     * to finalize the report.</p>
     */
    public static void flushReport() {
        extent.flush();
    }

    /**
     * Generates a formatted date string representing the current date and time.
     *
     * <p>This method retrieves the current date and time using {@link LocalDateTime#now()},
     * formats it according to the specified pattern ("yyyy-MM-dd_HH-mm-ss") using
     * {@link DateTimeFormatter#ofPattern(String)}, and returns the formatted date string.</p>
     *
     * @return a formatted date string representing the current date and time.
     */
    private static String dateFormat() {
        LocalDateTime localDateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd_HH-mm-ss");
        return localDateTime.format(formatter);
    }
}
