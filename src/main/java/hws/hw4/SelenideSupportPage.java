package hws.hw4;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selectors;
import com.codeborne.selenide.SelenideElement;
import hws.hw4.ENUMs.*;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Condition.*;

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

    // It is not really necessary to parametrise this one
    // Done. Just a thought to re use it for another pages with different elements number
    public void verifyPageElements() {
        checkboxs.shouldHaveSize(4);
        radioButtons.shouldHaveSize(4);
        buttons.shouldHaveSize(2);
        checkVisibilityOfAllElements(checkboxs);
        checkVisibilityOfAllElements(radioButtons);
        checkVisibilityOfAllElements(buttons);
    }

    public void verifyRightSectionPresence() {
        rightSection.shouldBe(visible);
    }

    public void verifyLeftSectionPresence() {
        leftSection.shouldBe(visible);
    }

    public void selectCheckboxs(CheckboxsList... boxes) {
        for (CheckboxsList box : boxes) {
            checkboxs.findBy(text(box.toString())).click();
        }
    }

    public void verifyLogs(RightSectionLogs... logs) {
        for (RightSectionLogs log : logs) {
            rightSectionLogs.findBy(text(log.toString())).shouldBe(visible);
        }
    }

    public void selectRadioButtons(Metals... buttons) {
        for (Metals button : buttons) {
            radioButtons.findBy(text(button.toString())).click();
        }
    }

    public void deselectCheckboxs(CheckboxsList... boxes) {
        selectCheckboxs(boxes);
        for (CheckboxsList box : boxes) {
            checkboxs.findBy(text(box.toString())).shouldNotBe(checked);
        }
    }

    public void selectColor(Colors color) {
        colorList.click();
        colorList.$(Selectors.byText(color.toString())).click();
    }

}
