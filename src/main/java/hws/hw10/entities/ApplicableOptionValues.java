package hws.hw10.entities;

import cucumber.api.java.uz.Бирок;

public enum ApplicableOptionValues {

    ENGLISH("en"),
    UKRAINIAN("uk"),
    RUSSIAN("ru"),
    PLAIN_TEXT("plain"),
    HTML_TEXT("html"),
    IGNORE_DIGITS("2"),
    IGNORE_URLS("4"),
    IGNORE_CAPITALIZATION("512"),
    FIND_REPEAT_WORDS("8");

    String option;

    ApplicableOptionValues(String option) {
        this.option = option;
    }

    @Override
    public String toString() {
        return option;
    }

}
