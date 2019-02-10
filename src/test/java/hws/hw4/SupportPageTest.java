package hws.hw4;

import Base.SelenideBase;
import hws.hw4.ENUMs.CheckboxsList;
import hws.hw4.ENUMs.MainPage;
import hws.hw4.ENUMs.Metals;
import hws.hw4.ENUMs.ServiceListOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.close;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;
import static hws.hw4.ENUMs.RightSectionLogs.*;

public class SupportPageTest extends SelenideBase {
    private SelenideIndexPage JdiIndexPage;
    private SelenideSupportPage JdiSupportPage;

    @BeforeMethod
    public void initTest() {
        // 1 - open JDI home page
        open(MainPage.JDI_PAGE_URL.toString());
        JdiIndexPage = page(SelenideIndexPage.class);
        JdiSupportPage = page(SelenideSupportPage.class);
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

        // 5 - check "Service" subcategories in the header
        JdiIndexPage.expandServiceList();
        JdiIndexPage.verifyDisplayedItems();

        // 6 -  Service subcategories in the left section
        JdiIndexPage.expandLeftServiceList();
        JdiIndexPage.verifyDisplayedItems2();

        // 7 - Navigate to Different Elements Page
        JdiIndexPage.openDifferentPage(ServiceListOptions.ITEM_7.toString());

        // 8 - Different elements page contains all needed elements
        JdiSupportPage.verifyPageElements(4, 4, 2);

        // 9 - verify Right Section Presence
        JdiSupportPage.verifyRightSectionPresence();

        // 10 - verify Left Section Presence
        JdiSupportPage.verifyLeftSectionPresence();

        // 11 - check checkboxs
        JdiSupportPage.selectCheckboxs(CheckboxsList.WATER.toString(), CheckboxsList.WIND.toString());

        //12 - verify logs
        JdiSupportPage.verifyLogs(WATER_TRUE_LOG.toString(), WIND_TRUE_LOG.toString());

        // 13 - Select radio button
        JdiSupportPage.selectRadioButtons(Metals.SELEN.toString());

        // 14 - verify logs
        JdiSupportPage.verifyLogs(SELEN_LOG.toString());

        // 15 - change colour
        JdiSupportPage.selectColor();

        // 16 - verify logs
        JdiSupportPage.verifyLogs(YELLOW_LOG.toString());

        // 17 - unselect checkboxs
        JdiSupportPage.deselectCheckboxs(CheckboxsList.WATER.toString(), CheckboxsList.WIND.toString());

        //18 - verify logs
        JdiSupportPage.verifyLogs(WATER_FALSE_LOG.toString(), WIND_FALSE_LOG.toString());
    }
}
