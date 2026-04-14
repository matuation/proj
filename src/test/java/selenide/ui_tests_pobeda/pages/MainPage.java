package selenide.ui_tests_pobeda.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
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

    @Step("Проверить заголовок страницы")
    public MainPage assertTitle() {
        webdriver().shouldHave(title(mainPageTitle));
        return this;
    }

    @Step("Проверить, что отображается поле логотип")
    public MainPage findLogo() {
        titlePageLogoLocator.isDisplayed();
        return this;
    }

    @Step("Навести указатель на всплывающее окно 'Информация'")
    public MainPage informationHover() {
        informationLocator.hover();
        return this;
    }

    @Step("Проверить что есть заголовок блока 'Подготовка к полёту'")
    public MainPage checkPrepareFlightText(String expected) {
        Assertions.assertEquals(expected, prepareFlightLocator.getText());
        return this;
    }

    @Step("Проверить что есть заголовок блока 'Полезная информация'")
    public MainPage checkUsefulInfoText(String expected) {
        Assertions.assertEquals(expected, usefulInfoLocator.getText());
        return this;
    }

    @Step("Проверить что есть заголовок блока 'О компании'")
    public MainPage checkAboutText(String expected) {
        Assertions.assertEquals(expected, aboutPobedaLocator.getText());
        return this;
    }

    @Step("Проверить что отображается поле 'Откуда'")
    public MainPage checkFromInputDisplayed() {
        fromInputLocator.isDisplayed();
        return this;
    }

    @Step("Проверить что отображается поле 'Куда'")
    public MainPage destinationInputDisplayed() {
        destinationInputLocator.isDisplayed();
        return this;
    }

    @Step("Проверить что отображается поле 'Туда'")
    public MainPage checkStartDateInputDisplayed() {
        startDateInputLocator.isDisplayed();
        return this;
    }

    @Step("Проверить что отображается поле 'Обратно'")
    public MainPage checkEndDateInputDisplayed() {
        endDateInputLocator.isDisplayed();
        return this;
    }

    @Step("Нажать на поле 'Куда'")
    public MainPage clickDestinationInput() {
        destinationInputLocator.click();
        return this;
    }

    @Step("Нажать на текст 'Управление бронированием'")
    public MainPage clickBookingControl() {
        booingControl.click();
        return this;
    }

    @Step("Ввести город назначения {keys}")
    public MainPage setDestination(String keys) {
        destinationInputLocator.sendKeys(keys);
        return this;
    }

    @Step("Ввести фамилию клиента {keys}")
    public MainPage setClientSecondName(String keys) {
        clientSecondName.sendKeys(keys);
        return this;
    }

    @Step("Ввести номер бронирования или билета {keys}")
    public MainPage setBookingOrTicketNumber(String keys) {
        bookingOrTicketNumber.sendKeys(keys);
        return this;
    }

    @Step("Выбрать введенный город назначения")
    public MainPage clickDestinationResult() {
        destinationSearchResultLocator.click();
        return this;
    }

    @Step("Нажать на кнопку 'Поиск'")
    public MainPage searchSubmitButtonClick() {
        submitButtonLocator.click();
        return this;
    }

    @Step("Проверить что у поля 'Туда' появилась красная обводка")
    public MainPage checkStartDateHaveRedBorder() {
        failedStartDate.shouldHave(cssValue("border-color", redBorder), Duration.ofSeconds(10));
        return this;
    }

    @Step("Перейти на открывшуюся вкладку")
    public void switchToNewTab() {
        switchTo().window(1);
    }


}
