package ui_tests_pobeda.pages;

import junit.framework.Assert;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static ui_tests_pobeda.TestData.mainPageTitle;

public class MainPage {

    private WebDriver driver;
    private Actions actions;

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

    public MainPage checkElement(WebElement element, String expected) {
        Assertions.assertEquals(expected, element.getText());
        return this;
    }


}
