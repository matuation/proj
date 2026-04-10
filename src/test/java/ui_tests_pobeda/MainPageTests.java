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
                .checkElementText(mainPage.prepareFlightLocator, prepareFlightExpectedText)
                .checkElementText(mainPage.usefulInfoLocator, usefulInfoExpectedText)
                .checkElementText(mainPage.aboutPobedaLocator, aboutPobedaExpectedText);

    }


//3. Проскроллить страницу к блоку поиска билета и убедиться, что блок с
//    поиском билета действительно отображается (есть поле Откуда,
//                                               Куда, Дата вылета Туда,
//                                               Дата вылета Обратно)
//   4. Выбрать (или ввести) следующие критерии поиска:
//    откуда – Москва (без выбора аэропорта) + нажать Enter
//    куда – Санкт-Петербург + нажать Enter.
//            5. Нажать кнопку «Поиск».
//            6. Убедиться, что около поля «Туда» появилась красная обводка.


    @Test
    public void searchTest() {

        MainPage mainPage = new MainPage(driver);

        mainPage.assertTitle()
                .findLogo()
                .checkElementDisplayed(mainPage.fromInputLocator)
                .checkElementDisplayed(mainPage.destinationInputLocator)
                .checkElementDisplayed(mainPage.startDateInputLocator)
                .checkElementDisplayed(mainPage.endDateInputLocator)
                .clickElement(mainPage.destinationInputLocator)
                .typeInElement(mainPage.destinationInputLocator, destination)
                .clickElement(mainPage.destinationSearchResultLocator)
                .clickElement(mainPage.submitButtonLocator).waitForCssColor(mainPage.failedStartDate, redBorder)
                .checkCssAttrElement(mainPage.failedStartDate, "border-color", redBorder)
        ;

    }
}
