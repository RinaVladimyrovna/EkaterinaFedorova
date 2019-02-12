package hws.hw4;

import com.codeborne.selenide.*;
import hws.hw4.ENUMs.LoggingIn;
import hws.hw4.ENUMs.MainPage;
import hws.hw4.ENUMs.Colors;
import hws.hw4.ENUMs.ServiceListOptions;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Condition.*;
import static hws.hw4.ENUMs.ServiceListOptions.*;
import static org.testng.Assert.assertEquals;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class SelenideIndexPage {

    @FindBy(css = "[id='user-icon']")
    private SelenideElement loggingIcon;

    @FindBy(css = "[id='name']")
    private SelenideElement accountNameField;

    @FindBy(css = "[id='password']")
    private SelenideElement passwordNameField;

    @FindBy(css = "[id='login-button']")
    private SelenideElement loggingButton;

    @FindBy(css = "span[id='user-name']")
    private SelenideElement userNameField;

    @FindBy(css = "li[class='dropdown']")
    private SelenideElement serviceOption;

    @FindBy(css = "ul.dropdown-menu>li>a")
    private ElementsCollection serviceListItems;

    @FindBy(css = "[class='menu-title'][index='3']")
    private SelenideElement leftServiceOption;

    @FindBy(css = "ul.sub span")
    private ElementsCollection leftServiceListItems;

    @FindBy(css = "[class='label-checkbox']")
    private ElementsCollection checkboxs;

    @FindBy(css = "[class='label-radio']")
    private ElementsCollection radioButtons;

    @FindBy(css = "[class='colors']")
    private SelenideElement colorList;

    @FindBy(css = "[class='uui-button']")
    private ElementsCollection buttons;

    @FindBy(css = "[id='mCSB_1']")
    private SelenideElement leftSection;

    @FindBy(css = "[name='log-sidebar']")
    private SelenideElement rightSection;

    @FindBy(css = "[class='panel-body-list logs'] li")
    private ElementsCollection rightSectionLogs;

    public void verifyPageTitle() {
        assertEquals(getWebDriver().getTitle(), MainPage.MAIN_PAGE_TITLE.toString());
    }

    public void logIn() {
        loggingIcon.click();
        accountNameField.sendKeys(LoggingIn.USER.login);
        passwordNameField.sendKeys(LoggingIn.USER.password);
        loggingButton.click();
    }

    public void verifyUserName() {
        assertEquals(userNameField.getText(), LoggingIn.USER.name);
    }

    public void expandServiceList() {
        serviceOption.click();
    }

    public void verifyDisplayedItems() {
        int index = 0;
        for (ServiceListOptions item : values()) {
            //serviceListItems.get(index++).getText(). item.toString());
            serviceListItems.get(index++).shouldHave(text(item.toString()));
        }
    }

    public void expandLeftServiceList() {
        leftServiceOption.click();
    }

    public void verifyDisplayedItems2() {
        int index = 0;
        for (ServiceListOptions item : values()) {
            //assertEquals(leftServiceListItems.get(index++).getText(), item.toString());
            leftServiceListItems.get(index++).shouldHave(text(item.toString()));
        }
    }

    // TODO This method should be parametrised by enum instead of string
    public void openDifferentPage(String pageName) {
        serviceOption.click();
        serviceListItems.findBy(text(pageName)).click();
    }

    private void checkVisibilityOfAllElements(ElementsCollection collection) {
        for (SelenideElement element : collection) {
            element.shouldBe(visible);
        }
    }

    public void verifyPageElements(int boxNumber, int radioNumber, int buttonNumber) {
        assertEquals(checkboxs.size(), boxNumber);
        assertEquals(radioButtons.size(), radioNumber);
        assertEquals(buttons.size(), buttonNumber);
        checkVisibilityOfAllElements(checkboxs);
        checkVisibilityOfAllElements(radioButtons);
        checkVisibilityOfAllElements(buttons);
    }

    public void verifyRightSectionPresence() {
        rightSection.shouldBe(visible);
    }

    public void verifyLeftSectionPresence() {
        leftSection.shouldBe(visible);
    }

    public void selectCheckboxs(String... boxes) {
        for (String box : boxes) {
            checkboxs.findBy(text(box)).click();
        }
    }

    public void verifyLogs(String... logs) {
        for (String log : logs) {
            rightSectionLogs.findBy(text(log)).shouldBe(visible);
            //.shouldHave(text(log)); probably
        }
    }

    public void selectRadioButtons(String... buttons) {
        for (String button : buttons) {
            radioButtons.findBy(text(button)).click();
        }
    }

    public void deselectCheckboxs(String... boxes) {
        selectCheckboxs(boxes);
        for (String box : boxes) {
            checkboxs.findBy(text(box)).shouldNotBe(checked);
        }
    }

    public void selectColor() {
        colorList.click();
        colorList.$(Selectors.byText(Colors.YELLOW.toString())).click();
    }

}
