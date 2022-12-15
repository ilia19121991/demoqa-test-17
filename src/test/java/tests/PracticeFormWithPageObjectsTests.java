package tests;

import com.codeborne.selenide.logevents.SelenideLogger;
import org.junit.jupiter.api.Test;

public class PracticeFormWithPageObjectsTests extends TestBase {


    @Test
    void practiceFormTest(){

        String firstName = "Anna";
        String lastName = "Petrova";
        String email = "anna@gmail.com";
        String gender = "Female";
        String mobile = "9166789010";
        String dayOfBirth = "05";
        String monthOfBirth = "December";
        String yearOfBirth = "1991";
        String dateOfBirth = dayOfBirth + " " + monthOfBirth + "," + yearOfBirth;
        String subject1 = "Chemistry";
        String subject2 = "Maths";
        String hobby1 = "Sports";
        String hobby2 = "Music";
        String picturePath = "searchElements.jpg";
        String pictureName = "searchElements.jpg";
        String currentAddress = "Moscow";
        String state = "NCR";
        String city = "Gurgaon";


        practiceFormPage.openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(email)
                .setGender(gender)
                .setPhone(mobile)
                .setBirthDate(dayOfBirth, monthOfBirth, yearOfBirth)
                .setSubjects(subject1)
                .setSubjects(subject2)
                .setHobbies(hobby1)
                .setHobbies(hobby2)
                .addPicture(picturePath)
                .setAddress(currentAddress)
                .setState(state)
                .setCity(city)
                .clickSubmit();

        practiceFormPage.verifyResultsModalAppears()
                .verifyResult("Student Name", firstName + " " + lastName)
                .verifyResult("Student Email", email)
                .verifyResult("Gender", gender)
                .verifyResult("Mobile", mobile)
                .verifyResult("Date of Birth", dateOfBirth)
                .verifyResult("Subjects", subject1 + ", " + subject2)
                .verifyResult("Hobbies", hobby1 + ", " + hobby2)
                .verifyResult("Picture", pictureName)
                .verifyResult("Address", currentAddress)
                .verifyResult("State and City", state + " " + city);


    }

}



