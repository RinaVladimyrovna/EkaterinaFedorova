package hws.hw6.ex2;

import cucumber.api.java.en.Given;
import hws.hw6.ex2.ENUMs.MainPage;

import static com.codeborne.selenide.Selenide.open;

public class NavigationSteps {

    @Given("^I am on 'Home Page'$")
    public void iOpenEpamSite() {
        open(MainPage.JDI_PAGE_URL.toString());
    }

}
