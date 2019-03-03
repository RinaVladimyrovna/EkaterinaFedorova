package hws.hw7;

import com.epam.jdi.light.driver.WebDriverFactory;
import com.epam.jdi.light.ui.html.PageFactory;
import hws.hw7.entities.*;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class JdiFormTest {


    @BeforeSuite(alwaysRun = true)
    public void beforeSuit(){
        PageFactory.initElements(JdiPage.class);
    }
    @Test
    public void simpleJdiTest(){
        //1 - login as User
        JdiPage.indexPageJdi.open();
        JdiPage.indexPageJdi.login(Users.PITER);

        //2 - Open Metals & Colors page by Header menu
        JdiPage.indexPageJdi.navigateToPage(HeaderMenuItems.METALS_AND_COLORS_PAGE_LINK);

        //3 - Fill in and submit a form
        JdiPage.metalsColorsPage.fillInForm(SubmitData.METALS_AND_COLORS_FORM_HW7);

        //4 - evaluate results
        JdiPage.metalsColorsPage.verifyResultSectionLogs(ResultsTemplates.FULL_TEMPLATE, ResultsHw7.RESULTS_HW_7);

    }

    @AfterSuite
    public void afterSuit(){
        WebDriverFactory.close();
    }
}
