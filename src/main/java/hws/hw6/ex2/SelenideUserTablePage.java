package hws.hw6.ex2;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Selenide.page;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class SelenideUserTablePage {

    @FindBy(css = "select")
    private ElementsCollection dropDowns;

    @FindBy(css = "input[type='checkbox']")
    private ElementsCollection checkboxes;

    @FindBy(css = "div.user-descr>span")
    private ElementsCollection descriptions;

    @FindBy(css = "td>a[href='']")
    private ElementsCollection names;

    @FindBy(css = "img:not([id])")
    private ElementsCollection images;

    @FindBy(css = "ul[class='panel-body-list logs']>li")
    private ElementsCollection logs;

    @FindBy(css = "td:first-child")
    private ElementsCollection rowNumbers;

    public SelenideUserTablePage() {
        page(this);
    }

    public ElementsCollection getDropDowns() {
        return dropDowns;
    }

    public ElementsCollection getCheckboxes() {
        return checkboxes;
    }

    public ElementsCollection getDescriptions() {
        return descriptions;
    }

    public ElementsCollection getNames() {
        return names;
    }

    public ElementsCollection getImages() {
        return images;
    }

    public ElementsCollection getLogs() {
        return logs;
    }

    public String getPageTitle() {
        return getWebDriver().getTitle();
    }

    public ElementsCollection getRowNumbers() {
        return rowNumbers;
    }

    public void selectAnCheckbox(String name) {
        int index = names.indexOf(names.findBy(Condition.text(name)));
        checkboxes.get(index).click();
    }

    public void expandDropDown(String name) {
        int index = names.indexOf(names.findBy(Condition.text(name)));
        dropDowns.get(index).click();
    }

    public ElementsCollection getDropDownOptions(String name) {
        int index = names.indexOf(names.findBy(Condition.text(name)));
        return dropDowns.get(index).$$(By.cssSelector("option"));
    }

}
