package hws.hw5.ENUMs;

public enum CheckboxsList {

    WATER("Water"),
    EARTH("Earth"),
    WIND("Wind"),
    FIRE("Fire");

    private String value;

    CheckboxsList(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }

}
