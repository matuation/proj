package selenide.ui_tests_pobeda.pages;

import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Assertions;

import java.time.Duration;

import static com.codeborne.selenide.Condition.cssValue;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverConditions.title;
import static selenide.ui_tests_pobeda.TestData.mainPageTitle;
import static selenide.ui_tests_pobeda.TestData.redBorder;

public class MainPage {

    private final SelenideElement titlePageLogoLocator = $("img[alt*='Победа']"),
            informationLocator = $(byText("Информация")),
            prepareFlightLocator = $(byText("Подготовка к полёту")),
            usefulInfoLocator = $(byText("Полезная информация")),
            aboutPobedaLocator = $(byText("О компании")),
            fromInputLocator = $("input[placeholder='Откуда']"),
            destinationInputLocator = $("input[placeholder='Куда']"),
            startDateInputLocator = $("input[placeholder='Туда']"),
            endDateInputLocator = $("input[placeholder='Обратно']"),
            submitButtonLocator = $(byXpath("//button[@type='submit']")),
            destinationSearchResultLocator = $(byXpath("//div[contains(@class, 'root-suggestionName') and contains(text(), 'Санкт-Петербург')]")),
            failedStartDate = $(byXpath("//div[@data-failed='true']")),
            booingControl = $(byXpath("//button[.//span[contains(@class, 'dp-12qummd-root-inner') and contains(text(), 'Управление бронированием')]]")),
            clientSecondName = $(byXpath("//input[contains(@placeholder, 'Фамилия клиента')]")),
            bookingOrTicketNumber = $(byXpath("//input[contains(@placeholder, 'Номер бронирования или билета')]"));

    public MainPage assertTitle() {
        webdriver().shouldHave(title(mainPageTitle));
        return this;
    }

    public MainPage findLogo() {
        titlePageLogoLocator.isDisplayed();
        return this;
    }

    public MainPage informationHover() {
        informationLocator.hover();
        return this;
    }

    public MainPage checkPrepareFlightText(String expected) {
        Assertions.assertEquals(expected, prepareFlightLocator.getText());
        return this;
    }

    public MainPage checkUsefulInfoText(String expected) {
        Assertions.assertEquals(expected, usefulInfoLocator.getText());
        return this;
    }

    public MainPage checkAboutText(String expected) {
        Assertions.assertEquals(expected, aboutPobedaLocator.getText());
        return this;
    }

    public MainPage checkFromInputDisplayed() {
        fromInputLocator.isDisplayed();
        return this;
    }

    public MainPage destinationInputDisplayed() {
        destinationInputLocator.isDisplayed();
        return this;
    }

    public MainPage checkStartDateInputDisplayed() {
        startDateInputLocator.isDisplayed();
        return this;
    }

    public MainPage checkEndDateInputDisplayed() {
        endDateInputLocator.isDisplayed();
        return this;
    }

    public MainPage clickDestinationInput() {
        destinationInputLocator.click();
        return this;
    }

    public MainPage clickBookingControl() {
        booingControl.click();
        return this;
    }

    public MainPage setDestination(String keys) {
        destinationInputLocator.sendKeys(keys);
        return this;
    }

    public MainPage setClientSecondName(String keys) {
        clientSecondName.sendKeys(keys);
        return this;
    }

    public MainPage setBookingOrTicketNumber(String keys) {
        bookingOrTicketNumber.sendKeys(keys);
        return this;
    }

    public MainPage clickDestinationResult() {
        destinationSearchResultLocator.click();
        return this;
    }

    public MainPage searchSubmitButtonClick() {
        submitButtonLocator.click();
        return this;
    }

    public MainPage checkStartDateHaveRedBorder() {
        failedStartDate.shouldHave(cssValue("border-color", redBorder), Duration.ofSeconds(10));
        return this;
    }

    public void switchToNewTab() {
        switchTo().window(1);
    }


}
