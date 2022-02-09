import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.textCaseSensitive;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;


public class PracticeFormTest {

    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1512x810";
    }

    @Test
    void successRequiredFillTest() {
        open("/automation-practice-form");
        // форма Имени Пароля и почты
        $(".main-header").shouldHave(text("Practice Form"));
        $("#firstName").setValue("Bob");
        $("#lastName").setValue("Alex");
        $("#userEmail").setValue("bobalex@gmail.com");
        // Выбор что ты мужик
        $(byText("Male")).click();
        // Номер телефона
        $("#userNumber").setValue("1234567890");
        Selenide.sleep(2000);
        $(("#submit")).click();

        $("#example-modal-sizes-title-lg").shouldHave((textCaseSensitive("Thanks for submitting the form")));
        $(".table-responsive").shouldHave(
                textCaseSensitive("Student Name"), (textCaseSensitive("Bob Alex")),
                textCaseSensitive("Student Email"), (textCaseSensitive("bobalex@gmail.com")),
                textCaseSensitive("Gender"), (textCaseSensitive("Male")),
                textCaseSensitive("Mobile"), (textCaseSensitive("1234567890"))
        );

    }

    @Test
    void fillAllFieldsTest() {
        open("/automation-practice-form");
        // Name LastName Emai;
        Selenide.$(".main-header").shouldHave(text("Practice Form"));
        Selenide.$("#firstName").setValue("Bob");
        Selenide.$("#lastName").setValue("Alex");
        Selenide.$("#userEmail").setValue("bobalex@gmail.com");
        // Gender
        Selenide.$(byText("Male")).click();
        // Phone namber
        Selenide.$("#userNumber").setValue("1234567890");
        // Calendar
//          setDateById("dateOfBirthInput", "16.02.2000");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOptionByValue("2");
        $(".react-datepicker__year-select").selectOptionByValue("2000");
        $(".react-datepicker__day--016").click();

        // Hobbies
        Selenide.$(byText("Reading")).click();
        Selenide.$(byText("Music")).click();
        // Subjects
        $("#subjectsInput").setValue("Arts").pressEnter();
        // Load file
        File fl = new File("src/test/resources/Pic.png");
        Selenide.$("#uploadPicture").uploadFile(fl);
        //Current Address
        Selenide.$("#currentAddress").setValue("cat dog chicken 15");
        // Select State
        Selenide.$("#react-select-3-input").setValue("Uttar Pradesh").pressEnter();
        // Select City
        Selenide.$("#react-select-4-input").setValue("Agra").pressEnter();
        // Button #submit
        $(("#submit")).click();
        // Asserts
        $("#example-modal-sizes-title-lg").shouldHave((textCaseSensitive("Thanks for submitting the form")));
        $(".table-responsive").shouldHave(
                textCaseSensitive("Student Name"), textCaseSensitive("Bob Alex"),
                textCaseSensitive("Student Email"), textCaseSensitive("bobalex@gmail.com"),
                textCaseSensitive("Gender"), textCaseSensitive("Male"),
                textCaseSensitive("Mobile"), textCaseSensitive("1234567890"),
                textCaseSensitive("Date of Birth"), textCaseSensitive("16 March,2000"),
                textCaseSensitive("Subjects"), textCaseSensitive("Arts"),
                textCaseSensitive("Hobbies"), textCaseSensitive("Reading, Music"),
                textCaseSensitive("Picture"), textCaseSensitive("Pic.png"),
                textCaseSensitive("Address"), textCaseSensitive("cat dog chicken 15"),
                textCaseSensitive("State and City"), textCaseSensitive("Uttar Pradesh Agra")
        );

    }

    void setDateById(String name, String date) {
        executeJavaScript(
                String.format("$('[id=\"%s\"]').val('%s')",
                        name, date)
        );
    }
}
