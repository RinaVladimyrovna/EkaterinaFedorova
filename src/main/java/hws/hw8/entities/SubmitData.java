package hws.hw8.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Getter
@AllArgsConstructor
public class SubmitData {

    public List<String> radioButtons;
    public List<String> checkboxes;
    public String colorDropDown;
    public String metalDropDown;
    public List<String> vegetableDropDown;

    private int calculateSumm() {
        int summ = 0;
        for (String el : this.radioButtons) {
            summ = Integer.sum(summ, Integer.parseInt(el));
        }
        return summ;
    }

    public List<String> prepareResults(SubmitData unpreparedResults) {

        List<String> result = new ArrayList<>();

        result.add(Integer.toString(calculateSumm()));
        result.add(String.join(", ", unpreparedResults.checkboxes));
        // TODO This is really uncommon approach for java. You should not write code in c/c++ style.
        // The last time the absence of this approach was called code duplication. Where are the borders?
        result.add(unpreparedResults.colorDropDown);
        result.add(unpreparedResults.metalDropDown);
        result.add(String.join(", ", unpreparedResults.vegetableDropDown));

        return result;
    }

}
