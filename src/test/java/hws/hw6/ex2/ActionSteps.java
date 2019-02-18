package hws.hw6.ex2;

import cucumber.api.java.en.And;
import cucumber.api.java.en.When;
import hws.hw6.ex2.ENUMs.Users;


import static com.codeborne.selenide.Selenide.page;

public class ActionSteps {
    private SelenideIndexPage jdiIndexPage = page(SelenideIndexPage.class);
    private SelenideUserTablePage jdiUserTablePage = page(SelenideUserTablePage.class);

    @And("^I login as user '([^\"]*)'$")
    public void iLogin(Users user) {
        jdiIndexPage.logIn(user);
    }

    @When("^I click on 'Service' button in Header$")
    public void iOpenServiceMenuInHeader() {
        jdiIndexPage.expandServiceList();
    }

    @When("^I click on '([^\"]*)' button in Service dropdown$")
    public void iOpenDifferentElementsPage(String pageLink) {
        jdiIndexPage.openDifferentPage(pageLink.toUpperCase());
    }

    @When("^I select 'vip' checkbox for \"([^\"]*)\"$")
    public void iSelectNatureElements(String name) {
        jdiUserTablePage.selectAnCheckbox(name);
    }

    @When("^I click on dropdown in column Type for user ([^\"]*)$")
    public void selectARadioButton(String name) {
        jdiUserTablePage.expandDropDown(name);
    }

}
