package hws.hw10.entities;

public enum MethodConstants {

    ENV_URL("https://speller.yandex.net/"),
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
