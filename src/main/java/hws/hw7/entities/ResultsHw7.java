package hws.hw7.entities;

import java.util.Arrays;
import java.util.List;

public enum ResultsHw7 {

    RESULTS_HW_7(Arrays.asList("11", "Water, Fire", "Red", "Selen", "Cucumber, Tomato"));

    private List<String> values;

    public List<String> getValues() {
        return values;
    }

    ResultsHw7(List<String> values) {
        this.values = values;
    }
}
