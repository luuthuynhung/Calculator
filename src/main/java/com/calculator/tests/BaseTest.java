package com.calculator.tests;

import com.aventstack.extentreports.ExtentTest;
import com.microsoft.playwright.*;
import com.microsoft.playwright.options.WaitUntilState;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.util.Objects;

public class BaseTest {
    static Playwright playwright;
    static Browser browser;
    static Page page;
    static String CHROME = "chrome";
    static String FIREFOX = "firefox";
    static String EDGE = "msedge";
    public ExtentTest extentTest;
    BrowserContext browserContext;

    @BeforeClass
    static void launchBrowser(ITestContext testContext) {

        playwright = Playwright.create();
        String specifiedBrowser = testContext.getCurrentXmlTest().getParameter("browser");
        if (Objects.equals(specifiedBrowser, CHROME)) {
            browser = playwright.chromium()
                    .launch(new BrowserType.LaunchOptions()
                            .setHeadless(false)
                            .setSlowMo(2000)
                            .setChannel(CHROME));
        } else if (Objects.equals(specifiedBrowser, EDGE)) {
            browser = playwright.chromium()
                    .launch(new BrowserType.LaunchOptions()
                            .setHeadless(false)
                            .setSlowMo(2000)
                            .setChannel(EDGE));
        } else if (Objects.equals(specifiedBrowser, FIREFOX)) {
            browser = playwright.firefox()
                    .launch(new BrowserType.LaunchOptions()
                            .setHeadless(false)
                            .setSlowMo(2000));
        } else {
            System.out.println("Invalid browser, processing to run with Chrome");
            browser = playwright.chromium()
                    .launch(new BrowserType.LaunchOptions()
                            .setHeadless(false)
                            .setSlowMo(10)
                            .setChannel(CHROME));
        }
        System.out.println("Running with browser type: " + browser.browserType().name());

        page = browser.newPage();
        page.navigate(testContext.getCurrentXmlTest().getParameter("url"), new Page.NavigateOptions()
                .setTimeout(0)
                .setWaitUntil(WaitUntilState.DOMCONTENTLOADED));
    }

    @AfterSuite(alwaysRun = true)
    static void closeBrowser() {
        browser.close();
        playwright.close();
    }

    @BeforeMethod
    public void createContext() {
        browserContext = browser.newContext();
    }

    @AfterMethod
    public void closeContext() {
        browserContext.close();
    }
}
