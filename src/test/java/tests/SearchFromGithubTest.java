package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class SearchFromGithubTest {

    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://github.com";
        Configuration.browserSize = "1512x810";
    }

    @Test
    void successSearchFromGithubTest() {
        //  - Откройте страницу Selenide в Github
        open("/selenide/selenide");
        // - Перейдите в раздел Wiki проекта
        $("a[href=\"/selenide/selenide/wiki\"]").click();
        // - Убедитесь, что в списке страниц (Pages) есть страница SoftAssertions
        $$("div.markdown-body > ul").first().should(have(text("Soft assertions")));
        // - Откройте страницу SoftAssertions, проверьте что внутри есть пример кода для JUnit5
        $x("//a[text()=\"Soft assertions\"]").click();
        // проверьте что внутри есть пример кода для JUnit5
        $("#wiki-body").shouldHave(text("@ExtendWith({SoftAssertsExtension.class})"));
    }
}
