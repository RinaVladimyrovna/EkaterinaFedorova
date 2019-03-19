package hws.hw8;

import com.epam.jdi.light.driver.WebDriverFactory;
import com.epam.jdi.light.ui.html.PageFactory;
import hws.hw8.entities.ResultsTemplates;
import hws.hw8.entities.SubmitData;
import hws.hw8.entities.Users;
import hws.hw8.resourceFilesReference.FilesReference;
import hws.hw8.resourceFilesReference.JsonParser;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;

import static hws.hw8.entities.HeaderMenuItems.METALS_AND_COLORS_PAGE_OPTION;

public class JdiFormTest {

    @DataProvider
    private Object[][] simpleDataProvider() throws IOException {

        List<SubmitData> dataList = JsonParser.parseInputJson(FilesReference.INPUT_METALS_COLORS_DATA_SET.toString());
        Object[][] result = new Object[dataList.size()][2];
        int index = 0;

        // TODO What is the reason of foreach loop rather than fori ?
        // TODO Take a look on idea warning.
        for (SubmitData el : dataList) {
            result[index][0] = index;
            result[index][1] = dataList.get(index);
            index++;
        }

        return result;
    }

    @BeforeMethod(alwaysRun = true)
    public void beforeSuit() {
        PageFactory.initElements(JdiPage.class);
    }

    @Test(dataProvider = "simpleDataProvider")
    public void simpleJdiTest(int i, SubmitData data) {

        //1 - login as User
        JdiPage.indexPageJdi.open();
        JdiPage.indexPageJdi.login(Users.PITER);

        //2 - Open Metals & Colors page by Header menu
        JdiPage.indexPageJdi.navigateToPage(METALS_AND_COLORS_PAGE_OPTION);

        //3 - Fill in and submit a form
        JdiPage.metalsColorsPage.fillInForm(data);

        //4 - evaluate results
        JdiPage.metalsColorsPage.verifyResultSectionLogs(data);

    }

    @AfterMethod
    public void afterSuit() {
        WebDriverFactory.close();
    }
}
