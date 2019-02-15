package hws.hw5;

import Base.SelenideBase;
import hws.hw5.ENUMs.*;
import io.qameta.allure.Feature;
import io.qameta.allure.Step;
import io.qameta.allure.Story;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.*;
import static hws.hw5.ENUMs.RightSectionLogs.*;

@Feature("Support page UI and functionality")
public class SupportPageTest extends SelenideBase {
    private SelenideIndexPage jdiIndexPage;
    private SelenideSupportPage jdiSupportPage;

    @BeforeMethod
    @Step("Open browser on JDI home page")
    public void initTest() {
        // 1 - open JDI home page
        open(MainPage.JDI_PAGE_URL.toString());
        jdiIndexPage = page(SelenideIndexPage.class);
        jdiSupportPage = page(SelenideSupportPage.class);
    }

    @AfterMethod
    @Step("Close browser")
    public void closeTab() {
        close();
    }

    @Test
    @Story("Support page has checkbox, radio-buttons, drop-down and log section")
    public void SimpleTest() {
        // 2 - check tab title
        jdiIndexPage.verifyPageTitle();

        // 3 - log in
        // TODO Parameter ?
        // Done
        jdiIndexPage.logIn(Users.PITER);

        // 4 - check user name
        // TODO Parameter ?
        // Done
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
        jdiSupportPage.selectCheckboxs(CheckboxsList.WATER, CheckboxsList.WIND);

        //12 - verify logs
        jdiSupportPage.verifyLogs(WATER_TRUE_LOG, WIND_TRUE_LOG);

        // 13 - Select radio button
        jdiSupportPage.selectRadioButtons(Metals.SELEN);

        // 14 - verify logs
        jdiSupportPage.verifyLogs(SELEN_LOG);

        // 15 - change colour
        jdiSupportPage.selectColor(Colors.YELLOW);

        // 16 - verify logs
        jdiSupportPage.verifyLogs(YELLOW_LOG);

        // 17 - unselect checkboxs
        jdiSupportPage.deselectCheckboxs(CheckboxsList.WATER, CheckboxsList.WIND);

        //18 - verify logs
        jdiSupportPage.verifyLogs(WATER_FALSE_LOG, WIND_FALSE_LOG);
    }
}
