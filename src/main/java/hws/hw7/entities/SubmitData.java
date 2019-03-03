package hws.hw7.entities;

import java.util.Arrays;
import java.util.List;

public enum SubmitData {

    METALS_AND_COLORS_FORM_HW7(Arrays.asList("3", "8"), Arrays.asList("Water", "Fire"), "Red",
            "Selen", Arrays.asList("Cucumber", "Tomato"));

    public final List<String> radioButtons;
    public final List<String> checkboxes;
    public final String colorDropDown;
    public final String metalDropDown;
    public final List<String> vegetableDropDown;

    public List<String> getRadioButtons() {
        return radioButtons;
    }

    public List<String> getCheckboxes() {
        return checkboxes;
    }

    public List<String> getVegetableDropDown() {
        return vegetableDropDown;
    }

    SubmitData(List<String> radioButtons, List<String> checkboxes, String colorDropDown, String metalDropDown, List<String> vegetableDropDown) {
        this.radioButtons = radioButtons;
        this.checkboxes = checkboxes;
        this.colorDropDown = colorDropDown;
        this.metalDropDown = metalDropDown;
        this.vegetableDropDown = vegetableDropDown;
    }

}
