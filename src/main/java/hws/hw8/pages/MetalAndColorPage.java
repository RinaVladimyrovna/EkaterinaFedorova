package hws.hw8.pages;

import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.simple.Css;
import hws.hw8.entities.ResultsTemplates;
import hws.hw8.entities.SubmitData;
import hws.hw8.forms.MetalAndColorPageForm;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class MetalAndColorPage extends WebPage {

    MetalAndColorPageForm form;

    @Css("ul[class = 'panel-body-list results']>li")
    private WebList resultSectionLogs;

    // TODO Basically, this method has no relation with PO, therefore it should not be here
    private String summarizeElements(List<String> elements) {
        // TODO Take a look on IDEA warning. It will be better with String::join or stream::collect
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

    // TODO Same story like summarizeElements method
    private int calculateSumm(List<String> radioButtons) {
        int summ = 0;
        for (String el : radioButtons) {
            summ += Integer.valueOf(el);
        }
        return summ;
    }

    // TODO Same story like summarizeElements method
    private List<String> prepareResults(SubmitData unpreparedResults) {

        List<String> result = new ArrayList<>();

        result.add(Integer.toString(calculateSumm(unpreparedResults.radioButtons)));
        result.add(summarizeElements(unpreparedResults.checkboxes));
        // TODO This is really uncommon approach for java. You should not write code in c/c++ style.
        result = addValue(result, unpreparedResults.colorDropDown);
        result = addValue(result, unpreparedResults.metalDropDown);
        result.add(summarizeElements(unpreparedResults.vegetableDropDown));

        return result;
    }

    public void fillInForm(SubmitData data) {
        form.fillForm(data);
        form.submitForm();
    }

    // TODO This method should be parametrise by SubmitData only.
    public void verifyResultSectionLogs(ResultsTemplates templates, SubmitData unpreparedResults) {

        List<String> result = prepareResults(unpreparedResults);

        // TODO What happen if you have an empty log ?
        for (int i = 0; i < resultSectionLogs.size(); i++) {
            String logLine = resultSectionLogs.get(i).getText();
            String example = String.format(templates.getTemplates().get(i), result.get(i));
            assertThat(logLine, equalTo(example));
        }
    }

}
