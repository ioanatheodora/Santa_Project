package fileio;

import java.util.List;

public class Input {
    private final int numberOfYears;
    private final Double santaBudget;
    private final List<ChildrenInputData> children;
    private final List<SantaGiftsInputData> santaGifts;
    private final List<AnnualChangesInputData> annualChanges;


    public Input() {
        this.numberOfYears = 0;
        this.santaBudget = 0d;
        this.children = null;
        this.santaGifts = null;
        this.annualChanges = null;
    }

    public Input(final int numberOfYears, final Double santaBudget,
                 final List<ChildrenInputData> children,
                 final List<SantaGiftsInputData> santaGifts,
                 final List<AnnualChangesInputData> annualChanges) {
        this.numberOfYears = numberOfYears;
        this.santaBudget = santaBudget;
        this.children = children;
        this.santaGifts = santaGifts;
        this.annualChanges = annualChanges;
    }

    /**
     * Get the number of years the actions will be performed further
     * @return int - number of years
     */
    public int getNumberOfYears() {
        return numberOfYears;
    }

    /**
     * Get the budget for the initial year
     * @return int - budget
     */
    public Double getSantaBudget() {
        return santaBudget;
    }

    /**
     * Get the list of children
     * @return List - initial children
     */
    public List<ChildrenInputData> getChildren() {
        return children;
    }

    /**
     * Get the list of gifts
     * @return List - initial gifts
     */
    public List<SantaGiftsInputData> getSantaGifts() {
        return santaGifts;
    }

    /**
     * Get the list of annual changes
     * @return List - annual changes
     */
    public List<AnnualChangesInputData> getAnnualChanges() {
        return annualChanges;
    }
}
