package hws.hw4;

import Base.SelenideBase;
import hws.hw4.ENUMs.MainPage;
import hws.hw4.ENUMs.ServiceListOptions;
import hws.hw4.ENUMs.SlidersShift;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.close;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;
import static hws.hw4.ENUMs.SlidersShift.*;

public class DatesPageTest extends SelenideBase {

    // TODO Naming convention !
    private SelenideIndexPage JdiIndexPage;
    private SelenideDatesPage JdiDatesPage;

    @BeforeMethod
    public void initTest() {
        // 1 - open JDI home page
        open(MainPage.JDI_PAGE_URL.toString());
        JdiIndexPage = page(SelenideIndexPage.class);
        JdiDatesPage = page(SelenideDatesPage.class);
    }

    @AfterMethod
    public void closeTab() {
        close();
    }

    @Test
    public void SimpleTest() {
        // 2 - check tab title
        JdiIndexPage.verifyPageTitle();

        // 3 - log in
        JdiIndexPage.logIn();

        // 4 - check user name
        JdiIndexPage.verifyUserName();

        // 5 - Navigate to Different Elements Page
        JdiIndexPage.openDifferentPage(ServiceListOptions.ITEM_2.toString());

        // 6 - Move sliders to 0 and 100
        JdiDatesPage.moveASlider(LEFT_SLIDER.toString(), SHIFT_0.toString());
        JdiDatesPage.moveASlider(RIGHT_SLIDER.toString(), SHIFT_100.toString());
        System.out.println(6);

        // 7 - check log records for slider movements
        JdiDatesPage.verifyLogs(SHIFT_0.toString());
        JdiDatesPage.verifyLogs(SHIFT_100.toString());

        // 8 - Move to 0 and 0
        JdiDatesPage.moveASlider(LEFT_SLIDER.toString(), SHIFT_0.toString());
        JdiDatesPage.moveASlider(RIGHT_SLIDER.toString(), SHIFT_0.toString());
        System.out.println(8);

        // 9 - check log records for slider movements
        JdiDatesPage.verifyLogs(SHIFT_0.toString());
        JdiDatesPage.verifyLogs(SHIFT_0.toString());

        // 10 - Move to 100 and 100
        JdiDatesPage.moveASlider(RIGHT_SLIDER.toString(), SHIFT_100.toString());
        JdiDatesPage.moveASlider(LEFT_SLIDER.toString(), SHIFT_100.toString());
        System.out.println(10);

        // 11 - check log records for slider movements
        JdiDatesPage.verifyLogs(SHIFT_100.toString());
        JdiDatesPage.verifyLogs(SHIFT_100.toString());

        // 12 - Move to 30 and 70
        JdiDatesPage.moveASlider(LEFT_SLIDER.toString(), SHIFT_30.toString());
        JdiDatesPage.moveASlider(RIGHT_SLIDER.toString(), SHIFT_70.toString());
        System.out.println(12);

        // 14 - check log records for slider movements
        JdiDatesPage.verifyLogs(SHIFT_30.toString());
        JdiDatesPage.verifyLogs(SHIFT_70.toString());
    }

}
