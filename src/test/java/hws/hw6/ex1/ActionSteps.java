package hws.hw6.ex1;

import cucumber.api.java.en.When;
import hws.hw6.ENUMs.*;
import hws.hw6.SelenideIndexPage;
import hws.hw6.SelenideSupportPage;

import java.util.List;

import static com.codeborne.selenide.Selenide.page;

public class ActionSteps {
    private SelenideIndexPage jdiIndexPage = page(SelenideIndexPage .class);
    private SelenideSupportPage jdiSupportPage = page(SelenideSupportPage .class);

    @When("^I login as '([^\"]*)'$")
    public void iLogin(Users user){
        jdiIndexPage.logIn(user);
    }

    @When("^I click on Service subcategory in the header$")
    public void iOpenServiceMenuInHeader(){
        jdiIndexPage.expandServiceList();
    }

    @When("^I click on Service subcategory in the left section$")
    public void iOpenServiceMenuInLeftSection(){
        jdiIndexPage.expandLeftServiceList();
    }

    @When("^I open header menu Service -> Different Elements Page$")
    public void iOpenDifferentElementsPage(){
        jdiIndexPage.openDifferentPage(ServiceListOptions.DIFFERENT_ELEMENTS_PAGE_LINK);
    }

    @When("^I select checkboxes:$")
    public void iSelectNatureElements(List<CheckboxsList> checkboxes){
        jdiSupportPage.selectCheckboxs(checkboxes);
    }

    @When("^I select '([^\"]*)' radio button$")
    public void selectARadioButton(Metals metal){
        jdiSupportPage.selectRadioButtons(metal);
    }

    @When("^I select '([^\"]*)' from the color selection dropdown$")
    public void selectAColor(Colors color){
        jdiSupportPage.selectColor(color);
    }

    @When("^I unselect checkboxes:$")
    public void unselectNatureElements(List<CheckboxsList> checkboxes){
        jdiSupportPage.selectCheckboxs(checkboxes);
    }

}
