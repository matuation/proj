package ui_tests_pobeda.pages;

import junit.framework.Assert;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static ui_tests_pobeda.TestData.mainPageTitle;
import static ui_tests_pobeda.TestData.redBorder;

public class MainPage {

    private final WebDriver driver;
    private final Actions actions;

    @FindBy(css = "img[alt*='Победа']")
    private WebElement titlePageLogoLocator;

    @FindBy(linkText = "Информация")
    private WebElement informationLocator;

    @FindBy(className = "dp-51aygc-inner")
    private WebElement informationPopupWindowLocator;

    @FindBy(linkText = "Подготовка к полёту")
    private WebElement prepareFlightLocator;

    @FindBy(linkText = "Полезная информация")
    private WebElement usefulInfoLocator;

    @FindBy(linkText = "О компании")
    private WebElement aboutPobedaLocator;

    @FindBy(xpath = "//input[contains(@class, 'root-control') and contains(@id, ':Rmqma5durm:')]")
    private WebElement searchAreaLocator;

    @FindBy(css = "input[placeholder='Откуда']")
    private WebElement fromInputLocator;

    @FindBy(css = "input[placeholder='Куда']")
    private WebElement destinationInputLocator;

    @FindBy(css = "input[placeholder='Туда']")
    private WebElement startDateInputLocator;

    @FindBy(css = "input[placeholder='Обратно']")
    private WebElement endDateInputLocator;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement submitButtonLocator;

    @FindBy(xpath = "//div[contains(@class, 'root-suggestionName') and contains(text(), 'Санкт-Петербург')]")
    private WebElement destinationSearchResultLocator;

    @FindBy(xpath = "//div[@data-failed='true']")
    private WebElement failedStartDate;

    @FindBy(xpath = "//button[.//span[contains(@class, 'dp-12qummd-root-inner') and contains(text(), 'Управление бронированием')]]")
    private WebElement booingControl;

    @FindBy(xpath = "//input[contains(@placeholder, 'Фамилия клиента')]")
    private WebElement clientSecondName;

    @FindBy(xpath = "//input[contains(@placeholder, 'Номер бронирования или билета')]")
    private WebElement bookingOrTicketNumber;

    public MainPage(WebDriver driver) {
        this.driver = driver;
        this.actions = new Actions(driver);
        PageFactory.initElements(driver, this);
    }

    public MainPage assertTitle() {
        Assert.assertEquals(mainPageTitle, driver.getTitle());
        return this;
    }

    public MainPage findLogo() {
        titlePageLogoLocator.isDisplayed();
        return this;
    }

    public MainPage informationHover() {
        actions.moveToElement(informationLocator).perform();
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
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        wait.until(d -> {
            String actualColor = failedStartDate.getCssValue("border-color");
            return actualColor.contains(redBorder);
        });
        Assertions.assertEquals(redBorder, failedStartDate.getCssValue("border-color"));
        return this;
    }

    public void switchToNewTab() {
        String thisTab = driver.getWindowHandle();
        for (String tab : driver.getWindowHandles()) {
            if (!tab.equals(thisTab)) {
                driver.switchTo().window(tab);
            }
        }
    }


}
