package hws.hw4.ENUMs;

public enum ServiceListOptions {

    ITEM_1("SUPPORT"),
    ITEM_2("DATES"),
    ITEM_3("COMPLEX TABLE"),
    ITEM_4("SIMPLE TABLE"),
    ITEM_5("USER TABLE"),
    ITEM_6("TABLE WITH PAGES"),
    ITEM_7("DIFFERENT ELEMENTS"),
    ITEM_8("PERFORMANCE");

    private String value;

    ServiceListOptions(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }

}
