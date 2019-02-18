package hws.hw6.ex1;

import cucumber.api.java.en.Given;
import hws.hw6.ex1.ENUMs.MainPage;

import static com.codeborne.selenide.Selenide.open;

public class NavigationSteps {

    @Given("^I open the site$")
    public void openSite() {
        open(MainPage.JDI_PAGE_URL.toString());
    }

}
