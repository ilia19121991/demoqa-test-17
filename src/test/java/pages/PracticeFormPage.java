package pages;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.selector.ByText;
import pages.components.CalendarComponent;
import pages.components.RegistrationResultsModal;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class PracticeFormPage {
    private final String TITLE_TEXT = "Student Registration Form";
    private CalendarComponent calendarComponent = new CalendarComponent();
    private RegistrationResultsModal registrationResultsModal = new RegistrationResultsModal();

    private final SelenideElement
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            emailInput = $("#userEmail"),
            userNumberInput = $("#userNumber"),
            subjectsInput = $("#subjectsInput"),
            addressInput = $("#currentAddress"),
            genderSelect = $("#genterWrapper"),
            hobbiesSelect = $("#hobbiesWrapper"),
            dateOfBirthInput = $("#dateOfBirthInput"),
            pictureInput = $("#uploadPicture"),
            stateInput = $("#state"),
            stateCitySelect = $("#stateCity-wrapper"),
            cityInput = $("#city"),
            submitButton = $("#submit");



    public PracticeFormPage openPage(){
        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text(TITLE_TEXT));
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");

        return this;
    }

    public PracticeFormPage setFirstName(String value){
        firstNameInput.setValue(value);

        return this;
    }

    public PracticeFormPage setLastName(String value){
        lastNameInput.setValue(value);

        return this;
    }

    public PracticeFormPage clearLastName(){
        lastNameInput.clear();

        return this;
    }

    public PracticeFormPage setEmail(String value){
        emailInput.setValue(value);

        return this;
    }

    public PracticeFormPage setPhone(String value){
        userNumberInput.setValue(value);

        return this;
    }

    public PracticeFormPage setSubjects(String value){
        subjectsInput.setValue(value).pressEnter();

        return this;
    }

    public PracticeFormPage setGender(String value){
        genderSelect.$(byText(value)).click();

        return this;
    }

    public PracticeFormPage setHobbies(String value){
        hobbiesSelect.$(byText(value)).click();

        return this;
    }

    public PracticeFormPage setBirthDate(String day, String month, String year){
        dateOfBirthInput.click();
        calendarComponent.setDate(day, month, year);

        return this;
    }

    public PracticeFormPage addPicture (String value){
        pictureInput.uploadFile(new File(value));

        return this;
    }

    public PracticeFormPage setAddress(String value){
        addressInput.setValue(value);

        return this;
    }

    public PracticeFormPage clickSubmit(){
        submitButton.click();

        return this;
    }

    public PracticeFormPage setState(String value){
        stateInput.click();
        stateCitySelect.$(byText(value)).click();

        return this;
    }

    public PracticeFormPage setCity(String value){
        cityInput.click();
        stateCitySelect.$(byText(value)).click();

        return this;
    }


    public PracticeFormPage verifyResultsModalAppears(){
        registrationResultsModal.verifyModalAppears();

        return this;
    }

    public PracticeFormPage verifyResult(String key, String value){
        registrationResultsModal.verifyResult(key, value);

        return this;
    }

}
