package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.textCaseSensitive;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RegistrationPage {
    // components
    final private CalendarComponent calendarComponent = new CalendarComponent();
    // locators
    final private SelenideElement
            headerTitle = $(".practice-form-wrapper"),
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            emailInput = $("#userEmail"),
            resultsTable = $(".table-responsive"),
            phoneNumberInput = $("#userNumber"),
            currentAddressInput = $("#currentAddress"),
            submitButton = $("#submit"),
            headerModalTable = $("#example-modal-sizes-title-lg"),
            subjectsInput = $("#subjectsInput"),
            uploadFileInput = $("#uploadPicture"),
            selectStateField = $("#react-select-3-input"),
            selectCityField = $("#react-select-4-input");

    // actions
    public RegistrationPage openPage() {
        open("/automation-practice-form");
        $(".main-header").shouldHave(text("Practice Form"));

        return this;
    }

    public RegistrationPage setFirstName(String firstName) {
        firstNameInput.setValue(firstName);

        return this;
    }

    public RegistrationPage setLastName(String lastName) {
        lastNameInput.setValue(lastName);

        return this;
    }

    public RegistrationPage setEmailInput(String email) {
        emailInput.setValue(email);

        return this;
    }

    public RegistrationPage setGender(String gender) {
        $(byText(gender)).click();

        return this;
    }

    public RegistrationPage setPhoneNumber(String phoneNumber) {
        phoneNumberInput.setValue(phoneNumber);

        return this;
    }

    public RegistrationPage setHobbies(String hobbies) {
        $(byText(hobbies)).click();

        return this;
    }

    public RegistrationPage setCurrentAddress(String currentAddress) {
        currentAddressInput.setValue(currentAddress);

        return this;
    }

    public RegistrationPage pressSubmitButton() {
        submitButton.click();

        return this;
    }

    public RegistrationPage checkHeaderModalTable(String text) {
        headerModalTable.shouldHave((textCaseSensitive("Thanks for submitting the form")));

        return this;
    }

    public RegistrationPage checkForm(String fieldName, String value) {
        resultsTable.$(byText(fieldName))
                .parent().shouldHave(text(value));
        return this;
    }

    public RegistrationPage setBirthDate(String day, String month, String year) {
        $("#dateOfBirthInput").click();
        calendarComponent.setDate(day, month, year);

        return this;
    }

    public RegistrationPage setSubjectsInput(String value) {
        subjectsInput.setValue(value).pressEnter();

        return this;
    }

    public RegistrationPage setUploadFilesInput() {
        File fl = new File("src/test/resources/img/Pic.png");
        uploadFileInput.uploadFile(fl);

        return this;
    }

    public RegistrationPage setState(String stateValue) {
        selectStateField.setValue(stateValue).pressEnter();

        return this;
    }

    public RegistrationPage setCity(String cityValue) {
        selectCityField.setValue(cityValue).pressEnter();

        return this;
    }


}
