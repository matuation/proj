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

public class MainPage {

    private WebDriver driver;
    private Actions actions;
    private WebDriverWait wait;

    @FindBy(css = "img[alt*='Победа']")
    private WebElement titlePageLogoLocator;

    @FindBy(linkText = "Информация")
    private WebElement informationLocator;

    @FindBy(className = "dp-51aygc-inner")
    private WebElement informationPopupWindowLocator;

    @FindBy(linkText = "Подготовка к полёту")
    public WebElement prepareFlightLocator;

    @FindBy(linkText = "Полезная информация")
    public WebElement usefulInfoLocator;

    @FindBy(linkText = "О компании")
    public WebElement aboutPobedaLocator;

    @FindBy(xpath = "//input[contains(@class, 'root-control') and contains(@id, ':Rmqma5durm:')]")
    public WebElement searchAreaLocator;

    @FindBy(css = "input[placeholder='Откуда']")
    public WebElement fromInputLocator;

    @FindBy(css = "input[placeholder='Куда']")
    public WebElement destinationInputLocator;

    @FindBy(css = "input[placeholder='Туда']")
    public WebElement startDateInputLocator;

    @FindBy(css = "input[placeholder='Обратно']")
    public WebElement endDateInputLocator;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement submitButtonLocator;

    @FindBy(xpath = "//div[contains(@class, 'root-suggestionName') and contains(text(), 'Санкт-Петербург')]")
    public WebElement destinationSearchResultLocator;

    @FindBy(xpath = "//div[@data-failed='true']")
    public WebElement failedStartDate;

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

    public MainPage checkElementText(WebElement element, String expected) {
        Assertions.assertEquals(expected, element.getText());
        return this;
    }

    public MainPage checkElementValue(WebElement element, String expected) {
        Assertions.assertEquals(expected, element.getAttribute("value"));
        return this;
    }

    public MainPage checkElementDisplayed(WebElement element) {
        element.isDisplayed();
        return this;
    }

    public MainPage clickElement(WebElement element) {
        element.click();
        return this;
    }

    public MainPage typeInElement(WebElement element, String keys) {
        element.sendKeys(keys);
        return this;
    }

    public MainPage checkCssAttrElement(WebElement element, String propName, String expected) {
        Assertions.assertEquals(expected, element.getCssValue(propName));
        return this;
    }

    public MainPage waitForCssColor(WebElement element, String expectedRgba) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        wait.until(d -> {
            String actualColor = element.getCssValue("border-color");
            return actualColor.contains(expectedRgba);
        });

        return this;
    }


}
