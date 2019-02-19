package hws.hw4;

import com.codeborne.selenide.*;
import hws.hw4.ENUMs.MainPage;
import hws.hw4.ENUMs.ServiceListOptions;
import hws.hw4.ENUMs.Users;
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

    public void logIn(Users user) {
        loggingIcon.click();
        accountNameField.sendKeys(user.login);
        passwordNameField.sendKeys(user.password);
        loggingButton.click();
    }

    public void verifyUserName(Users user) {
        userNameField.shouldHave(Condition.text(user.name));
    }

    public void expandServiceList() {
        serviceOption.click();
    }

    public void verifyDisplayedItems() {
        int index = 0;
        for (ServiceListOptions item : values()) {
            serviceListItems.get(index++).shouldHave(text(item.toString()));
        }
    }

    public void expandLeftServiceList() {
        leftServiceOption.click();
    }

    public void verifyDisplayedItems2() {
        int index = 0;
        for (ServiceListOptions item : values()) {
            leftServiceListItems.get(index++).shouldHave(text(item.toString()));
        }
    }

    public void openDifferentPage(ServiceListOptions pageName) {
        serviceOption.click();
        serviceListItems.findBy(text(pageName.toString())).click();
    }

}
