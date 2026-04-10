package ui_tests_pobeda;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static ui_tests_pobeda.TestData.pobedaUrl;

public class TestBase {

    public WebDriver driver;
    WebDriverWait wait;
    public Actions actions;

    @BeforeEach
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        driver = new ChromeDriver(options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(23));
        actions = new Actions(driver);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(24));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
        driver.get(pobedaUrl);
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }

}
