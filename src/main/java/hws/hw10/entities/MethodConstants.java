package hws.hw10.entities;

public enum MethodConstants {

    URL("https://speller.yandex.net/services/spellservice.json/checkTexts"),
    TEXT("text"),
    LANGUAGE("lang"),
    OPTIONS("options"),
    FORMAT("format");

    public String option;

    MethodConstants(String option) {
        this.option = option;
    }

    @Override
    public String toString() {
        return option;
    }

}
