import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;


public class PracticeFormTests {
    RegistrationPage registraionPage = new RegistrationPage();


    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1512x810";
    }


    @Test
    void successRequiredFillTest() {
        registraionPage.openPage();

        registraionPage.setFirstName("Bob")
                .setLastName("Alex")
                .setEmailInput("bobalex@gmail.com")
                .setGender("Male")
                .setPhoneNumber("1234567890")
                .setBirthDate("20", "March", "2000")
                .setHobbies("Reading")
                .setHobbies("Music")
                .setSubjectsInput("Arts")
                .setUploadFilesInput()
                .setCurrentAddress("cat dog chicken 15")
                .setState("Uttar Pradesh")
                .setCity("Agra")
                .pressSubmitButton();

        registraionPage.checkHeaderModalTable("Thanks for submitting the form")
                .checkForm("Student Name", "Bob Alex")
                .checkForm("Student Email", "bobalex@gmail.com")
                .checkForm("Gender", "Male")
                .checkForm("Mobile", "1234567890")
                .checkForm("Date of Birth", "20 March,2000")
                .checkForm("Subjects", "Arts")
                .checkForm("Hobbies", "Reading, Music")
                .checkForm("Picture", "Pic.png")
                .checkForm("State and City", "Uttar Pradesh Agra")
                .checkForm("Address", "cat dog chicken 15");
    }
}
