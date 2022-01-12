package annualchanges;

import children.Child;
import enums.CityStrategyEnum;
import gifts.Gift;

import java.util.ArrayList;

public class AnnualChanges {
    private final Double budget;
    private final ArrayList<Gift> newGifts;
    private final ArrayList<Child> newChildren;
    private final ArrayList<ChildUpdate> childrenUpdates;
    private final CityStrategyEnum cityStrategy;

    /**
     * Get the new budget of the year
     * @return double - budget
     */
    public Double getBudget() {
        return budget;
    }

    /**
     * Get a list of the new gifts Santa adds to his list
     * @return ArrayList - new gifts
     */
    public ArrayList<Gift> getNewGifts() {
        return newGifts;
    }

    /**
     * Get a list of the new children Santa adds to his list
     * @return ArrayList - new children
     */
    public ArrayList<Child> getNewChildren() {
        return newChildren;
    }

    /**
     * Get a list of the children updates of the year
     * @return ArrayList - children updates
     */
    public ArrayList<ChildUpdate> getChildrenUpdates() {
        return childrenUpdates;
    }

    /**
     * Get the strategy of the current year
     * @return CityStrategyEnum - the strategy
     */
    public CityStrategyEnum getCityStrategy() {
        return cityStrategy;
    }

    public AnnualChanges(final double budget, final ArrayList<Gift> newGifts,
                         final ArrayList<Child> newChildren,
                         final ArrayList<ChildUpdate> childrenUpdates,
                         final CityStrategyEnum cityStrategy) {
        this.budget = budget;
        this.newGifts = newGifts;
        this.newChildren = newChildren;
        this.childrenUpdates = childrenUpdates;
        this.cityStrategy = cityStrategy;
    }
}
