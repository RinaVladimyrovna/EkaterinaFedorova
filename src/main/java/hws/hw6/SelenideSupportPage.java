package hws.hw6;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selectors;
import com.codeborne.selenide.SelenideElement;
import hws.hw6.ENUMs.CheckboxsList;
import hws.hw6.ENUMs.Colors;
import hws.hw6.ENUMs.Metals;
import hws.hw6.ENUMs.RightSectionLogs;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static com.codeborne.selenide.Condition.*;
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

    private void checkVisibilityOfAllElements(ElementsCollection collection) {
        for (SelenideElement element : collection) {
            element.shouldBe(visible);
        }
    }

    public SelenideSupportPage() {
        page(this);
    }

    // TODO It is not really necessary to parametrise this one
    // Done. Just a thought to re use it for another pages with different elements number
    public void verifyPageElements() {
        checkboxs.shouldHaveSize(4);
        radioButtons.shouldHaveSize(4);
        buttons.shouldHaveSize(2);
        checkVisibilityOfAllElements(checkboxs);
        checkVisibilityOfAllElements(radioButtons);
        checkVisibilityOfAllElements(buttons);
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

    // TODO Most all of this methods should be parametrised by enum instead of String.
    // Done
    public void selectCheckboxs(List<CheckboxsList> boxes) {
        for (CheckboxsList box : boxes) {
            // TODO Nice attempt, but you have to use Selenide approach
            // TODO Take a look on ElementsCollection and method that allow you to do the variety of cool stuff
            // TODO Basically, you should not find elements in the OP method, use @FindBy
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

    // TODO Parameter ?
    // Done
    public void selectColor(Colors color) {
        colorList.click();
        colorList.$(Selectors.byText(color.toString())).click();
    }

}
