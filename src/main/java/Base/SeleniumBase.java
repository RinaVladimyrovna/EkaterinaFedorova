package Base;

import org.testng.annotations.BeforeSuite;

public abstract class SeleniumBase {

    @BeforeSuite
    public void beforeSuite() {
       // setProperty("webdriver.chrome.driver", )
    }
}
