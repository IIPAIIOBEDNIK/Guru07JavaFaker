package parent.utils.homework;

import com.github.javafaker.Faker;

import java.text.SimpleDateFormat;
import java.util.*;

public class RandomStudentData {
    Faker faker = new Faker(new Locale("en-GB"));
    SimpleDateFormat formatterDay = new SimpleDateFormat("dd");
    SimpleDateFormat formatterMonth = new SimpleDateFormat("MMMM", Locale.ENGLISH);
    SimpleDateFormat formatterYear = new SimpleDateFormat("yyyy");


    public String getFirstName() {
        return faker.name().firstName();
    }

    public String getLastName() {
        return faker.name().lastName();
    }

    public String getUserEmail() {
        return faker.internet().emailAddress();
    }

    public String getGender() {
        return faker.options().option("Male", "Female", "Other");
    }

    public String getUserNumber() {
        return faker.phoneNumber().subscriberNumber(10);
    }

    public Date getDateOfBirth(){
        return faker.date().birthday();
    }

    public String getWayPicture() {
        return faker.options().option("src/test/resources/reading.jpeg");
    }

    public String getNamePicture() {
        return faker.options().option("reading.jpeg");
    }

    public String getDayOfBirth(Date dateOfBirthday) {
        return formatterDay.format(dateOfBirthday);
    }

    public String getMonthOfBirth(Date dateOfBirthday) {
        return formatterMonth.format(dateOfBirthday);
    }

    public String getYearOfBirth(Date dateOfBirthday) {
        return formatterYear.format(dateOfBirthday);
    }

    public String getSubject() {
        return faker.options().option("History", "Maths", "English", "Arts", "Economics");
    }

    public String getHobbies() {
        return faker.options().option("Sports", "Reading", "Music");
    }

    public String getAddress() {
        return faker.address().fullAddress();
    }

    public String getState() {
        return faker.options().option("NCR", "Haryana", "Uttar Pradesh");
    }

    public String getCity(String state) {
        if ("NCR".equals(state)) {
            return faker.options().option("Delhi", "Gurgaon", "Noida");
        } else if ("Uttar Pradesh".equals(state)) {
            return faker.options().option("Agra", "Lucknow", "Merrut");
        } else {
            return faker.options().option("Karnal", "Panipat");
        }
    }
}
