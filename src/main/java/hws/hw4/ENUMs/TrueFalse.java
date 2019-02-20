package hws.hw4.ENUMs;

public enum TrueFalse {

    TRUE("true"),
    FALSE("false");

    private String value;

    TrueFalse(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }

}
