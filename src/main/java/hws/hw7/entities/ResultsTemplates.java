package hws.hw7.entities;

import java.util.Arrays;
import java.util.List;

public enum ResultsTemplates {

    FULL_TEMPLATE(Arrays.asList("Summary: %s", "Elements: %s", "Color: %s", "Metal: %s", "Vegetables: %s"));

    private List<String> templates;

    public List<String> getTemplates() {
        return templates;
    }

    ResultsTemplates(List<String> templates) {
        this.templates = templates;
    }
}
