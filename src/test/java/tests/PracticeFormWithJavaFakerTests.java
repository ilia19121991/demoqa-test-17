package tests;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;
import utils.RandomUtils;

import java.util.Calendar;
import java.util.Locale;

public class PracticeFormWithJavaFakerTests extends TestBase {
    Faker faker = new Faker(new Locale("en", "US"));


    @Test
    void practiceFormTest(){
        String subjects [] = {"Chemistry", "Maths", "Arts", "English"},
                hobbies [] = {"Sports", "Reading", "Music"},
                months [] = {"January", "February", "March", "April", "May", "June", "July",
                        "August", "September", "October", "November", "December"};

        String firstName = faker.name().firstName(),
                lastName = faker.name().lastName(),
                email = faker.internet().emailAddress(),
                gender = faker.demographic().sex(),
                mobile = faker.phoneNumber().subscriberNumber(10),
                dayOfBirth = String.valueOf(faker.number().numberBetween(10,28)),
                monthOfBirth = randomListItem(months),
                yearOfBirth = String.valueOf(faker.number().numberBetween(1900,2005)),
                dateOfBirth = dayOfBirth + " " + monthOfBirth + "," + yearOfBirth,
                subject = randomListItem(subjects),
                hobby = randomListItem(hobbies),
                picturePath = "src/test/resources/searchElements.jpg",
                pictureName = "searchElements.jpg",
                currentAddress = faker.address().fullAddress(),
                state = "NCR",
                city = "Gurgaon";


        practiceFormPage.openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(email)
                .setGender(gender)
                .setPhone(mobile)
                .setBirthDate(dayOfBirth, monthOfBirth, yearOfBirth)
                .setSubjects(subject)
                .setHobbies(hobby)
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
                .verifyResult("Subjects", subject)
                .verifyResult("Hobbies", hobby)
                .verifyResult("Picture", pictureName)
                .verifyResult("Address", currentAddress)
                .verifyResult("State and City", state + " " + city);

    }

}



