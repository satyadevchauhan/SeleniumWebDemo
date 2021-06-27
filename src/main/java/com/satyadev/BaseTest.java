package com.satyadev;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class BaseTest {

    public static final long TIME_IN_SEC = 1000;
    public static WebDriver driver;
    public static Properties properties;

    public BaseTest() {
        System.out.println("BaseTest");
        try {
            properties = new Properties();
            FileInputStream configFile = new FileInputStream(System.getProperty("user.dir")+ "/src/main/resources"
                    + "/config.properties");
            properties.load(configFile);
            initBrowser();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void initBrowser() {
        System.out.println("initBrowser");
        String browserName = properties.getProperty("browser");

        if (browserName.equals("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else if (browserName.equals("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        } else {
            System.out.println("Unknown browser");
        }

        //driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
    }

    @BeforeSuite
    public void beforeSuite() {
        System.out.println("Before Suite method");
    }

    @AfterSuite
    public void afterSuite() {
        System.out.println("After Suite method");
    }

    @BeforeTest
    public void beforeTest() {
        System.out.println("Before Test method");
    }

    @AfterTest
    public void afterTest() {
        System.out.println("After Test method");
    }

    @BeforeClass
    public void beforeClass() {
        System.out.println("Before Class method");
    }

    @AfterClass
    public void afterClass() {
        System.out.println("After Class method");
    }

    @BeforeMethod
    public void beforeMethod() {
        System.out.println("Before Method");
    }

    @AfterMethod
    public void afterMethod() {
        System.out.println("After Method");
    }

    public void sleep(int seconds) {
        try {
            Thread.sleep(seconds * TIME_IN_SEC);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
