package hws.hw6.ex1;

import com.codeborne.selenide.Browsers;
import com.codeborne.selenide.Configuration;
import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import org.testng.annotations.BeforeSuite;

@CucumberOptions(
        features = "src/test/resources/hws/hw6",
        glue = "classpath:hws.hw6"
)

public class RunAcceptanceTests extends AbstractTestNGCucumberTests {

    @BeforeSuite
    public void driverSetup() {

        Configuration.browser = Browsers.CHROME;
        Configuration.startMaximized = true;
        Configuration.timeout = 5000;
        Configuration.pollingInterval = 300;

    }

}
