package hws.hw4;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selectors;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import hws.hw4.ENUMs.Colors;
import hws.hw4.ENUMs.LoggingIn;
import hws.hw4.ENUMs.MainPage;
import hws.hw4.ENUMs.ServiceListOptions;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static hws.hw4.ENUMs.ServiceListOptions.values;
import static org.testng.Assert.assertEquals;

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

    public void verifyPageElements(int boxNumber, int radioNumber, int buttonNumber) {
        assertEquals(checkboxs.size(), boxNumber);
        assertEquals(radioButtons.size(), radioNumber);
        assertEquals(buttons.size(), buttonNumber);
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

    public void selectCheckboxs(String... boxes) {
        for (String box : boxes) {
            checkboxs.findBy(text(box)).click();
        }
    }

    public void verifyLogs(String... logs) {
        for (String log : logs) {
            rightSectionLogs.findBy(text(log)).shouldBe(visible);
            //.shouldHave(text(log)); probably
        }
    }

    public void selectRadioButtons(String... buttons) {
        for (String button : buttons) {
            radioButtons.findBy(text(button)).click();
        }
    }

    public void deselectCheckboxs(String... boxes) {
        selectCheckboxs(boxes);
        for (String box : boxes) {
            checkboxs.findBy(text(box)).shouldNotBe(checked);
        }
    }

    public void selectColor() {
        colorList.click();
        colorList.$(Selectors.byText(Colors.YELLOW.toString())).click();
    }

    public void closePage() {
        Selenide.close();
    }
}
