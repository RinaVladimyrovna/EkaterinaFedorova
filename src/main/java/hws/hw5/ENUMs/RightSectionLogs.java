package hws.hw5.ENUMs;

public enum RightSectionLogs {

    WIND_TRUE_LOG(" Wind: condition changed to true"),
    WATER_TRUE_LOG(" Water: condition changed to true"),
    EARTH_TRUE_LOG(" Earth: condition changed to true"),
    FIRE_TRUE_LOG(" Fire: condition changed to true"),
    GOLD_LOG("metal: value changed to Gold"),
    SILVER_LOG("metal: value changed to Silver"),
    BRONZE_LOG("metal: value changed to Bronze"),
    SELEN_LOG("metal: value changed to Selen"),
    YELLOW_LOG("Colors: value changed to Yellow"),
    RED_LOG("Colors: value changed to Red"),
    GREEN_LOG("Colors: value changed to Green"),
    BLUE_LOG("Colors: value changed to Blue"),
    WIND_FALSE_LOG(" Wind: condition changed to false"),
    WATER_FALSE_LOG(" Water: condition changed to false"),
    EARTH_FALSE_LOG(" Earth: condition changed to false"),
    FIRE_FALSE_LOG(" Fire: condition changed to false");

    private String value;

    RightSectionLogs(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value.toUpperCase();
    }

}
