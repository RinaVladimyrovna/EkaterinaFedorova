package hws.hw7.pages;

import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.simple.Css;
import hws.hw7.entities.ResultsTemplates;
import hws.hw7.entities.SubmitData;
import hws.hw7.forms.MetalAndColorPageForm;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class MetalAndColorPage extends WebPage {

    MetalAndColorPageForm form;

    @Css("ul[class = 'panel-body-list results']>li")
    private WebList resultSectionLogs;

    private String summarizeElements(List<String> elements) {

        String resultString = "";

        for (String el : elements) {
            if (!resultString.equals("")) {
                resultString += ", ";
            }
            resultString += el;
        }
        return resultString;
    }

    private List<String> addValue(List<String> expandedResult, String value) {
        expandedResult.add(value);
        return expandedResult;
    }

    private int calculateSumm(List<String> radioButtons) {

        int summ = 0;
        for (String el : radioButtons) {
            summ += Integer.valueOf(el);
        }
        return summ;
    }

    private List<String> prepareResults(SubmitData unpreparedResults) {

        List<String> result = new ArrayList<>();

        result.add(Integer.toString(calculateSumm(unpreparedResults.radioButtons)));
        result.add(summarizeElements(unpreparedResults.checkboxes));
        result = addValue(result, unpreparedResults.colorDropDown);
        result = addValue(result, unpreparedResults.metalDropDown);
        result.add(summarizeElements(unpreparedResults.vegetableDropDown));

        return result;
    }

    public void fillInForm(SubmitData data) {
        form.fillForm(data);
        form.submitForm();
    }
/*
    public void verifyResultSectionLogs(ResultsTemplates templates, ResultsHw7 results) {
        for (int i = 0; i < resultSectionLogs.size(); i++) {
            String logLine = resultSectionLogs.get(i).getText();
            String example = String.format(templates.getTemplates().get(i), results.getValues().get(i));
            assertThat(logLine, equalTo(example));
        }
    }
*/

    public void verifyResultSectionLogs(ResultsTemplates templates, SubmitData unpreparedResults) {

        List<String> result = prepareResults(unpreparedResults);

        for (int i = 0; i < resultSectionLogs.size(); i++) {
            String logLine = resultSectionLogs.get(i).getText();
            String example = String.format(templates.getTemplates().get(i), result.get(i));
            assertThat(logLine, equalTo(example));
        }
    }

}
