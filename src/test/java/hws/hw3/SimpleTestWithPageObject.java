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

public class SimpleTestWithPageObject {
    private SimplePageObject browser;

    @BeforeMethod
    public void beforeMethod() {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(10000, TimeUnit.MILLISECONDS);
        browser = PageFactory.initElements(driver, SimplePageObject.class);
    }

    @Test
    public void simpleTest() {

        //1 - Open test site by URL
        browser.openJdiPage(JDI_PAGE_URL);

        //2 - Assert Browser title
        browser.verifyPageTitle(MAIN_PAGE_TITLE);

        //3 - Perform login
        browser.logIn(LoggingIn.USER);

        // 4 - Assert User name
        browser.verifyUserName(LoggingIn.USER);

        //5 - Assert Browser title
        browser.verifyPageTitle(MAIN_PAGE_TITLE);

        //6 - there are 4 items on the header section
        browser.verifyHeaderSectionItems(NAVIGATION);

        //7 - there are 4 displayed images on the Index Page
        browser.verifyDisplayedImages();

        //8 - there are 4 proper texts on the Index Page under icons
        browser.verifyImageTexts(ICON_TEXT_1, ICON_TEXT_2, ICON_TEXT_3, ICON_TEXT_4);

        //9 - Assert a text of the main headers
        browser.verifyHeaderTexts(MAIN_HEADER_TEXT, LOREM_IPSUM_TEXT);

        //10 - The iframe exists
        browser.iFrame();

        //11 - there is Epam logo in the left top conner of iframe
        browser.iFrameLogo();

        //12 - Switch to original window back
        browser.mainScreen();

        //13 - Assert a text of the sub header
        browser.subHeaderText(SUB_HEADER_TEXT);

        //14 - JDI GITHUB is a link and has a proper URL
        browser.verifyLink(LINK_URL);

        //15 - there is Left Section
        browser.verifyLeftSection();

        //16 - Assert that there is Footer
        browser.verifyFooter();

        //17 - close browser
        browser.close();
    }
}
