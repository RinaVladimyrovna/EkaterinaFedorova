package hws.hw6.ex1;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import hws.hw6.ENUMs.MainPage;
import hws.hw6.ENUMs.RightSectionLogs;
import hws.hw6.ENUMs.ServiceListOptions;
import hws.hw6.ENUMs.Users;
import hws.hw6.SelenideIndexPage;
import hws.hw6.SelenideSupportPage;

import java.util.List;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.page;
import static hws.hw6.ENUMs.ServiceListOptions.values;
import static org.testng.Assert.assertEquals;

public class AssertionSteps {
    private SelenideIndexPage jdiIndexPage = page(SelenideIndexPage .class);
    private SelenideSupportPage jdiSupportPage = page(SelenideSupportPage .class);

    @Then("^The browser title should be '([^\"]*)'$")
    public void checkPageTitle(MainPage expectedPageTitle) {
        String actualPageTitle = new SelenideIndexPage().getPageTitle();
        assertEquals(actualPageTitle, expectedPageTitle.toString());
    }

    @Then("^User's name should be '([^\"]*)'$")
    public void checkUsername(Users expectedName) {
        new SelenideIndexPage().getUserName().shouldBe(Condition.text(expectedName.name));
    }

    @And("^Interface should have all the necessary elements$")
    public void checkInterface() {
        new SelenideIndexPage().getHomePageIcons().shouldHaveSize(4);
        new SelenideIndexPage().getIconTexts().shouldHaveSize(4);
        new SelenideIndexPage().getCentreTexts().shouldHaveSize(2);
    }

    @Then("^Service dropdown menu in header displays following options$")
    public void checkServiceOptionsInHeader(List<ServiceListOptions> options) {
        int index = 0;
        ElementsCollection serviceListItems = new SelenideIndexPage().getDisplayedItems();
        for (ServiceListOptions item : values()) {
            serviceListItems.get(index).shouldHave(text(options.get(index++).toString()));
        };
    }

    @Then("^Service dropdown in left section displays following options$")
    public void checkServiceOptionsInLeftSection(List<ServiceListOptions> options){
        int index = 0;
        ElementsCollection leftServiceListItems = new SelenideIndexPage().getDisplayedItems2();
        for (ServiceListOptions item : values()) {
            leftServiceListItems.get(index).shouldHave(text(options.get(index++).toString()));
        };
    }

    @Then("^Interface on Different elements page contains all needed elements$")
    public void interfaceShouldContainElements(){
        new SelenideSupportPage().getButtons().shouldHaveSize(2);
        new SelenideSupportPage().getCheckboxs().shouldHaveSize(4);
        new SelenideSupportPage().getColorList().shouldBe(visible);
        new SelenideSupportPage().getRadioButtons().shouldHaveSize(4);
    }

    @And("^There is a Right section$")
    public void verifyRightSectionPresence(){
        new SelenideSupportPage().getRightSection().shouldBe(visible);;
    }

    @And("^There is a Left section$")
    public void verifyLeftSectionPresence(){
        new SelenideSupportPage().getLeftSection().shouldBe(visible);;
    }

    @Then("^For each checkbox there is a log row$")
    public void checkLogWorksForNatureElements(List<RightSectionLogs> expectedLogs){
        ElementsCollection actualLogs = new SelenideSupportPage().getLogs();
        for (RightSectionLogs log : expectedLogs) {
            actualLogs.findBy(text(log.toString())).shouldBe(visible);
        }
    }

    @Then("There is a log raw for '([^\"]*)' radio button")
    public void checkLogForMetalButton(RightSectionLogs expectedLog){
        ElementsCollection actualLogs = new SelenideSupportPage().getLogs();
        actualLogs.findBy(text(expectedLog.toString())).shouldBe(visible);
    }

    @Then("There is a log raw for '([^\"]*)' color dropdown")
    public void checkLogForColors(RightSectionLogs color){
        ElementsCollection actualLogs = new SelenideSupportPage().getLogs();
        actualLogs.findBy(text(color.toString())).shouldBe(visible);
    }

    @Then("Following boxes are unchecked:")
    public void assertNatureElementsAreUnselected(List<RightSectionLogs> expectedLogs){
        ElementsCollection actualLogs = new SelenideSupportPage().getLogs();
        for (RightSectionLogs log : expectedLogs) {
            actualLogs.findBy(text(log.toString())).shouldBe(visible);
        }
    }
}
