package hws.hw6.ENUMs;

public enum Sliders {

    LEFT_SLIDER("0"),
    RIGHT_SLIDER("1");

    private String value;

    Sliders(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value.toUpperCase();
    }

}
