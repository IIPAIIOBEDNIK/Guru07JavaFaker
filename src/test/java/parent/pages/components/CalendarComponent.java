package parent.pages.components;

import static com.codeborne.selenide.Selenide.$;

public class CalendarComponent {
    public void setDay(String day, String month, String year) {
        $(".react-datepicker__year-select").selectOption(year);
        $(".react-datepicker__month-select").selectOption(month);
        $(".react-datepicker__day.react-datepicker__day--0" + day + ".react-datepicker__day--weekend").click();
    }
}
