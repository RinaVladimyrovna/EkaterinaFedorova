package hws.hw7.pages;

import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.simple.Css;
import hws.hw7.entities.ResultsHw7;
import hws.hw7.entities.ResultsTemplates;
import hws.hw7.entities.SubmitData;
import hws.hw7.forms.MetalAndColorPageForm;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class MetalAndColorPage extends WebPage {

    MetalAndColorPageForm form;

    @Css("ul[class = 'panel-body-list results']>li")
    private WebList resultSectionLogs;

    public void fillInForm(SubmitData data) {
        form.fillForm(data);
        form.submitForm();
    }

    public void verifyResultSectionLogs(ResultsTemplates templates, ResultsHw7 results) {
        for (int i = 0; i < resultSectionLogs.size(); i++) {
            String logLine = resultSectionLogs.get(i).getText();
            String example = String.format(templates.getTemplates().get(i), results.getValues().get(i));
            assertThat(logLine, equalTo(example));
        }
    }

}
