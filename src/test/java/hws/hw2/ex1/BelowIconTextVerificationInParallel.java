package hws.hw2.ex1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;

public class BelowIconTextVerificationInParallel {
    private WebDriver driver;
    private String addressURL = "https://epam.github.io/JDI/";

    @DataProvider(parallel = true)
    private Object[][] belowIconText() {

        String firstTextTemplate = "To include good practices\n" +
                "and ideas from successful\n" +
                "EPAM project";
        String secondTextTemplate = "To be flexible and\n" +
                "customizable";
        String thirdTextTemplate = "To be multiplatform";
        String fourthTextTemplate = "Already have good base\n" +
                "(about 20 internal and\n" +
                "some external projects),\n" +
                "wish to get more…";
        return new Object[][]{
                {0, firstTextTemplate},
                {1, secondTextTemplate},
                {2, thirdTextTemplate},
                {3, fourthTextTemplate}
        };
    }

    @BeforeClass
    public void beforeMethod() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(10000, TimeUnit.MILLISECONDS);

        //1 - Open test site by URL

        driver.navigate().to(addressURL);
    }

    @AfterClass
    public void afterMethod() {
        //3 - close browser
        driver.close();
    }

    @Test(dataProvider = "belowIconText")
    public void simpleTest(int belowIconTextIndex, String belowIconText) {

        //2 - there are 4 proper texts on the Index Page under icons

        List<WebElement> texts = driver.findElements(By.cssSelector("[class='benefit-txt']"));
        assertEquals(texts.get(belowIconTextIndex).getText(), belowIconText);
    }
}
