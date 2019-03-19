package hws.hw8.pages;

import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.simple.Css;
import hws.hw8.entities.ResultsTemplates;
import hws.hw8.entities.SubmitData;
import hws.hw8.forms.MetalAndColorPageForm;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class MetalAndColorPage extends WebPage {

    MetalAndColorPageForm form;

    @Css("ul[class = 'panel-body-list results']>li")
    private WebList resultSectionLogs;

    // TODO Basically, this method has no relation with PO, therefore it should not be here
        // TODO Take a look on IDEA warning. It will be better with String::join or stream::collect
    // incorporated into the prepareResults method below

    // TODO Same story like summarizeElements method
    // Moved to SubmitData.java

    // TODO Same story like summarizeElements method
    // Moved to SubmitData.java

    public void fillInForm(SubmitData data) {
        form.fillForm(data);
        form.submitForm();
    }

    // TODO This method should be parametrise by SubmitData only.
    // Why?
    public void verifyResultSectionLogs(SubmitData unpreparedResults) {

        List<String> result = unpreparedResults.prepareResults(unpreparedResults);

        // TODO What happen if you have an empty log ?
        // There are several cases to use. Let's make the test falling in such a case.
        if (resultSectionLogs.size() < result.size()) {
            assertThat(resultSectionLogs.size(), equalTo(result.size()));
        } else {
            for (int i = 0; i < resultSectionLogs.size(); i++) {
                String logLine = resultSectionLogs.get(i).getText();
                String example = String.format(ResultsTemplates.FULL_TEMPLATE.getTemplates().get(i), result.get(i));
                assertThat(logLine, equalTo(example));
            }
        }
    }

}
