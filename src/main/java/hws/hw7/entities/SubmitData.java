package hws.hw7.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;
import java.util.List;

// TODO !
@Getter
@AllArgsConstructor
public enum SubmitData {

    METALS_AND_COLORS_FORM_HW7(Arrays.asList("3", "8"), Arrays.asList("Water", "Fire"), "Red",
            "Selen", Arrays.asList("Cucumber", "Tomato"));

    public final List<String> radioButtons;
    public final List<String> checkboxes;
    public final String colorDropDown;
    public final String metalDropDown;
    public final List<String> vegetableDropDown;

}
