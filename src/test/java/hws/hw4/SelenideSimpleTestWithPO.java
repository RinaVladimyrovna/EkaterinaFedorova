package hws.hw4;

import Base.SelenideBase;
import com.codeborne.selenide.Selenide;
import hws.hw4.ENUMs.CheckboxsList;
import hws.hw4.ENUMs.MainPage;
import hws.hw4.ENUMs.Metals;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.close;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;
import static hws.hw4.ENUMs.RightSectionLogs.*;

public class SelenideSimpleTestWithPO extends SelenideBase {
    private SelenideIndexPage JdiIndexPage;

    @BeforeMethod
    public void initTest(){
        // 1 - open JDI home page
        open(MainPage.JDI_PAGE_URL.toString());
        JdiIndexPage = page(SelenideIndexPage.class);
    }

    @AfterMethod
    public void closeTab(){
        close();
    }

    @Test
    public void SimpleTest(){
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
        JdiIndexPage.openDifferentElementsPage();

        // 8 - Different elements page contains all needed elements
        JdiIndexPage.verifyPageElements(4, 4, 2);

        // 9 - verify Right Section Presence
        JdiIndexPage.verifyRightSectionPresence();

        // 10 - verify Left Section Presence
        JdiIndexPage.verifyLeftSectionPresence();

        // 11 - check checkboxs
        JdiIndexPage.selectCheckboxs(CheckboxsList.WATER.toString(), CheckboxsList.WIND.toString());

        //12 - verify logs
        JdiIndexPage.verifyLogs(WATER_TRUE_LOG.toString(), WIND_TRUE_LOG.toString());

        // 13 - Select radio button
        JdiIndexPage.selectRadioButtons(Metals.SELEN.toString());

        // 14 - verify logs
        JdiIndexPage.verifyLogs(SELEN_LOG.toString());

        // 15 - change colour
        JdiIndexPage.selectColor();

        // 16 - verify logs
        JdiIndexPage.verifyLogs(YELLOW_LOG.toString());

        // 17 - unselect checkboxs
        JdiIndexPage.deselectCheckboxs(CheckboxsList.WATER.toString(), CheckboxsList.WIND.toString());

        //18 - verify logs
        JdiIndexPage.verifyLogs(WATER_FALSE_LOG.toString(), WIND_FALSE_LOG.toString());
    }
}
