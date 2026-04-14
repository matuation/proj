package edu;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class PikabuTests {

    WebDriver driver;

    String url = "https://pikabu.ru/";
    String titleExpected = "Горячее – самые интересные и обсуждаемые посты | Пикабу";
    String loginButton = "button.pkb-normal-btn:nth-child(5)";
    String loginWindow = "//div[7]/div/div[1]/div/div[1]/div";
    String loginInput = "//div[2]/div[1]/div/div[1]/div[2]/form/div[1]/div/div/input";
    String passwordInput = "//div[2]/div[1]/div/div[1]/div[2]/form/div[2]/div/div/input";
    String loginWindowButton = "//div[2]/div[1]/div/div[1]/div[2]/form/div[4]/button";
    String stringToSend = "Qwerty";
    String wrongCredentialsErrorElement = "//div[6]/div/div[1]/div/div[1]/div/span";
    String wrongCredentialsErrorMessage = "Ошибка. Вы ввели неверные данные авторизации";


    @BeforeEach
    public void setUp() {
        driver = new ChromeDriver();
        driver.get(url);
    }

    @Test
    public void unsuccessfulAuthorizationTest() {

        Assertions.assertEquals(titleExpected, driver.getTitle());

        driver.findElement(By.cssSelector(loginButton)).click();

        driver.findElement(By.xpath(loginWindow)).isDisplayed();
        driver.findElement(By.xpath(loginInput)).isDisplayed();
        driver.findElement(By.xpath(passwordInput)).isDisplayed();
        driver.findElement(By.xpath(loginWindowButton)).isDisplayed();

        driver.findElement(By.xpath(loginInput)).sendKeys(stringToSend);
        driver.findElement(By.xpath(passwordInput)).sendKeys(stringToSend);
        driver.findElement(By.xpath(loginWindowButton)).click();

        driver.findElement(By.xpath(wrongCredentialsErrorElement)).isDisplayed();
        Assertions.assertEquals(wrongCredentialsErrorMessage,
                driver.findElement(By.xpath(wrongCredentialsErrorElement)).getText());
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }
}
