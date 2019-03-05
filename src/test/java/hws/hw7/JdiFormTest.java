package hws.hw7;

import com.epam.jdi.light.driver.WebDriverFactory;
import com.epam.jdi.light.ui.html.PageFactory;
import hws.hw7.entities.*;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import static hws.hw7.entities.HeaderMenuItems.*;

public class JdiFormTest {


    @BeforeSuite(alwaysRun = true)
    public void beforeSuit() {
        PageFactory.initElements(JdiPage.class);
    }

    @Test
    public void simpleJdiTest() {
        //1 - login as User
        JdiPage.indexPageJdi.open();
        JdiPage.indexPageJdi.login(Users.PITER);

        //2 - Open Metals & Colors page by Header menu
        JdiPage.indexPageJdi.navigateToPage(METALS_AND_COLORS_PAGE_OPTION);

        //3 - Fill in and submit a form
        JdiPage.metalsColorsPage.fillInForm(SubmitData.METALS_AND_COLORS_FORM_HW7);

        /*TODO This is not the best solution.
        Basically, you should pass in verification step exactly the same instance
        that was use in filling action.
        */
        /*
        Disagree. All written functions potentially lead to mistakes.
        In this particular case those functions are trivial, but in more complicated cases
        such functions would be a source of falling tests.
        Suppose, that every static test data should have a static expected result data
        that was gotten via other source of data than java functions.
        This would give us an independent source of true and verify our functionality.

        In any case, it is a theme for project-to-project rules, hence done and re-written as you suggested.
         */
        //4 - evaluate results
        //JdiPage.metalsColorsPage.verifyResultSectionLogs(ResultsTemplates.FULL_TEMPLATE, ResultsHw7.RESULTS_HW_7);
        JdiPage.metalsColorsPage.verifyResultSectionLogs(ResultsTemplates.FULL_TEMPLATE, SubmitData.METALS_AND_COLORS_FORM_HW7);

    }

    @AfterSuite
    public void afterSuit() {
        WebDriverFactory.close();
    }
}
