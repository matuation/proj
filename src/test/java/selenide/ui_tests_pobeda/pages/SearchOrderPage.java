package selenide.ui_tests_pobeda.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import java.time.Duration;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static selenide.ui_tests_pobeda.TestData.expectedInvalidOrderParamErrorText;

public class SearchOrderPage {

    private final SelenideElement bookingOrTicketNumber = $(byXpath("//input[contains(@name, 'pnrOrTicketNumber') and contains(@placeholder, 'Номер брони или билета')]")),
            clientSecondName = $(byXpath("//input[contains(@name, 'lastName') and contains(@placeholder, 'Фамилия')]")),
            personalDataAgreementCheckbox = $(byXpath("//div[@class = 'customCheckbox']")),
            findOrderButton = $(byXpath("//button[contains(@class , 'btn_formSearch')]")),
            invalidOrderParamError = $(byXpath("//div[@class = 'message_error']"));

    @Step("Проверить, что отображается поле 'Номер бронирования или билета'")
    public SearchOrderPage checkNumberInputField() {
        bookingOrTicketNumber.isDisplayed();
        return this;
    }

    @Step("Проверить, что отображается поле 'Фамилия клиента'")
    public SearchOrderPage checkClientLastName() {
        clientSecondName.isDisplayed();
        return this;
    }

    @Step("Проверить, что отображается кнопка 'Найти заказ'")
    public SearchOrderPage checkFindOrderButton() {
        findOrderButton.isDisplayed();
        return this;
    }

    @Step("Установить чекбокс 'Продолжая, Вы подтверждаете, что ознакомились с Политикой конфиденциальности'")
    public SearchOrderPage setPersonalDataAgreementCheckbox() {
        personalDataAgreementCheckbox.click();
        return this;
    }

    @Step("Нажать на кнопку 'Найти заказ'")
    public SearchOrderPage findOrderButtonClick() {
        findOrderButton.click();
        return this;
    }

    @Step("Проверить, что отображается ошибка 'Заказ с указанными параметрами не найден'")
    public SearchOrderPage checkInvalidOrderParamError() {
        invalidOrderParamError.shouldHave(text(expectedInvalidOrderParamErrorText), Duration.ofSeconds(25));
        return this;
    }


}
