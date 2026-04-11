package selenide.ui_tests_pobeda;

import org.junit.jupiter.api.BeforeEach;

import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selenide.open;
import static selenide.ui_tests_pobeda.TestData.pobedaUrl;


public class TestBase {

    @BeforeEach
    public void setUp() {
        baseUrl = pobedaUrl;
        open(baseUrl);
    }

}
