package hws.hw8.forms;

import com.epam.jdi.light.elements.complex.Droplist;
import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.light.elements.composite.Form;
import com.epam.jdi.light.elements.pageobjects.annotations.objects.JDropdown;
import com.epam.jdi.light.elements.pageobjects.annotations.simple.Css;
import com.epam.jdi.light.ui.html.common.Button;
import com.epam.jdi.light.ui.html.complex.RadioButtons;
import hws.hw8.entities.SubmitData;

public class MetalAndColorPageForm extends Form<SubmitData> {

    @Css("[class='horizontal-group']>p")
    private RadioButtons radioButtons;

    @Css("[class='vertical-group']>p")
    private WebList checkboxes;

    @JDropdown(root = "#colors", value = ".filter-option", list = "li", expand = ".caret")
    private Droplist colorDropDown;

    @JDropdown(root = "#metals", value = ".filter-option", list = "li", expand = ".caret")
    private Droplist metalDropDown;

    @JDropdown(root = "#salad-dropdown", value = ".dropdown-toggle", list = "li", expand = ".caret")
    private Droplist vegetableDropDown;

    @Css("#calculate-button")
    private Button calculateButton;

    @Css("#submit-button")
    private Button submitButton;

    private void makeVegetableDropDownClean() {
        vegetableDropDown.select(vegetableDropDown.getSelected());
    }

    public void fillForm(SubmitData data) {
        data.getRadioButtons().forEach(button -> radioButtons.select(button));
        data.getCheckboxes().forEach(box -> checkboxes.select(box));
        makeVegetableDropDownClean();
        data.getVegetableDropDown().forEach(element -> vegetableDropDown.select(element));
        metalDropDown.select(data.metalDropDown);
        colorDropDown.select(data.colorDropDown);
    }

    public void submitForm() {
        submitButton.click();
    }

}
