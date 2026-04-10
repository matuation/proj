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
                .checkElement(mainPage.prepareFlightLocator, prepareFlightExpectedText)
                .checkElement(mainPage.usefulInfoLocator, usefulInfoExpectedText)
                .checkElement(mainPage.aboutPobedaLocator, aboutPobedaExpectedText);

    }
}
