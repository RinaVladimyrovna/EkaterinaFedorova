package hws.hw4;

import Base.SelenideBase;
import hws.hw4.ENUMs.*;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.close;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;
import static hws.hw4.ENUMs.CheckboxsList.*;
import static hws.hw4.ENUMs.Metals.*;
import static hws.hw4.ENUMs.RightSectionLogs.*;

public class SupportPageTest extends SelenideBase {
    private SelenideIndexPage jdiIndexPage;
    private SelenideSupportPage jdiSupportPage;

    @BeforeMethod
    public void initTest() {
        // 1 - open JDI home page
        open(MainPage.JDI_PAGE_URL.toString());
        jdiIndexPage = page(SelenideIndexPage.class);
        jdiSupportPage = page(SelenideSupportPage.class);
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

        // 5 - check "Service" subcategories in the header
        jdiIndexPage.expandServiceList();
        jdiIndexPage.verifyDisplayedItems();

        // 6 -  Service subcategories in the left section
        jdiIndexPage.expandLeftServiceList();
        jdiIndexPage.verifyDisplayedItems2();

        // 7 - Navigate to Different Elements Page
        jdiIndexPage.openDifferentPage(ServiceListOptions.DIFFERENT_ELEMENTS_PAGE_LINK);

        // 8 - Different elements page contains all needed elements
        jdiSupportPage.verifyPageElements();

        // 9 - verify Right Section Presence
        jdiSupportPage.verifyRightSectionPresence();

        // 10 - verify Left Section Presence
        jdiSupportPage.verifyLeftSectionPresence();

        // 11 - check checkboxs
        jdiSupportPage.selectCheckboxs(WATER, WIND);

        //12 - verify logs
        jdiSupportPage.verifyLogs(WATER_TRUE_LOG, WIND_TRUE_LOG);

        // 13 - Select radio button
        jdiSupportPage.selectRadioButtons(SELEN);

        // 14 - verify logs
        jdiSupportPage.verifyLogs(SELEN_LOG);

        // 15 - change colour
        jdiSupportPage.selectColor(Colors.YELLOW);

        // 16 - verify logs
        jdiSupportPage.verifyLogs(YELLOW_LOG);

        // 17 - unselect checkboxs
        jdiSupportPage.deselectCheckboxs(WATER, WIND);

        //18 - verify logs
        jdiSupportPage.verifyLogs(WATER_FALSE_LOG, WIND_FALSE_LOG);
    }
}
