package strategy;

import enums.CityStrategyEnum;

public final class StrategyFactory {
    private StrategyFactory() {

    }

    /**
     * Creates an instance of the specified strategy type using Factory Design Pattern
     * @param strategyType CityStrategyEnum - strategy type
     * @return Strategy - an instance of the assigned strategy
     */
    public static Strategy createStrategy(final CityStrategyEnum strategyType) {
        switch (strategyType) {
            case ID: return new ID();
            case NICE_SCORE: return new NiceScore();
            case NICE_SCORE_CITY: return new NiceScoreCity();
            default: throw new IllegalArgumentException("The Strategy does not exist.");
        }
    }
}
