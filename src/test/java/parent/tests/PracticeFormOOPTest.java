package parent.tests;

import org.junit.jupiter.api.Test;
import parent.pages.RegistrationPage;
import parent.utils.homework.RandomUtils;

public class PracticeFormOOPTest extends BaseTest {
    RandomUtils randomUtils = new RandomUtils();
    String firstName = randomUtils.getFirstName();
    String lastName = randomUtils.getLastName();
    String userEmail = randomUtils.getUserEmail();
    String gender = randomUtils.getGender();
    String userNumber = randomUtils.getUserNumber();
    String dayOfBirth = randomUtils.getDayOfBirth();
    String monthOfBirth = randomUtils.getMonthOfBirth();
    String yearOfBirth = randomUtils.getYearOfBirth();
    String subject = randomUtils.getSubject();
    String hobbies = randomUtils.getHobbies();
    String pictureWay = "src/test/resources/reading.jpeg";
    String pictureName = "reading.jpeg";
    String address = randomUtils.getAddress();
    String state = randomUtils.getState();
    String city = randomUtils.getCity(state);
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
