package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.*;


public class PracticeFormWithPageObjectsTests {
    @BeforeAll
    static void beforeAll() {
        Configuration.holdBrowserOpen = true;
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
    }

    @Test
    void practiceFormTest(){

            String firstName ="Anna";
            String lastName ="Petrova";
            String email ="anna@gmail.com";
            String mobile ="9166789010";
            String subject1 ="Chemistry";
            String subject2 ="Maths";
            String currentAddress ="Moscow";
            String submitText ="Thanks for submitting the form";

            open("/automation-practice-form");
            executeJavaScript("$('footer').remove()");
            executeJavaScript("$('#fixedban').remove()");

            $("#firstName").setValue(firstName);
            $("#lastName").setValue(lastName);
            $("#userEmail").setValue(email);
            $(byXpath("//*[@id=\"genterWrapper\"]/div[2]/div[2]/label")).click();
            $("#userNumber").setValue(mobile);

            $("#dateOfBirthInput").click();
            $(".react-datepicker__month-select").selectOptionByValue("11");
            $(".react-datepicker__year-select").selectOptionByValue("1991");
            $(byXpath("//*[@id=\"dateOfBirth\"]/div[2]/div[2]/div/div/div[2]/div[2]/div[3]/div[5]")).click();

            $("#subjectsInput").setValue(subject1).pressEnter().setValue(subject2).pressEnter();

            $(byXpath("//*[@id=\"hobbiesWrapper\"]/div[2]/div[1]/label")).click();
            $(byXpath("//*[@id=\"hobbiesWrapper\"]/div[2]/div[3]/label")).click();

            $("#uploadPicture").uploadFile(new File("src/test/data/searchElements.jpg"));

            $("#currentAddress").setValue(currentAddress);
            $("#state").click();
            $("#react-select-3-option-0").click();
            $("#city").click();
            $("#react-select-4-option-1").click();

            $("#submit").click();

            $(".modal-header").shouldHave(text(submitText));
            $(".modal-body").shouldHave(text(firstName), text(lastName), text(email), text("Female"), text(mobile),
                    text("19 December,1991"), text(subject1), text(subject2), text("Sports, Music"), text("searchElements.jpg"), text(currentAddress), text("NCR Gurgaon"));


        }


}
