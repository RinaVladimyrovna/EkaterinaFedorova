package hws.hw6.ex2;

import cucumber.api.java.en.When;

import static com.codeborne.selenide.Selenide.page;

public class ActionSteps {

    private SelenideUserTablePage jdiUserTablePage = page(SelenideUserTablePage.class);

    @When("^I select 'vip' checkbox for \"([^\"]*)\"$")
    public void iSelectNatureElements(String name) {
        jdiUserTablePage.selectAnCheckbox(name);
    }

    @When("^I click on dropdown in column Type for user ([^\"]*)$")
    public void selectARadioButton(String name) {
        jdiUserTablePage.expandDropDown(name);
    }

}
