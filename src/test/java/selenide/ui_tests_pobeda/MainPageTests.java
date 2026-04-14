package selenide.ui_tests_pobeda;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import selenide.ui_tests_pobeda.pages.MainPage;
import selenide.ui_tests_pobeda.pages.SearchOrderPage;

import static selenide.ui_tests_pobeda.TestData.*;

@Epic("Главная страница https://www.flypobeda.ru/")
@DisplayName("Тесты для главной страницы сайта https://www.flypobeda.ru/")
public class MainPageTests extends TestBase {

    MainPage mainPage = new MainPage();
    SearchOrderPage searchOrderPage = new SearchOrderPage();

    @Test
    @Description("Во всплывающем блоке 'Информация' есть разделы 'Подготовка к полёту' 'Полезная информация' и 'О компании'")
    @Feature("Всплывающий блок 'Информация' на главной")
    public void informationTest() {

        mainPage.assertTitle()
                .findLogo()
                .informationHover()
                .checkPrepareFlightText(prepareFlightExpectedText)
                .checkUsefulInfoText(usefulInfoExpectedText)
                .checkAboutText(aboutPobedaExpectedText);
    }

    @Test
    @Description("Нельзя выполнить поиск билета без указания даты в поле 'Туда'")
    @Feature("Поиск билетов с главной")
    public void incorrectSearchTest() {

        mainPage.assertTitle()
                .findLogo()
                .checkFromInputDisplayed()
                .destinationInputDisplayed()
                .checkStartDateInputDisplayed()
                .checkEndDateInputDisplayed()
                .clickDestinationInput()
                .setDestination(destination)
                .clickDestinationResult()
                .searchSubmitButtonClick()
                .checkStartDateHaveRedBorder();
    }

    @Test
    @Description("Нельзя выполнить поиск бронирования с некорректными данными")
    @Feature("Поиск бронирования")
    public void incorrectBookingSearchTest() {

        mainPage.assertTitle()
                .findLogo()
                .clickBookingControl()
                .setClientSecondName(client)
                .setBookingOrTicketNumber(booking)
                .searchSubmitButtonClick()
                .switchToNewTab();

        searchOrderPage.
                checkNumberInputField()
                .checkClientLastName()
                .checkFindOrderButton()
                .setPersonalDataAgreementCheckbox()
                .findOrderButtonClick()
                .checkInvalidOrderParamError();
    }
}
