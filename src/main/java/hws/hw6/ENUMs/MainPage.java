package hws.hw6.ENUMs;

public enum MainPage {

    JDI_PAGE_URL("https://epam.github.io/JDI/index.html"),
    MAIN_PAGE_TITLE("Home Page");

    private String value;

    MainPage(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }

}
