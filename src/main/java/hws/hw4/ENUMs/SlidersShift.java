package hws.hw4.ENUMs;

// TODO It is not make sense to store integers in enum
// TODO Slider can get range of values [0;100], you should not enum-it-all
public enum SlidersShift {

    LEFT_SLIDER("0"),
    RIGHT_SLIDER("1"),
    SHIFT_100("100"),
    SHIFT_0("0"),
    SHIFT_30("30"),
    SHIFT_70("70");

    private String value;

    SlidersShift(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }

}
