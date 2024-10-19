package parent.tests;

import org.junit.jupiter.api.Test;
import parent.pages.RegistrationPage;
import parent.utils.homework.RandomStudentData;

import java.util.*;

public class PracticeFormOOPTest extends BaseTest {
    RandomStudentData randomStudentData = new RandomStudentData();
    RegistrationPage registrationPage = new RegistrationPage();
    String firstName = randomStudentData.getFirstName();
    String lastName = randomStudentData.getLastName();
    String userEmail = randomStudentData.getUserEmail();
    String gender = randomStudentData.getGender();
    String userNumber = randomStudentData.getUserNumber();
    Date dateOfBirthday = randomStudentData.getDateOfBirth();
    String dayOfBirth = randomStudentData.getDayOfBirth(dateOfBirthday);
    String monthOfBirth = randomStudentData.getMonthOfBirth(dateOfBirthday);
    String yearOfBirth = randomStudentData.getYearOfBirth(dateOfBirthday);
    String subject = randomStudentData.getSubject();
    String hobbies = randomStudentData.getHobbies();
    String pictureWay = randomStudentData.getWayPicture();
    String pictureName = randomStudentData.getNamePicture();
    String address = randomStudentData.getAddress();
    String state = randomStudentData.getState();
    String city = randomStudentData.getCity(state);

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
