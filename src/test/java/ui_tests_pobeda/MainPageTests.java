package ui_tests_pobeda;

import org.junit.jupiter.api.Test;
import ui_tests_pobeda.pages.MainPage;

import static ui_tests_pobeda.TestData.*;

public class MainPageTests extends TestBase {


    @Test
    public void informationTest() {

        MainPage mainPage = new MainPage(driver);

        mainPage.assertTitle()
                .findLogo()
                .informationHover()
                .checkPrepareFlightText(prepareFlightExpectedText)
                .checkUsefulInfoText(usefulInfoExpectedText)
                .checkAboutText(aboutPobedaExpectedText);

    }

    @Test
    public void searchTest() {

        MainPage mainPage = new MainPage(driver);

        mainPage.assertTitle()
                .findLogo()
                .checkFromInputDisplayed()
                .destinationInputDisplayed()
                .checkStartDateInputDisplayed()
                .checkEndDateInputDisplayed()
                .clickDestinationInput()
                .setDestination(destination)
                .clickDestinationResult()
                .searchSubmitButton()
                .checkStartDateHaveRedBorder();
    }
}
