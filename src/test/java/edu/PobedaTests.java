package edu;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.NoSuchElementException;

import static java.util.concurrent.TimeUnit.MILLISECONDS;
import static java.util.concurrent.TimeUnit.SECONDS;
import static org.awaitility.Awaitility.await;

public class PobedaTests {

    String googleUrl = "https://google.com/";
    String googleInput = "//*[@id=\"APjFqb\"]";
    String searchStringPobeda = "Сайт компании Победа";
    String pobedaSearchResult = ".tjvcx.GvPZzd.cHaqb";
    String letsgoKaliningradText = ".dp-1ihjhh6-root";
    String letsgoKaliningradTextExpected = "Полетели в Калининград!";
    String letsgoKaliningradPic = "img[src*='f1cd.png']";
    String languageButton = "button[type='button'][class*='dp-11x0mgu-root-root']";
    String languageEng = "//div[@role='menuitem' and text()='English']";
    String ticketSearch = "//span[text()='Ticket search' and not(@aria-hidden='true')]";
    String ticketSearchText = "Ticket search";
    String onlineCheckin = "//span[text()='Online check-in' and not(@aria-hidden='true')]";
    String onlineCheckinText = "Online check-in";
    String manageMyBooking = "//span[text()='Manage my booking' and not(@aria-hidden='true')]";
    String manageMyBookingText = "Manage my booking";

    private WebDriver driver;
    private WebDriverWait wait;

    public void waitVisibleElement(By locator) {
        await()
                .atMost(65, SECONDS)
                .pollInterval(100, MILLISECONDS)
                .ignoreExceptionsMatching(e -> e instanceof NoSuchElementException)
                .until(() -> driver.findElement(locator).isDisplayed());
    }

    @BeforeEach
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        driver = new ChromeDriver(options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(23));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(24));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
        driver.get(googleUrl);
    }

    @Test
    public void pobedaSearchAndInteractTest() {

        driver.findElement(By.xpath(googleInput))
                .sendKeys(searchStringPobeda + Keys.ENTER);

        driver.findElement(By.cssSelector(pobedaSearchResult)).click();
        waitVisibleElement(By.cssSelector(letsgoKaliningradText));
        waitVisibleElement(By.cssSelector(letsgoKaliningradPic));

        Assertions.assertEquals(driver.findElement(By.cssSelector(letsgoKaliningradText)).getText(), letsgoKaliningradTextExpected);

        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(languageButton))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(languageEng))).click();
        wait.until(ExpectedConditions.textToBePresentInElementLocated(
                By.xpath(ticketSearch),
                ticketSearchText));

        Assertions.assertEquals(ticketSearchText, driver.findElement(By.xpath(ticketSearch)).getText());

        wait.until(ExpectedConditions.textToBePresentInElementLocated(
                By.xpath(onlineCheckin),
                onlineCheckinText));

        Assertions.assertEquals(onlineCheckinText, driver.findElement(By.xpath(onlineCheckin)).getText());

        wait.until(ExpectedConditions.textToBePresentInElementLocated(
                By.xpath(manageMyBooking),
                manageMyBookingText));

        Assertions.assertEquals(manageMyBookingText, driver.findElement(By.xpath(manageMyBooking)).getText());


    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }
}
