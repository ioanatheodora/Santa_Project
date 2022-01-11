package fileio;

import java.util.ArrayList;

public class AnnualChangesInputData {
    private Double santaBudget;
    private ArrayList<SantaGiftsInputData> newGifts;
    private ArrayList<ChildrenInputData> newChildren;
    private ArrayList<ChildrenUpdatesInputData> childrenUpdates;

    public AnnualChangesInputData(final Double santaBudget,
                                  final ArrayList<SantaGiftsInputData> newGifts,
                                  final ArrayList<ChildrenInputData> newChildren,
                                  final ArrayList<ChildrenUpdatesInputData> childrenUpdates) {
        this.santaBudget = santaBudget;
        this.newGifts = newGifts;
        this.newChildren = newChildren;
        this.childrenUpdates = childrenUpdates;
    }

    /**
     * Get the new budget of the year
     * @return double - budget
     */
    public Double getSantaBudget() {
        return santaBudget;
    }

    /**
     * Set the new budget of the year
     * @param santaBudget double - budget
     */
    public void setSantaBudget(final Double santaBudget) {
        this.santaBudget = santaBudget;
    }

    /**
     * Get a list of the new gifts Santa adds to his list
     * @return ArrayList - new gifts
     */
    public ArrayList<SantaGiftsInputData> getNewGifts() {
        return newGifts;
    }

    /**
     * Set a list of the new gifts Santa adds to his list
     * @param newGifts ArrayList - new gifts
     */
    public void setNewGifts(final ArrayList<SantaGiftsInputData> newGifts) {
        this.newGifts = newGifts;
    }

    /**
     * Get a list of the new children Santa adds to his list
     * @return ArrayList - new children
     */
    public ArrayList<ChildrenInputData> getNewChildren() {
        return newChildren;
    }

    /**
     * Set a list of the new children Santa adds to his list
     * @param newChildren ArrayList - new children
     */
    public void setNewChildren(final ArrayList<ChildrenInputData> newChildren) {
        this.newChildren = newChildren;
    }

    /**
     * Get a list of the children updates of the year
     * @return ArrayList - children updates
     */
    public ArrayList<ChildrenUpdatesInputData> getChildrenUpdates() {
        return childrenUpdates;
    }

    /**
     * Set a list of the children updates of the year
     * @param childrenUpdates ArrayList - children updates
     */
    public void setChildrenUpdates(final ArrayList<ChildrenUpdatesInputData> childrenUpdates) {
        this.childrenUpdates = childrenUpdates;
    }
}
