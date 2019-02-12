package hws.hw3;

import hws.hw3.ENUMs.Users;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static hws.hw3.ENUMs.MainPage.*;
import static hws.hw3.ENUMs.NavigationPanel.NAVIGATION;
import static hws.hw3.ENUMs.Users.*;

public class JdiIndexPageSeleniumTestWithPageObject {
    // TODO Pay attention on naming convention
    private JdiIndexPage jdiIndexPage;

    @BeforeMethod
    public void beforeMethod() {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(10000, TimeUnit.MILLISECONDS);
        jdiIndexPage = PageFactory.initElements(driver, JdiIndexPage.class);
    }

    @Test
    public void simpleTest() {

        //1 - Open test site by URL
        jdiIndexPage.openJdiPage(JDI_PAGE_URL);

        //2 - Assert Browser title
        jdiIndexPage.verifyPageTitle(MAIN_PAGE_TITLE);

        //3 - Perform login
        jdiIndexPage.logIn(PITER);

        // 4 - Assert User name
        jdiIndexPage.verifyUserName(PITER);

        //5 - Assert Browser title
        jdiIndexPage.verifyPageTitle(MAIN_PAGE_TITLE);

        //6 - there are 4 items on the header section
        jdiIndexPage.verifyHeaderSectionItems(NAVIGATION);

        //7 - there are 4 displayed images on the Index Page
        jdiIndexPage.verifyDisplayedImages();

        //8 - there are 4 proper texts on the Index Page under icons
        jdiIndexPage.verifyImageTexts();

        //9 - Assert a text of the main headers
        jdiIndexPage.verifyHeaderTexts(MAIN_HEADER_TEXT, LOREM_IPSUM_TEXT);

        //10 - The iframe exists
        jdiIndexPage.verifyIframePresence();

        //11 - there is Epam logo in the left top conner of iframe
        jdiIndexPage.verifyIframeLogoIsDisplayed();

        //12 - Switch to original window back
        jdiIndexPage.switchToMainScreen();

        //13 - Assert a text of the sub header
        jdiIndexPage.verifySubHeaderText(SUB_HEADER_TEXT);

        //14 - JDI GITHUB is a link and has a proper URL
        jdiIndexPage.verifyLink(LINK_URL);

        //15 - there is Left Section
        jdiIndexPage.verifyLeftSection();

        //16 - Assert that there is Footer
        jdiIndexPage.verifyFooter();

        //17 - close browser
        jdiIndexPage.close();
    }
}
