package hws.hw6.ex2;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;

import java.util.List;
import java.util.Map;

import static com.codeborne.selenide.Condition.visible;
import static org.testng.Assert.assertEquals;

public class AssertionSteps {

    @Then("^'([^\"]*)' page is opened$")
    public void checkPageTitle(String expectedPageTitle) {
        String actualPageTitle = new SelenideIndexPage().getPageTitle();
        assertEquals(actualPageTitle, expectedPageTitle);
    }

    @And("^(\\d) NumberType Dropdowns are displayed on Users Table on User Table Page$")
    public void checkDropDownAmount(int amount) {
        new SelenideUserTablePage().getDropDowns().shouldHaveSize(amount);
    }

    @And("^(\\d) User names are displayed on Users Table on User Table Page$")
    public void checkUserNameAmount(int amount) {
        new SelenideUserTablePage().getNames().shouldHaveSize(amount);
    }

    @And("^(\\d) Description images are displayed on Users Table on User Table Page$")
    public void checkDescriptionImagesAmount(int amount) {
        new SelenideUserTablePage().getImages().shouldHaveSize(amount);
    }

    @And("^(\\d) Description texts under images are displayed on Users Table on User Table Page$")
    public void checkDescriptionsAmount(int amount) {
        new SelenideUserTablePage().getDescriptions().shouldHaveSize(amount);
    }

    @And("^(\\d) checkboxes are displayed on Users Table on User Table Page$")
    public void checkCheckboxAmount(int amount) {
        new SelenideUserTablePage().getCheckboxes().shouldHaveSize(amount);
    }

    @Then("^1 log row has \"([^\"]*)\" text in log section$")
    public void checkUsername(String logText) {
        new SelenideUserTablePage().getLogs().findBy(Condition.text(logText)).shouldBe(visible);
    }

    @Then("^([^\"]*) droplist contains values$")
    public void checkInterface(String name, List<String> options) {
        ElementsCollection dropDownOptions = new SelenideUserTablePage().getDropDownOptions(name);
        for (String option : options) {
            dropDownOptions.findBy(Condition.text(option)).shouldBe(visible);
        }
    }

    @And("^User table contains following values:$")
    public void checkTable(DataTable exampleTable) {
        List<Map<String, String>> table = exampleTable.asMaps(String.class, String.class);
        ElementsCollection numbers = new SelenideUserTablePage().getRowNumbers();
        ElementsCollection users = new SelenideUserTablePage().getNames();
        ElementsCollection descriptions = new SelenideUserTablePage().getDescriptions();

        for (Map<String, String> number : table) {
            numbers.findBy(Condition.text(number.get("Number"))).shouldBe(visible);
        }

        for (Map<String, String> user : table) {
            users.findBy(Condition.text(user.get("User"))).shouldBe(visible);
        }

        for (Map<String, String> description : table) {
            descriptions.findBy(Condition.text(description.get("Description"))).shouldBe(visible);
        }
    }

}
