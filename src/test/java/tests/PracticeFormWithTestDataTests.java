package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$;
import static tests.TestData.*;

public class PracticeFormWithTestDataTests {

  /* static String firstName,
            lastName,
            email*/



    @BeforeAll
    static void beforeAll() {

       /* firstName ="Anna";
        lastName ="Petrova";
        email ="anna@gmail.com";*/

        Configuration.holdBrowserOpen = true;
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
    }

    @BeforeEach
    void BeforeEach(){
       /* firstName = getNewFirstName();
        lastName = getNewLastName();
        email = getNewEmail();*/
    }

    @Test
    void practiceFormTest(){
        String mobile ="9166789010",
                subject1 ="Chemistry",
                subject2 ="Maths",
                currentAddress ="Moscow";


        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");

        $("#firstName").setValue(firstName);
        $("#lastName").setValue(lastName);
        $("#userEmail").setValue(email);
        $("#genterWrapper").$(byText("Female")).click();
        $("#userNumber").setValue(mobile);

        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("December");
        $(".react-datepicker__year-select").selectOption("1991");
        $(".react-datepicker__day--005:not(.react-datepicker__day--outside-month)").click();


        $("#subjectsInput").setValue(subject1).pressEnter().setValue(subject2).pressEnter();

        $("#hobbiesWrapper").$(byText("Sports")).click();
        $("#hobbiesWrapper").$(byText("Music")).click();

        $("#uploadPicture").uploadFile(new File("src/test/resources/searchElements.jpg"));

        $("#currentAddress").setValue(currentAddress);
        $("#state").click();
        $("#stateCity-wrapper").$(byText("NCR")).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText("Gurgaon")).click();

        $("#submit").click();

        $(".modal-dialog").should(appear);
        $(".modal-header").shouldHave(text("Thanks for submitting the form"));

        $(".modal-body").shouldHave(text(firstName), text(lastName), text(email), text("Female"), text(mobile),
                text("05 December,1991"), text(subject1), text(subject2), text("Sports, Music"), text("searchElements.jpg"), text(currentAddress), text("NCR Gurgaon"));
        $(".modal-body").shouldNotHave(text("Reading"));

    }
}
