package hws.hw6.ex2.ENUMs;

public enum ServiceListOptions {

    SUPPORT_PAGE_LINK("SUPPORT"),
    DATES_PAGE_LINK("DATES"),
    COMPLEX_TABLE_PAGE_LINK("COMPLEX TABLE"),
    SIMPLE_TABLE_PAGE_LINK("SIMPLE TABLE"),
    USER_TABLE_PAGE_LINK("USER TABLE"),
    TABLE_WITH_PAGES_PAGE_LINK("TABLE WITH PAGES"),
    DIFFERENT_ELEMENTS_PAGE_LINK("DIFFERENT ELEMENTS"),
    PERFORMANCE_PAGE_LINK("PERFORMANCE");

    private String value;

    ServiceListOptions(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }

}
