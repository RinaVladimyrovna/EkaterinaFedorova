package hws.hw7.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;
import java.util.List;

@Getter
@AllArgsConstructor
public enum ResultsHw7 {

    RESULTS_HW_7(Arrays.asList("11", "Water, Fire", "Red", "Selen", "Cucumber, Tomato"));

    private List<String> values;

}
