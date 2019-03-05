package hws.hw7.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;
import java.util.List;

@Getter
@AllArgsConstructor
public enum ResultsTemplates {

    FULL_TEMPLATE(Arrays.asList("Summary: %s", "Elements: %s", "Color: %s", "Metal: %s", "Vegetables: %s"));

    private List<String> templates;

}
