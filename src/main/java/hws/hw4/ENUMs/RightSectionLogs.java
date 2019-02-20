package hws.hw4.ENUMs;

public enum RightSectionLogs {

    /* TODO Basically yes, you can store all of the logs rows as it is,
     but in some cases it might be better with template and runtime generation,
     For the example -
     METAL_LOG("metal: value changed to %s"),
     NATURE_ELEMENTS_LOG(" %s: condition changed to %s"),
    */

    // Done. Three new methods created with different signature to cover it.
    ELEMENT_LOG(" %s: condition changed to %s"),
    METAL_LOG("metal: value changed to %s"),
    COLOUR_LOG("Colors: value changed to %s");

    private String value;

    RightSectionLogs(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value.toUpperCase();
    }

}
