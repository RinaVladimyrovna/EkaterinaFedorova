package hws.hw6.ex1;

import cucumber.api.java.en.Given;
import hws.hw6.ENUMs.MainPage;

import static com.codeborne.selenide.Selenide.open;

public class NavigationSteps {

    @Given("^I open site$")
    public void iOpenEpamSite() {
        open(MainPage.JDI_PAGE_URL.toString());
    }

}
