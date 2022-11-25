package tests;

import com.codeborne.selenide.selector.ByText;
import org.junit.jupiter.api.Test;
import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;


public class PracticeFormWithPageObjectsTests extends TestBase {


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

        practiceFormPage.openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(email)
                .setGender("Female")
                .setPhone(mobile)
                .setSubjects(subject1)
                .setSubjects(subject2)
                .setBirthDate("05","December","1991");


        practiceFormPage.verifyResultsModalAppears()
                .verifyResult("Student Name", firstName + " " + lastName)
                .verifyResult("Student Email", email)
                .verifyResult("Gender", "Female")
                .verifyResult("Mobile", mobile)
                .verifyResult("Date of Birth", "05 December,1991")
                .verifyResult("Subjects", "Chemistry, Maths")
                .verifyResult("Hobbies", "Sports, Music")
                .verifyResult("Picture", "searchElements.jpg")
                .verifyResult("Address", currentAddress)
                .verifyResult("State and City", "NCR Gurgaon");



        $("#firstName").setValue(firstName);
        $("#lastName").setValue(lastName);
        $("#userEmail").setValue(email);
        $("#genterWrapper").$(new ByText("Female")).click();
        $("#userNumber").setValue(mobile);


        $("#subjectsInput").setValue(subject1).pressEnter().setValue(subject2).pressEnter();

        $("#hobbiesWrapper").$(new ByText("Sports")).click();
        $("#hobbiesWrapper").$(new ByText("Music")).click();

        $("#uploadPicture").uploadFile(new File("src/test/data/searchElements.jpg"));

        $("#currentAddress").setValue(currentAddress);
        $("#state").click();
        $("#stateCity-wrapper").$(new ByText("NCR")).click();
        $("#city").click();
        $("#stateCity-wrapper").$(new ByText("Gurgaon")).click();

        $("#submit").click();

        $(".modal-header").shouldHave(text(submitText));
        $(".modal-body").shouldHave(text(firstName), text(lastName), text(email), text("Female"), text(mobile),
                text("05 December,1991"), text(subject1), text(subject2), text("Sports, Music"), text("searchElements.jpg"), text(currentAddress), text("NCR Gurgaon"));
        $(".modal-body").shouldNotHave(text("Reading"));

    }

}



