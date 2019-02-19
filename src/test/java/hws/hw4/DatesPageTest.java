package hws.hw4;

import Base.SelenideBase;
import hws.hw4.ENUMs.MainPage;
import hws.hw4.ENUMs.ServiceListOptions;
import hws.hw4.ENUMs.Users;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.close;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;
import static hws.hw4.ENUMs.Sliders.*;

public class DatesPageTest extends SelenideBase {

    private SelenideIndexPage jdiIndexPage;
    private SelenideDatesPage jdiDatesPage;

    @BeforeMethod
    public void initTest() {
        // 1 - open JDI home page
        open(MainPage.JDI_PAGE_URL.toString());
        jdiIndexPage = page(SelenideIndexPage.class);
        jdiDatesPage = page(SelenideDatesPage.class);
    }

    @AfterMethod
    public void closeTab() {
        close();
    }

    @Test
    public void SimpleTest() {
        // 2 - check tab title
        jdiIndexPage.verifyPageTitle();

        // 3 - log in
        jdiIndexPage.logIn(Users.PITER);

        // 4 - check user name
        jdiIndexPage.verifyUserName(Users.PITER);

        // 5 - Navigate to Different Elements Page
        jdiIndexPage.openDifferentPage(ServiceListOptions.DATES_PAGE_LINK);

        // 6 - Move sliders to 0 and 100
        jdiDatesPage.moveASlider(LEFT_SLIDER, 0);
        jdiDatesPage.moveASlider(RIGHT_SLIDER, 100);

        // 7 - check log records for slider movements
        jdiDatesPage.verifyLogs(0);
        jdiDatesPage.verifyLogs(100);

        // 8 - Move to 0 and 0
        jdiDatesPage.moveASlider(LEFT_SLIDER, 0);
        jdiDatesPage.moveASlider(RIGHT_SLIDER, 0);

        // 9 - check log records for slider movements
        jdiDatesPage.verifyLogs(0);
        jdiDatesPage.verifyLogs(0);

        // 10 - Move to 100 and 100
        jdiDatesPage.moveASlider(RIGHT_SLIDER, 100);
        jdiDatesPage.moveASlider(LEFT_SLIDER, 100);

        // 11 - check log records for slider movements
        jdiDatesPage.verifyLogs(100);
        jdiDatesPage.verifyLogs(100);

        // 12 - Move to 30 and 70
        jdiDatesPage.moveASlider(LEFT_SLIDER, 30);
        jdiDatesPage.moveASlider(RIGHT_SLIDER, 70);

        // 14 - check log records for slider movements
        jdiDatesPage.verifyLogs(30);
        jdiDatesPage.verifyLogs(70);
    }

}
