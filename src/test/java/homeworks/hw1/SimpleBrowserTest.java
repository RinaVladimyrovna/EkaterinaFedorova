package homeworks.hw1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

// TODO Code convention, reformat your code via IDEA
public class SimpleBrowserTest {

    private WebDriver driver;

    @BeforeMethod
    public void beforeMethod() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(10000, TimeUnit.MILLISECONDS);
    }

    @Test
    public void  simpleTest() {

        //1 - Open test site by URL

        driver.navigate().to("https://epam.github.io/JDI/");

        //2 - Assert Browser title

        assertEquals(driver.getTitle(), "Home Page");

        //3 - Perform login

        driver.findElement(By.cssSelector("[id='user-icon']")).click();
        driver.findElement(By.cssSelector("[id='name']")).sendKeys("epam");
        driver.findElement(By.cssSelector("[id='password']")).sendKeys("1234");
        driver.findElement(By.cssSelector("[id='login-button']")).click();

        // 4 - Assert User name

        assertEquals(driver.findElement(By.cssSelector("span[id='user-name']")).getText(), "PITER CHAILOVSKII");

        //5 - Assert Browser title

        assertEquals(driver.getTitle(), "Home Page");

        //6 - there are 4 items on the header section

        WebElement headerPanel = driver.findElement(By.cssSelector("[class='uui-header dark-gray']"));
        WebElement homeOption = headerPanel.findElement(By.cssSelector("[href='index.html']"));
        WebElement contactsOption = headerPanel.findElement(By.cssSelector("[href='contacts.html']"));
        WebElement serviceOption = headerPanel.findElement(By.cssSelector("[class='dropdown-toggle']"));
        WebElement metalsColorsOption = headerPanel.findElement(By.cssSelector("[href='metals-colors.html']"));
        assertEquals(homeOption.getText(), "HOME");
        assertEquals(contactsOption.getText(), "CONTACT FORM");
        assertEquals(serviceOption.getText(), "SERVICE");
        assertEquals(metalsColorsOption.getText(), "METALS & COLORS");

        //7 - there are 4 displayed images on the Index Page

        List<WebElement>  images = driver.findElements(By.cssSelector("[class='benefit-icon']"));
        assertTrue(images.get(0).isDisplayed());
        assertTrue(images.get(1).isDisplayed());
        assertTrue(images.get(2).isDisplayed());
        assertTrue(images.get(3).isDisplayed());

        //8 - there are 4 proper texts on the Index Page under icons

        List<WebElement>  texts = driver.findElements(By.cssSelector("[class='benefit-txt']"));

        String firstTextTemplate =  "To include good practices\n" +
                                    "and ideas from successful\n" +
                                    "EPAM project";
        String secondTextTemplate =  "To be flexible and\n" +
                                     "customizable";
        String thirdTextTemplate =  "To be multiplatform";
        String fourthTextTemplate = "Already have good base\n" +
                                    "(about 20 internal and\n" +
                                    "some external projects),\n" +
                                    "wish to get more…";
        assertEquals(texts.get(0).getText(), firstTextTemplate);
        assertEquals(texts.get(1).getText(), secondTextTemplate);
        assertEquals(texts.get(2).getText(), thirdTextTemplate);
        assertEquals(texts.get(3).getText(), fourthTextTemplate);

        //9 - Assert a text of the main headers
        WebElement headerText = driver.findElement(By.cssSelector("[class='main-title text-center']"));
        WebElement loremIpsum = driver.findElement(By.cssSelector("[class='main-txt text-center']"));
        String headerTextTemplate =  "EPAM framework Wishes…";
        String loremIpsumTemplate =  "Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor " +
                "incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation " +
                "ullamco laboris nisi ut aliquip ex ea commodo consequat Duis aute irure dolor in reprehenderit in " +
                "voluptate velit esse cillum dolore eu fugiat nulla pariatur.";
        assertEquals(headerText.getText(), headerTextTemplate.toUpperCase());
        assertEquals(loremIpsum.getText(), loremIpsumTemplate.toUpperCase());

        //10 - The iframe exists
        assertTrue(driver.findElement(By.cssSelector("[id='iframe']")).isDisplayed());

        //11 - there is Epam logo in the left top conner of iframe
        WebDriver iframe = driver.switchTo().frame("iframe");
        assertTrue(iframe.findElement(By.cssSelector("[id='epam_logo']")).isDisplayed());

        //12 - Switch to original window back
        driver.switchTo().defaultContent();

        //13 - Assert a text of the sub header
        WebElement link = driver.findElement(By.cssSelector("[href='https://github.com/epam/JDI']"));
        assertEquals(link.getText(), "JDI Github".toUpperCase());

        //14 - JDI GITHUB is a link and has a proper URL
        assertEquals(link.getAttribute("href"), "https://github.com/epam/JDI");

        //15 - there is Left Section
        assertTrue(driver.findElement(By.cssSelector("[id='mCSB_1']")).isDisplayed());

        //16 - Assert that there is Footer
        assertTrue(driver.findElement(By.cssSelector("[class='footer-content overflow']")).isDisplayed());

        //17 - close browser
        driver.close();
    }
}
