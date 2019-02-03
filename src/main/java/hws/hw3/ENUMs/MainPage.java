package hws.hw3.ENUMs;

public enum MainPage {
    JDI_PAGE_URL("https://epam.github.io/JDI/index.html"),
    MAIN_PAGE_TITLE("Home Page"),
    MAIN_HEADER_TEXT("EPAM FRAMEWORK WISHES…"),
    ICON_TEXT_1("To include good practices\n" +
            "and ideas from successful\n" +
            "EPAM project"),
    ICON_TEXT_2("To be flexible and\n" +
            "customizable"),
    ICON_TEXT_3("To be multiplatform"),
    ICON_TEXT_4("Already have good base\n" +
            "(about 20 internal and\n" +
            "some external projects),\n" +
            "wish to get more…"),
    LOREM_IPSUM_TEXT("LOREM IPSUM DOLOR SIT AMET, CONSECTETUR ADIPISICING ELIT, SED DO EIUSMOD TEMPOR INCIDIDUNT " +
            "UT LABORE ET DOLORE MAGNA ALIQUA. UT ENIM AD MINIM VENIAM, QUIS NOSTRUD EXERCITATION ULLAMCO " +
            "LABORIS NISI UT ALIQUIP EX EA COMMODO CONSEQUAT DUIS AUTE IRURE DOLOR IN REPREHENDERIT IN " +
            "VOLUPTATE VELIT ESSE CILLUM DOLORE EU FUGIAT NULLA PARIATUR."),
    SUB_HEADER_TEXT("JDI GITHUB"),
    LINK_URL("https://github.com/epam/JDI");

    private String value;

    MainPage(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
