package stepDefinitions;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import utils.PropertiesReader;

import java.util.concurrent.TimeUnit;

public class SharedSD {
    private static WebDriver driver;

    @Before
    public static void setUp() {
        PropertiesReader pr = new PropertiesReader();
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setJavascriptEnabled(true);
        ChromeOptions ops = new ChromeOptions();
        ops.addArguments("--disable-notifications");
        System.setProperty("webdriver.chrome.driver", pr.getChromeDriverPass());
        driver = new ChromeDriver();
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(30, TimeUnit.SECONDS);
        //driver.get(pr.getUrl());
//        driver.get(pr.getUrlAuth());

    }

    @After
    public static void after() {
        if (driver != null) {
            driver.manage().deleteAllCookies();
            driver.quit();
        }
    }

    public static WebDriver getDriver() {
        return driver;
    }
}
