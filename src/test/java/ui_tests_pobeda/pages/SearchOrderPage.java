package ui_tests_pobeda.pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static ui_tests_pobeda.TestData.expectedInvalidOrderParamErrorText;

public class SearchOrderPage {

    @FindBy(xpath = "//input[contains(@name, 'pnrOrTicketNumber') and contains(@placeholder, 'Номер брони или билета')]")
    private WebElement bookingOrTicketNumber;

    @FindBy(xpath = "//input[contains(@name, 'lastName') and contains(@placeholder, 'Фамилия')]")
    private WebElement clientSecondName;

    @FindBy(xpath = "//div[@class = 'customCheckbox']")
    private WebElement personalDataAgreementCheckbox;

    @FindBy(xpath = "//button[contains(@class , 'btn_formSearch')]")
    private WebElement findOrderButton;

    @FindBy(xpath = "//div[@class = 'message_error']")
    private WebElement invalidOrderParamError;

    public SearchOrderPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public SearchOrderPage checkNumberInputField() {
        bookingOrTicketNumber.isDisplayed();
        return this;
    }

    public SearchOrderPage checkClientLastName() {
        clientSecondName.isDisplayed();
        return this;
    }

    public SearchOrderPage checkFindOrderButton() {
        findOrderButton.isDisplayed();
        return this;
    }

    public SearchOrderPage setPersonalDataAgreementCheckbox() {
        personalDataAgreementCheckbox.click();
        return this;
    }

    public SearchOrderPage findOrderButtonClick() {
        findOrderButton.click();
        return this;
    }

    public SearchOrderPage checkInvalidOrderParamError() {
        invalidOrderParamError.isDisplayed();
        Assertions.assertEquals(expectedInvalidOrderParamErrorText, invalidOrderParamError.getText());
        return this;
    }


}
