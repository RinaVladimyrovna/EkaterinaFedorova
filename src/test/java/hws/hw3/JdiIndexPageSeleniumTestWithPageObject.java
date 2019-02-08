package hws.hw3;

import hws.hw3.ENUMs.LoggingIn;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static hws.hw3.ENUMs.MainPage.*;
import static hws.hw3.ENUMs.NavigationPanel.NAVIGATION;

public class JdiIndexPageSeleniumTestWithPageObject {
    // TODO This is NOT the browser
    // Done. Changed to JdiIndexPage.
    private JdiIndexPage JdiIndexPage;

    @BeforeMethod
    public void beforeMethod() {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(10000, TimeUnit.MILLISECONDS);
        JdiIndexPage = PageFactory.initElements(driver, JdiIndexPage.class);
    }

    @Test
    public void simpleTest() {

        //1 - Open test site by URL
        JdiIndexPage.openJdiPage(JDI_PAGE_URL);

        //2 - Assert Browser title
        JdiIndexPage.verifyPageTitle(MAIN_PAGE_TITLE);

        //3 - Perform login
        JdiIndexPage.logIn(LoggingIn.USER);

        // 4 - Assert User name
        JdiIndexPage.verifyUserName(LoggingIn.USER);

        //5 - Assert Browser title
        JdiIndexPage.verifyPageTitle(MAIN_PAGE_TITLE);

        //6 - there are 4 items on the header section
        JdiIndexPage.verifyHeaderSectionItems(NAVIGATION);

        //7 - there are 4 displayed images on the Index Page
        JdiIndexPage.verifyDisplayedImages();

        // TODO You can separate one big enum to several pieces.
        // TODO Take a look on enum default methods, you can take the whole data at once.
        // Done. Idea suggested to make enum class reference within the method.
        // Sounded good enough.
        //8 - there are 4 proper texts on the Index Page under icons
        JdiIndexPage.verifyImageTexts();

        //9 - Assert a text of the main headers
        JdiIndexPage.verifyHeaderTexts(MAIN_HEADER_TEXT, LOREM_IPSUM_TEXT);

        //10 - The iframe exists
        // TODO Method within assertion should have prefix check/verify or similar.
        // Done.
        JdiIndexPage.verifyIframePresence();

        //11 - there is Epam logo in the left top conner of iframe
        JdiIndexPage.verifyIframeLogoIsDisplayed();

        //12 - Switch to original window back
        JdiIndexPage.switchToMainScreen();

        //13 - Assert a text of the sub header
        JdiIndexPage.verifySubHeaderText(SUB_HEADER_TEXT);

        //14 - JDI GITHUB is a link and has a proper URL
        JdiIndexPage.verifyLink(LINK_URL);

        //15 - there is Left Section
        JdiIndexPage.verifyLeftSection();

        //16 - Assert that there is Footer
        JdiIndexPage.verifyFooter();

        //17 - close browser
        JdiIndexPage.close();
    }
}
