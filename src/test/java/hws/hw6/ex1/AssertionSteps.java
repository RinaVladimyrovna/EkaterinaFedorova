package hws.hw6.ex1;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import hws.hw6.ex1.ENUMs.MainPage;
import hws.hw6.ex1.ENUMs.RightSectionLogs;
import hws.hw6.ex1.ENUMs.ServiceListOptions;
import hws.hw6.ex1.ENUMs.Users;

import java.util.List;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static hws.hw6.ex1.ENUMs.ServiceListOptions.values;
import static org.testng.Assert.assertEquals;

public class AssertionSteps {

    @Then("^Browser title should be '([^\"]*)'$")
    public void verifyPageTitle(MainPage expectedPageTitle) {
        String actualPageTitle = new SelenideIndexPage().getPageTitle();
        assertEquals(actualPageTitle, expectedPageTitle.toString());
    }

    @Then("^User's name should be '([^\"]*)'$")
    public void verifyUserName(Users expectedName) {
        new SelenideIndexPage().getUserName().shouldBe(Condition.text(expectedName.name));
    }

    @And("^Interface should have all necessary elements$")
    public void verifyInterface() {
        new SelenideIndexPage().getHomePageIcons().shouldHaveSize(4);
        new SelenideIndexPage().getIconTexts().shouldHaveSize(4);
        new SelenideIndexPage().getCentreTexts().shouldHaveSize(2);
    }

    @Then("^Service drop-down in the header contains the following options$")
    public void verifyServiceOptions(List<ServiceListOptions> options) {
        int index = 0;
        ElementsCollection serviceListItems = new SelenideIndexPage().getDisplayedItems();
        for (ServiceListOptions item : values()) {
            serviceListItems.get(index).shouldHave(text(options.get(index++).toString()));
        };
    }

    @Then("^Service drop-down in the left section contains the following options$")
    public void checkServiceOptions2(List<ServiceListOptions> options) {
        int index = 0;
        ElementsCollection leftServiceListItems = new SelenideIndexPage().getDisplayedItems2();
        for (ServiceListOptions item : values()) {
            leftServiceListItems.get(index).shouldHave(text(options.get(index++).toString()));
        };
    }

    @Then("^Interface on Different elements page contains all needed elements$")
    public void verifyInterface2() {
        new SelenideSupportPage().getButtons().shouldHaveSize(2);
        new SelenideSupportPage().getCheckboxs().shouldHaveSize(4);
        new SelenideSupportPage().getColorList().shouldBe(visible);
        new SelenideSupportPage().getRadioButtons().shouldHaveSize(4);
    }

    @And("^There is a Right section$")
    public void verifyRightSectionPresence() {
        new SelenideSupportPage().getRightSection().shouldBe(visible);
    }

    @And("^There is a Left section$")
    public void verifyLeftSectionPresence() {
        new SelenideSupportPage().getLeftSection().shouldBe(visible);
    }

    @Then("^For each checkbox there is a log row$")
    public void checkLogs(List<RightSectionLogs> expectedLogs) {
        ElementsCollection actualLogs = new SelenideSupportPage().getLogs();
        for (RightSectionLogs log : expectedLogs) {
            actualLogs.findBy(text(log.toString())).shouldBe(visible);
        }
    }

    @Then("There is a log row for '([^\"]*)' radio button")
    public void checkLogs2(RightSectionLogs expectedLog) {
        ElementsCollection actualLogs = new SelenideSupportPage().getLogs();
        actualLogs.findBy(text(expectedLog.toString())).shouldBe(visible);
    }

    @Then("There is a log row for '([^\"]*)' colour drop-down")
    public void checkLogs3(RightSectionLogs color) {
        ElementsCollection actualLogs = new SelenideSupportPage().getLogs();
        actualLogs.findBy(text(color.toString())).shouldBe(visible);
    }

    @Then("The following checkboxes are unchecked:")
    public void assertDeselection(List<RightSectionLogs> expectedLogs) {
        ElementsCollection actualLogs = new SelenideSupportPage().getLogs();
        for (RightSectionLogs log : expectedLogs) {
            actualLogs.findBy(text(log.toString())).shouldBe(visible);
        }
    }
}
