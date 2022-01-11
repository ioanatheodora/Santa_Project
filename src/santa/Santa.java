package santa;

import annualchanges.AnnualChanges;
import children.Baby;
import children.Child;
import children.Kid;
import children.Teen;
import common.Constants;
import enums.Cities;
import gifts.Gift;

import java.util.ArrayList;
import java.util.TreeMap;


public final class Santa implements Visitor {
    private static Santa instance = null;
    private int numberOfYears;
    private Double budget;
    private TreeMap<Integer, Child> children = new TreeMap();
    private ArrayList<Gift> gifts = new ArrayList<>();
    private ArrayList<Cities> cities = new ArrayList<>();
    private ArrayList<AnnualChanges> annualChanges = new ArrayList<>();

    /**
     * Get the Santa's list of gifts
     * @return ArrayList - list of gifts
     */
    public ArrayList<Gift> getGifts() {
        return gifts;
    }

    /**
     * Set Santa's list of gifts
     * @param gifts ArrayList - list of gifts
     */
    public void setGifts(final ArrayList<Gift> gifts) {
        this.gifts = gifts;
    }

    /**
     * Get the cities Santa visits
     * @return ArrayList - list of cities
     */
    public ArrayList<Cities> getCities() {
        return cities;
    }

    /**
     * Set the cities Santa visits
     * @param cities ArrayList - list of cities
     */
    public void setCities(final ArrayList<Cities> cities) {
        this.cities = cities;
    }

    /**
     * Get the annual changes
     * @return ArrayList - list of annual changes
     */
    public ArrayList<AnnualChanges> getAnnualChanges() {
        return annualChanges;
    }

    /**
     * Set the annual changes
     * @param annualChanges ArrayList - list of annual changes
     */
    public void setAnnualChanges(final ArrayList<AnnualChanges> annualChanges) {
        this.annualChanges = annualChanges;
    }

    /**
     * Get the number of years which th actions will be performed on
     * @return int - number of years
     */
    public int getNumberOfYears() {
        return numberOfYears;
    }

    /**
     * Set the number of years which th actions will be performed on
     * @param numberOfYears int - number of years
     */
    public void setNumberOfYears(final int numberOfYears) {
        this.numberOfYears = numberOfYears;
    }

    /**
     * Get the budget Santa has for the initial year
     * @return  Double - budget
     */
    public Double getBudget() {
        return budget;
    }

    /**
     * Set the budget Santa has for the initial year
     * @param budget Double - budget
     */
    public void setBudget(final Double budget) {
        this.budget = budget;
    }

    /**
     * Get a tree map that represent the children as it follows:
     * Key - child's id and Value - child's data
     * Used a tree map in order to have the children arranged by the id and acces the
     * id easily
     * @return TreeMap - list of children
     */
    public TreeMap<Integer, Child> getChildren() {
        return children;
    }

    /**
     * Set a tree map that represents the children in the initial year
     * @param children Treemap - list of children
     */
    public void setChildren(final TreeMap<Integer, Child> children) {
        this.children = children;
    }


    private Santa() {

    }

    /**
     * It creates an instance of the class Santa if it hasn't been created one previously
     * Method used for Singleton Design Pattern
     * @return Santa - instance of the class Santa or null in case it already exists
     */
    public static Santa getInstance() {
        if (instance == null) {
            instance = new Santa();
        }
        return instance;
    }

    /**
     * Calculates the average Grade of the child
     * @param baby Baby - instance of the class Baby that represent a child that fits in the Baby
     *              category
     * @return Double - average Grade
     */
    @Override
    public Double visit(final Baby baby) {
        return Constants.TEN;
    }

    /**
     * Calculates the average Grade of the child
     *
     * @param kid Kid - instance of the class Baby that represent a child that fits in the Kid
     *                    category
     * @return Double - average Grade
     */
    @Override
    public Double visit(final Kid kid) {
        Double average = 0.0;
        for (Double score : kid.getNiceScore()) {
            average += score;
        }
        average = average / kid.getNiceScore().size();
        return average;
    }

    /**
     * Calculates the average Grade of the child
     * @param teen Teen - instance of the class Baby that represent a child that fits in the Teen
     *                    category
     * @return Double - average Grade
     */
    @Override
    public Double visit(final Teen teen) {
        Double average = 0.0;
        for (int i = 0; i < teen.getNiceScore().size(); i++) {
            average += (i + 1) * teen.getNiceScore().get(i);
        }
        average = average / ((teen.getNiceScore().size()
                * (teen.getNiceScore().size() + 1)) / 2);
        return average;
    }
}
