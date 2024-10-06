package parent;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import parent.tests.BaseTest;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class PracticeFormTest {
    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "2560x1440";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";
        //Configuration.holdBrowserOpen = true;
        Configuration.timeout = 5000; // default 4000
    }

    @Test
    void fillFormTest() {
        open("/automation-practice-form");
        $("#firstName").setValue("Alexander");
        $("#lastName").setValue("3yd");
        $("#userEmail").setValue("3yd@corp.com");
        $("#genterWrapper").$(byText("Male")).click();
        $("#userNumber").setValue("9169169169");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__year-select").selectOption("2000");
        $(".react-datepicker__month-select").selectOption("March");
        $(".react-datepicker__day.react-datepicker__day--026.react-datepicker__day--weekend").click();
        $("#subjectsInput").setValue("Maths").pressEnter();
        $("#hobbiesWrapper").$(byText("Reading")).click();
        $("#uploadPicture").uploadFile(new File("src/test/resources/reading.jpeg")); //Установка картинки
        $("#currentAddress").setValue("Some street 1");
        $("#react-select-3-input").setValue("NCR").pressEnter(); //Установка штата
        $("#react-select-4-input").setValue("Delhi").pressEnter(); //Установка города
        $("#submit").scrollTo().click();

        $(".table-responsive").shouldHave(
                text("Alexander 3yd"),
                text("3yd@corp.com"),
                text("Male"),
                text("9169169169"),
                text("26 March,2000"),
                text("Maths"),
                text("Reading"),
                text("reading.jpeg"),
                text("Some street 1"),
                text("NCR Delhi")
        );
    }
}
