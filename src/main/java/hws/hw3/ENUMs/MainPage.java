package hws.hw3.ENUMs;

public enum MainPage {

    JDI_PAGE_URL("https://epam.github.io/JDI/index.html"),
    MAIN_PAGE_TITLE("Home Page"),
    MAIN_HEADER_TEXT("EPAM FRAMEWORK WISHES…"),
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
