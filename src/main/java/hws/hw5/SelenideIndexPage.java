package hws.hw5;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import hws.hw5.ENUMs.MainPage;
import hws.hw5.ENUMs.ServiceListOptions;
import hws.hw5.ENUMs.Users;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static hws.hw5.ENUMs.ServiceListOptions.values;
import static org.testng.Assert.assertEquals;

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

    @Step("Verify page title is HomePage")
    public void verifyPageTitle() {
        assertEquals(getWebDriver().getTitle(), MainPage.MAIN_PAGE_TITLE.toString());
    }

    @Step("login as user")
    public void logIn(Users user) {
        loggingIcon.click();
        accountNameField.sendKeys(user.login);
        passwordNameField.sendKeys(user.password);
        loggingButton.click();
    }

    @Step("Verify that user name is {0}")
    public void verifyUserName(Users user) {
        userNameField.shouldHave(Condition.text(user.name));
    }

    @Step("Expand Service drop-down list on upper panel")
    public void expandServiceList() {
        serviceOption.click();
    }

    @Step("Verify options in Service drop-down list")
    public void verifyDisplayedItems() {
        int index = 0;
        for (ServiceListOptions item : values()) {
            serviceListItems.get(index++).shouldHave(text(item.toString()));
        }
    }

    @Step("Expand Service drop-down list on the left panel")
    public void expandLeftServiceList() {
        leftServiceOption.click();
    }

    @Step("Verify options in Service drop-down list")
    public void verifyDisplayedItems2() {
        int index = 0;
        for (ServiceListOptions item : values()) {
            leftServiceListItems.get(index++).shouldHave(text(item.toString()));
        }
    }

    // TODO This method should be parametrised by enum instead of string
    // Done
    @Step("Navigate to {0}")
    public void openDifferentPage(ServiceListOptions pageName) {
        serviceOption.click();
        serviceListItems.findBy(text(pageName.toString())).click();
    }

}
