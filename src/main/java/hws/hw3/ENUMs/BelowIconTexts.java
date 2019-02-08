package hws.hw3.ENUMs;

public enum BelowIconTexts {

    ICON_TEXT_1("To include good practices\n" +
            "and ideas from successful\n" +
            "EPAM project"),
    ICON_TEXT_2("To be flexible and\n" +
            "customizable"),
    ICON_TEXT_3("To be multiplatform"),
    ICON_TEXT_4("Already have good base\n" +
            "(about 20 internal and\n" +
            "some external projects),\n" +
            "wish to get more…");

    private String value;

    BelowIconTexts(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }

}
