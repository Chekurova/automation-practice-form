import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class SearchFromGithubTest {

    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://github.com";
    }


    @Test
    void successSearchFromGithubTest() {
        //  - Откройте страницу Selenide в Github
        open("/selenide/selenide");
        // - Перейдите в раздел Wiki проекта
        $("#wiki-tab").click();
        // - Убедитесь, что в списке страниц (Pages) есть страница SoftAssertions
        $("#wiki-pages-filter").setValue("soft");
        $(".filter-bar").sibling(0).shouldHave(exactText("SoftAssertions"));
        // - Откройте страницу SoftAssertions, проверьте что внутри есть пример кода для JUnit5
        $(".filter-bar").sibling(0).$(byText("SoftAssertions")).click();
        // проверьте что внутри есть пример кода для JUnit5
        $("#wiki-body").shouldHave(text("@ExtendWith({SoftAssertsExtension.class})"));
    }
}
