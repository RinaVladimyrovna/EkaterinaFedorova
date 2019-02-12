package hws.hw3;

import hws.hw3.ENUMs.BelowIconTexts;
import hws.hw3.ENUMs.Users;
import hws.hw3.ENUMs.MainPage;
import hws.hw3.ENUMs.NavigationPanel;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class JdiIndexPage {

    private WebDriver driver;

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

    public JdiIndexPage(WebDriver webDriver) {
        this.driver = webDriver;
    }

    public void openJdiPage(MainPage link) {
        driver.navigate().to(link.toString());
    }

    public void verifyPageTitle(MainPage title) {
        assertEquals(driver.getTitle(), title.toString());
    }

    public void logIn(Users credentials) {
        loggingIcon.click();
        accountNameField.sendKeys(credentials.login);
        passwordNameField.sendKeys(credentials.password);
        loggingButton.click();
    }

    public void verifyUserName(Users credentials) {
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

    public void verifyImageTexts() {
        int index = 0;
        for (BelowIconTexts icon : BelowIconTexts.values()) {
            assertEquals(texts.get(index++).getText(), icon.toString());
        }
    }

    public void verifyHeaderTexts(MainPage mainHeaderText, MainPage loremIpsumText) {
        assertEquals(headerText.getText(), mainHeaderText.toString());
        assertEquals(loremText.getText(), loremIpsumText.toString());
    }

    public void verifyIframePresence() {
        assertTrue(iFrame.isDisplayed());
    }

    public void verifyIframeLogoIsDisplayed() {
        WebDriver iframe = driver.switchTo().frame(iFrame);
        assertTrue(iframe.findElement(By.cssSelector("[id='epam_logo']")).isDisplayed());
    }

    public void switchToMainScreen() {
        driver.switchTo().defaultContent();
    }

    public void verifySubHeaderText(MainPage text) {
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
