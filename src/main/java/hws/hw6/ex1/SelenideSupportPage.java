package hws.hw6.ex1;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selectors;
import com.codeborne.selenide.SelenideElement;
import hws.hw6.ex1.ENUMs.CheckboxsList;
import hws.hw6.ex1.ENUMs.Colors;
import hws.hw6.ex1.ENUMs.Metals;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.page;

public class SelenideSupportPage {

    @FindBy(css = "[class='label-checkbox']")
    private ElementsCollection checkboxs;

    @FindBy(css = "[class='label-radio']")
    private ElementsCollection radioButtons;

    @FindBy(css = "[class='colors']")
    private SelenideElement colorList;

    @FindBy(css = "[class='uui-button']")
    private ElementsCollection buttons;

    @FindBy(css = "[id='mCSB_1']")
    private SelenideElement leftSection;

    @FindBy(css = "[name='log-sidebar']")
    private SelenideElement rightSection;

    @FindBy(css = "[class='panel-body-list logs'] li")
    private ElementsCollection rightSectionLogs;

    public SelenideSupportPage() {
        page(this);
    }

    public SelenideElement getRightSection() {
        return rightSection;
    }

    public SelenideElement getLeftSection() {
        return leftSection;
    }

    public ElementsCollection getCheckboxs() {
        return checkboxs;
    }

    public ElementsCollection getRadioButtons() {
        return radioButtons;
    }

    public SelenideElement getColorList() {
        return colorList;
    }

    public ElementsCollection getButtons() {
        return buttons;
    }

    public void selectCheckboxs(List<CheckboxsList> boxes) {

        for (CheckboxsList box : boxes) {
            checkboxs.findBy(text(box.toString())).click();
        }
    }

    public ElementsCollection getLogs() {
        return rightSectionLogs;
    }

    public void selectRadioButtons(Metals... buttons) {
        for (Metals button : buttons) {
            radioButtons.findBy(text(button.toString())).click();
        }
    }

    public void selectColor(Colors color) {
        colorList.click();
        colorList.$(Selectors.byText(color.toString())).click();
    }

}
