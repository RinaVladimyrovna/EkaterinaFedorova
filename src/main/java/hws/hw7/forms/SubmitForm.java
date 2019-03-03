package hws.hw7.forms;

import com.epam.jdi.light.elements.complex.Droplist;
import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.light.elements.pageobjects.annotations.objects.JDropdown;
import com.epam.jdi.light.elements.pageobjects.annotations.simple.Css;
import com.epam.jdi.light.ui.html.common.Button;
import com.epam.jdi.light.ui.html.complex.RadioButtons;

public class SubmitForm {

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

}
