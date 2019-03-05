package hws.hw7.entities;

public enum HeaderMenuItems {

    // TODO This is not the links, as for me.
    HOME_PAGE_LINK("HOME"),
    CONTACT_FORM_PAGE_LINK("CONTACT FORM"),
    SERVICE_LIST_OPTIONS("SERVICE"),
    METALS_AND_COLORS_PAGE_LINK("METALS & COLORS");

    private String value;

    HeaderMenuItems(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }

}
