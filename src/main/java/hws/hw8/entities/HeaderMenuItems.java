package hws.hw8.entities;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum HeaderMenuItems {

    // TODO This is not the links, as for me.
    //Made them options, since drop-down usually contains options or items
    HOME_PAGE_OPTION("HOME"),
    CONTACT_FORM_PAGE_OPTION("CONTACT FORM"),
    SERVICE_LIST_OPTIONS("SERVICE"),
    METALS_AND_COLORS_PAGE_OPTION("METALS & COLORS");

    private String value;

    @Override
    public String toString() {
        return value;
    }

}
