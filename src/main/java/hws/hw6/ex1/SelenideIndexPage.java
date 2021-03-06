package hws.hw6.ex1;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import hws.hw6.ex1.ENUMs.ServiceListOptions;
import hws.hw6.ex1.ENUMs.Users;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.page;
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

    @FindBy(css = "[class^='icons-benefit']")
    private ElementsCollection homePageIcons;

    @FindBy(css = "[class^='benefit-txt']")
    private ElementsCollection iconTexts;

    @FindBy(css = "[class$=' text-center']")
    private ElementsCollection centreTexts;

    @FindBy(css = "li[class='dropdown']")
    private SelenideElement serviceOption;

    @FindBy(css = "ul.dropdown-menu>li>a")
    private ElementsCollection serviceListItems;

    @FindBy(css = "[class='menu-title'][index='3']")
    private SelenideElement leftServiceOption;

    @FindBy(css = "ul.sub span")
    private ElementsCollection leftServiceListItems;

    public SelenideIndexPage() {
        page(this);
    }

    public String getPageTitle() {
        return getWebDriver().getTitle();
    }

    public void logIn(Users user) {
        loggingIcon.click();
        accountNameField.sendKeys(user.login);
        passwordNameField.sendKeys(user.password);
        loggingButton.click();
    }

    public SelenideElement getUserName() {
        return userNameField;
    }

    public ElementsCollection getHomePageIcons() {
        return homePageIcons;
    }

    public ElementsCollection getIconTexts() {
        return iconTexts;
    }

    public ElementsCollection getCentreTexts() {
        return centreTexts;
    }

    public void expandServiceList() {
        serviceOption.click();
    }

    public ElementsCollection getDisplayedItems() {
        return serviceListItems;
    }

    public void expandLeftServiceList() {
        leftServiceOption.click();
    }

    public ElementsCollection getDisplayedItems2() {
        return leftServiceListItems;
    }

    public void openDifferentPage(ServiceListOptions pageName) {
        serviceOption.click();
        serviceListItems.findBy(text(pageName.toString())).click();
    }

}
