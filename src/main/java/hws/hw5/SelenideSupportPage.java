package hws.hw5;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selectors;
import com.codeborne.selenide.SelenideElement;
import hws.hw5.ENUMs.CheckboxsList;
import hws.hw5.ENUMs.Colors;
import hws.hw5.ENUMs.Metals;
import hws.hw5.ENUMs.RightSectionLogs;
import io.qameta.allure.Step;
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

    @Step("Verify that there is a correct number of page elements")
    public void verifyPageElements() {
        checkboxs.shouldHaveSize(4);
        radioButtons.shouldHaveSize(4);
        buttons.shouldHaveSize(2);
        checkVisibilityOfAllElements(checkboxs);
        checkVisibilityOfAllElements(radioButtons);
        checkVisibilityOfAllElements(buttons);
    }

    @Step("Verify that there is a left section")
    public void verifyRightSectionPresence() {
        rightSection.shouldBe(visible);
    }

    @Step("Verify that there is a right section")
    public void verifyLeftSectionPresence() {
        leftSection.shouldBe(visible);
    }

    @Step("Select checkboxes")
    public void selectCheckboxs(CheckboxsList... boxes) {
        for (CheckboxsList box : boxes) {
            checkboxs.findBy(text(box.toString())).click();
        }
    }

    @Step("Verify logs content")
    public void verifyLogs(RightSectionLogs... logs) {
        for (RightSectionLogs log : logs) {
            rightSectionLogs.findBy(text(log.toString())).shouldBe(visible);
        }
    }

    @Step("Select radio-buttons")
    public void selectRadioButtons(Metals... buttons) {
        for (Metals button : buttons) {
            radioButtons.findBy(text(button.toString())).click();
        }
    }

    @Step("Deselect checkboxes")
    public void deselectCheckboxs(CheckboxsList... boxes) {
        selectCheckboxs(boxes);
        for (CheckboxsList box : boxes) {
            checkboxs.findBy(text(box.toString())).shouldNotBe(checked);
        }
    }

    @Step("Expand drop-down with colour names and select {0} colour")
    public void selectColor(Colors color) {
        colorList.click();
        colorList.$(Selectors.byText(color.toString())).click();
    }

}
