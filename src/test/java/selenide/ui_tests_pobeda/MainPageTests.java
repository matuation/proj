package selenide.ui_tests_pobeda;

import org.junit.jupiter.api.Test;
import selenide.ui_tests_pobeda.pages.MainPage;
import selenide.ui_tests_pobeda.pages.SearchOrderPage;

import static selenide.ui_tests_pobeda.TestData.*;

public class MainPageTests extends TestBase {

    MainPage mainPage = new MainPage();
    SearchOrderPage searchOrderPage = new SearchOrderPage();

    @Test
    public void informationTest() {

        mainPage.assertTitle()
                .findLogo()
                .informationHover()
                .checkPrepareFlightText(prepareFlightExpectedText)
                .checkUsefulInfoText(usefulInfoExpectedText)
                .checkAboutText(aboutPobedaExpectedText);
    }

    @Test
    public void searchTest() {

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
