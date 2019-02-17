package hws.hw6;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import hws.hw6.ENUMs.Sliders;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;

public class SelenideDatesPage {

    @FindBy(css = "[class^='ui-slider-handle']")
    private ElementsCollection sliders;

    @FindBy(css = "[class='panel-body-list logs'] li")
    private ElementsCollection logs;

    @FindBy(css = "[class^='uui-slider']")
    private SelenideElement sliderRange;

    public void moveASlider(Sliders sliderIndex, int destination) {

        SelenideElement tip = sliders.get(Integer.valueOf(sliderIndex.toString()));
        int currentState = Integer.valueOf(tip.$("span").getText());
        float rangeSize = sliderRange.getSize().width / 100.0F;
        int endPosition = destination;

        //Just to avoid log problem regarding overlapping elements.
        //A bad way, I agree.
        //No way to do the same on production.
        //There would be a bug regarding current site behavior, since manual test leads to the same result.
        float diff = (endPosition - currentState) * rangeSize;
        Selenide.actions().clickAndHold(tip).moveByOffset(Math.round(diff) / 4, 0).release().perform();

        do {
            diff = (endPosition - currentState) * rangeSize;
            Selenide.actions().clickAndHold(tip).moveByOffset(Math.round(diff), 0).release().perform();
            currentState = Integer.valueOf(tip.$("span").getText());
        }
        while (currentState != endPosition);
    }

    public void verifyLogs(int destination) {
        logs.findBy(text(Integer.toString(destination))).shouldBe(visible);
    }

}
