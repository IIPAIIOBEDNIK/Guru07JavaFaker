package parent.tests;

import org.junit.jupiter.api.Test;
import parent.pages.RegistrationPage;

public class PracticeFormOOPTest extends BaseTest {
    String firstName = "Alexander";
    String lastName = "3yd";
    String userEmail = "3yd@corp.com";
    String gender = "Male";
    String userNumber = "9169169169";
    String dayOfBirth = "26";
    String monthOfBirth = "March";
    String yearOfBirth = "2000";
    String subject = "Math";
    String hobbies = "Reading";
    String pictureWay = "src/test/resources/reading.jpeg";
    String pictureName = "reading.jpeg";
    String address = "Some street 1";
    String state = "NCR";
    String city = "Delhi";
    RegistrationPage registrationPage = new RegistrationPage();

    @Test
    void successfulRegistrationTest() {
        registrationPage.openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setUserEmail(userEmail)
                .setGender(gender)
                .setUserNumber(userNumber)
                .setDateOfBirth(dayOfBirth, monthOfBirth, yearOfBirth)
                .setSubject(subject)
                .setHobbies(hobbies)
                .setPicture(pictureWay)
                .setAddress(address)
                .setState(state)
                .setCity(city)
                .clickSubmit();

        registrationPage.checkResult("Student Name",firstName + " " + lastName)
                .checkResult("Student Email", userEmail)
                .checkResult("Gender", gender)
                .checkResult("Mobile", userNumber)
                .checkResult("Date of Birth", dayOfBirth)
                .checkResult("Subjects", subject)
                .checkResult("Hobbies", hobbies)
                .checkResult("Picture", pictureName)
                .checkResult("Address", address)
                .checkResult("State and City", state + " " + city);
    }

    @Test
    void successfulRegistrationRequiredFieldsTest() {
        registrationPage.openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setGender(gender)
                .setUserNumber(userNumber)
                .clickSubmit();

        registrationPage.checkResult("Student Name", firstName + " " + lastName)
                .checkResult("Gender", gender)
                .checkResult("Mobile", userNumber);
    }

    @Test
    void RegistrationNegativeTest() {
        registrationPage.openPage()
                .clickSubmit();

        registrationPage.checkNegativeResult();
    }
}
