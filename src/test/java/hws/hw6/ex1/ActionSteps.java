package hws.hw6.ex1;

import cucumber.api.java.en.When;
import hws.hw6.ex1.ENUMs.*;

import java.util.List;

import static com.codeborne.selenide.Selenide.page;

public class ActionSteps {
    private SelenideIndexPage jdiIndexPage = page(SelenideIndexPage.class);
    private SelenideSupportPage jdiSupportPage = page(SelenideSupportPage.class);

    @When("^I login as '([^\"]*)'$")
    public void LoggingIn(Users user) {
        jdiIndexPage.logIn(user);
    }

    @When("^I expand Service drop-down in the header$")
    public void expandServiceDropdown() {
        jdiIndexPage.expandServiceList();
    }

    @When("^I click expand Service drop-down in the left section$")
    public void expandServiceDropdown2() {
        jdiIndexPage.expandLeftServiceList();
    }

    @When("^I follow ([^\"]*) via the header drop-down$")
    public void OpenDifferentElementsPage(ServiceListOptions page) {
        jdiIndexPage.openDifferentPage(page);
    }

    @When("^I select checkboxes:$")
    public void selectCheckboxes(List<CheckboxsList> checkboxes) {
        jdiSupportPage.selectCheckboxs(checkboxes);
    }

    @When("^I select '([^\"]*)' radio button$")
    public void selectARadioButton(Metals metal) {
        jdiSupportPage.selectRadioButtons(metal);
    }

    @When("^I select '([^\"]*)' from the colour selection drop-down$")
    public void selectAColor(Colors color) {
        jdiSupportPage.selectColor(color);
    }

    @When("^I deselect checkboxes:$")
    public void deselectCheckboxes(List<CheckboxsList> checkboxes) {
        jdiSupportPage.selectCheckboxs(checkboxes);
    }

}
