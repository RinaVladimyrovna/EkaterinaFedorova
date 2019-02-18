package hws.hw6.ex1.ENUMs;

public enum Colors {

    RED("Red"),
    GREEN("Green"),
    BLUE("Blue"),
    YELLOW("Yellow");

    private String value;

    Colors(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }

}
