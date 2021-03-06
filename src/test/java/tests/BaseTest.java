package tests;

import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseTest {

    public static WebDriver driver;

    @BeforeAll
    public static void beforeAll() {
        System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
        System.setProperty("envUrl", "https://www.seleniumeasy.com/test/");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }
}
