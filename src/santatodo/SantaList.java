package santatodo;

import common.Constants;
import fileio.AnnualChangesInputData;
import fileio.ChildrenInputData;
import fileio.ChildrenUpdatesInputData;
import fileio.Input;
import fileio.SantaGiftsInputData;
import santa.Santa;
import annualchanges.AnnualChanges;
import children.Baby;
import children.Child;
import children.Kid;
import children.Teen;
import annualchanges.ChildUpdate;
import enums.Category;
import gifts.Gift;

import java.util.ArrayList;

public class SantaList {
    private final Input input;

    public SantaList(final Input input) {
        this.input = input;
    }

    private static boolean containsCategory(final String test) {

        System.out.println(test);
        for (Category category : Category.values()) {
            System.out.println(category.toString());
            if (category.toString().equals(test)) {
                return true;
            }
        }

        return false;
    }

    /**
     * Compute the category the child is in based on its age
     * @param child an element of the list of children from the input data
     * @return an instance of the specific class the child takes part in and null if
     * he/she is over 18 years old
     */
    public Child getChildCategory(final ChildrenInputData child) {
        ArrayList<Double> niceScore = new ArrayList<>();
        niceScore.add(child.getNiceScore());

        if (child.getAge() < Constants.KID) {
            return new Baby(child.getId(), child.getLastName(), child.getFirstName(),
                    child.getAge(),  child.getCity(), niceScore, child.getGiftsPreferences());
        } else {
            if (child.getAge() < Constants.TEEN) {
                return new Kid(child.getId(), child.getLastName(),
                        child.getFirstName(), child.getAge(),  child.getCity(), niceScore,
                        child.getGiftsPreferences());
            } else {
                if (child.getAge() <= Constants.YOUNG_ADULT) {
                    return new Teen(child.getId(), child.getLastName(),
                            child.getFirstName(), child.getAge(),  child.getCity(), niceScore,
                            child.getGiftsPreferences());
                } else {
                     // The person is young adult and we don't add him/her to the list
                     // of children
                    return null;
                }
            }
        }
    }

    /**
     * Creates an instance of the class Gift that we are going to use further in the
     * project.
     * @param gift an element of the list of gifts given from input data
     * @return an instance of the class Gift
     */
    public Gift getGiftInstance(final SantaGiftsInputData gift) {
        return new Gift(gift.getProductName(), gift.getPrice(), gift.getCategory());
    }

    /**
     * Creates an instance of te class AnnualChanges that we are going to use further
     * in the problem
     * @param change an element from the list of annual changes given from the input data
     * @return an instance of the class AnnualChanges
     */
    public AnnualChanges getAnnualChangeInstance(final AnnualChangesInputData change) {
        ArrayList<Child> newChildren = new ArrayList<>();
        ArrayList<Gift> newGifts = new ArrayList<>();
        ArrayList<ChildUpdate> childrenUpdates = new ArrayList<>();

        for (ChildrenInputData child : change.getNewChildren()) {
            if (getChildCategory(child) != null)  {
                newChildren.add(getChildCategory(child));
            }
        }

        for (SantaGiftsInputData gift : change.getNewGifts()) {
            newGifts.add(getGiftInstance(gift));
        }

        for (ChildrenUpdatesInputData update : change.getChildrenUpdates()) {
            ChildUpdate childUpdate = new ChildUpdate(update.getId(), update.getNiceScore(),
                    update.getGiftPreferences());
            childrenUpdates.add(childUpdate);
        }

        return new AnnualChanges(change.getSantaBudget(), newGifts, newChildren, childrenUpdates);

    }

    /**
     * we are adding the data to Santa's List in order to compute further
     * the information
     * @param santa - Singleton parameter that represents Santa
     */
    public void add(final Santa santa) {
        santa.setNumberOfYears(input.getNumberOfYears());
        santa.setBudget(input.getSantaBudget());

         // We are adding the children to the list of children based on
         // the category they fit in by checking their age and creating the
         // right class
        for (ChildrenInputData child : input.getChildren()) {
                Child newChild = getChildCategory(child);
                if (newChild != null) {
                    santa.getChildren().put(newChild.getId(), newChild);
                }
        }

        for (SantaGiftsInputData gift : input.getSantaGifts()) {
            Gift newGift = getGiftInstance(gift);
            if (newGift != null) {
                santa.getGifts().add(newGift);
            }
        }

        for (AnnualChangesInputData change : input.getAnnualChanges()) {
            AnnualChanges annualChange = getAnnualChangeInstance(change);
            santa.getAnnualChanges().add(annualChange);
        }
    }
}
