package hws.hw3;

import hws.hw3.ENUMs.LoggingIn;
import hws.hw3.ENUMs.MainPage;
import hws.hw3.ENUMs.NavigationPanel;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class SimplePageObject {

    private WebDriver driver;

    public SimplePageObject(WebDriver webDriver) {
        this.driver = webDriver;
    }

    @FindBy(css = "[id='user-icon']")
    private WebElement loggingIcon;

    @FindBy(css = "[id='name']")
    private WebElement accountNameField;

    @FindBy(css = "[id='password']")
    private WebElement passwordNameField;

    @FindBy(css = "[id='login-button']")
    private WebElement loggingButton;

    @FindBy(css = "span[id='user-name']")
    private WebElement userNameField;

    @FindBy(xpath = "[class='uui-header dark-gray']")
    private WebElement headerPanel;

    @FindBy(xpath = "//div[@class='uui-header dark-gray']//a[@href='index.html']")
    private WebElement homeOption;

    @FindBy(xpath = "//div[@class='uui-header dark-gray']//a[@href='contacts.html']")
    private WebElement contactsOption;

    @FindBy(xpath = "//div[@class='uui-header dark-gray']//a[@class='dropdown-toggle']")
    private WebElement serviceOption;

    @FindBy(xpath = "//div[@class='uui-header dark-gray']//a[@href='metals-colors.html']")
    private WebElement metalsColorsOption;

    @FindBy(css = "[class='benefit-icon']")
    private List<WebElement> images;

    @FindBy(css = "[class='benefit-txt']")
    private List<WebElement> texts;

    @FindBy(css = "[class='main-title text-center']")
    private WebElement headerText;

    @FindBy(css = "[class='main-txt text-center']")
    private WebElement loremText;

    @FindBy(css = "[id='iframe']")
    private WebElement iFrame;

    @FindBy(css = "[href='https://github.com/epam/JDI']")
    private WebElement link;

    @FindBy(css = "[id='mCSB_1']")
    private WebElement leftSection;

    @FindBy(css = "[class='footer-content overflow']")
    private WebElement footer;

    public void openJdiPage(MainPage link) {
        driver.navigate().to(link.toString());
    }

    public void verifyPageTitle(MainPage title) {
        assertEquals(driver.getTitle(), title.toString());
    }

    public void logIn(LoggingIn credentials) {
        loggingIcon.click();
        accountNameField.sendKeys(credentials.login);
        passwordNameField.sendKeys(credentials.password);
        loggingButton.click();
    }

    public void verifyUserName(LoggingIn credentials) {
        assertEquals(userNameField.getText(), credentials.name);
    }

    public void verifyHeaderSectionItems(NavigationPanel navigation) {

        assertEquals(homeOption.getText(), navigation.home);
        assertEquals(contactsOption.getText(), navigation.contact);
        assertEquals(serviceOption.getText(), navigation.service);
        assertEquals(metalsColorsOption.getText(), navigation.material);
    }

    public void verifyDisplayedImages() {
        for (WebElement el : images) {
            assertTrue(el.isDisplayed());
        }
    }

    public void verifyImageTexts(MainPage text1, MainPage text2, MainPage text3, MainPage text4) {
        assertEquals(texts.get(0).getText(), text1.toString());
        assertEquals(texts.get(1).getText(), text2.toString());
        assertEquals(texts.get(2).getText(), text3.toString());
        assertEquals(texts.get(3).getText(), text4.toString());
    }

    public void verifyHeaderTexts(MainPage mainHeaderText, MainPage loremIpsumText) {
        assertEquals(headerText.getText(), mainHeaderText.toString());
        assertEquals(loremText.getText(), loremIpsumText.toString());
    }

    public void iFrame() {
        assertTrue(iFrame.isDisplayed());
    }

    public void iFrameLogo() {
        WebDriver iframe = driver.switchTo().frame(iFrame);
        assertTrue(iframe.findElement(By.cssSelector("[id='epam_logo']")).isDisplayed());
    }

    public void mainScreen() {
        driver.switchTo().defaultContent();
    }

    public void subHeaderText(MainPage text) {
        assertEquals(link.getText(), text.toString());
    }

    public void verifyLink(MainPage URL) {
        assertEquals(link.getAttribute("href"), URL.toString());
    }

    public void verifyLeftSection() {
        assertTrue(leftSection.isDisplayed());
    }

    public void verifyFooter() {
        assertTrue(footer.isDisplayed());
    }

    public void close() {
        driver.close();
    }
}
