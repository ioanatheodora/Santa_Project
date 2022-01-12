package enums;

public class EnumConverter {

    private final String text;

    public EnumConverter(final String text) {
        this.text = text;
    }

    /**
     * Converts a String to a constant of Category Enum
     * @return Category - the category of a gift
     */
    public Category toCategory() {
        Category currentCategory = null;

        for (Category category : Category.values()) {
            if (category.getValue().equals(text)) {
                currentCategory = category;
            }
        }

        return currentCategory;
    }

    /**
     * Converts a String to a constant of a Cities Enum
     * @return Citites - a city
     */
    public Cities toCities() {
        Cities currentCity = null;

        for (Cities city : Cities.values()) {
            if (city.getValue().equals(text)) {
                currentCity = city;
            }
        }

        return currentCity;
    }

    /**
     * Converts a String to a constant of CityStrategyEnum Enum
     * @return CityStrategyEnum - the strategy of the current year
     */
    public CityStrategyEnum toCityStrategyEnum() {
        CityStrategyEnum currentStrategy = null;

        for (CityStrategyEnum strategy : CityStrategyEnum.values()) {
            if (strategy.getValue().equals(text)) {
                currentStrategy = strategy;
            }
        }

        return currentStrategy;
    }

    /**
     * Converts a String to a constant of a ElvesType Enum
     * @return ElvesType - the type of the elf
     */
    public ElvesType toElvesType() {
        ElvesType currentElf = null;

        for (ElvesType type : ElvesType.values()) {
            if (type.getValue().equals(text)) {
                currentElf = type;
            }
        }

        return currentElf;
    }
}
