package santatodo;

import annualchanges.AnnualChanges;
import children.Baby;
import children.Child;
import children.Kid;
import children.Teen;
import annualchanges.ChildUpdate;
import common.Constants;
import gifts.Gift;
import santa.Santa;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

public class Update {
    public Update() { }


    /**
     * Creates an instance of one of the classes that inherits the class Child
     * depending on the age - Baby, Kid, Teen
     *
     * @param child - the previous instance of the Object
     * @return an instance of one of the classes stated above
     */
    public Child getChildCategory(final Child child) {
        if (child.getAge() < Constants.KID) {
            return new Baby(child);
        } else {
            if (child.getAge() < Constants.TEEN) {
                return new Kid(child);
            } else {
                if (child.getAge() <= Constants.YOUNG_ADULT) {
                    return new Teen(child);
                } else {
                    // The person is young adult, and we don't add him/her to the list
                    // of children
                    return null;
                }
            }
        }
    }

    /**
     * Adds the new Gift Preference to the Child's List of Gift Preferences
     * @param gift - the new category the child prefers
     * @param child - the child
     */
    public void addGift(final String gift, final Child child) {
        // verify firstly whether the category already exists and delete it if so
        for (int i = 0; i < child.getGiftsPreferences().size(); i++) {
            if (gift.equals(child.getGiftsPreferences().get(i))) {
                child.getGiftsPreferences().remove(i);
            }
        }
        // add the gift at the beginning of the list of gift preferences
        child.getGiftsPreferences().add(0, gift);
    }

    /**
     * Computes the updates received over a year
     *
     * @param santa - Santa
     * @param i
     */
    public void yearlyUpdate(final Santa santa, final int i) {
        AnnualChanges annualChange = santa.getAnnualChanges().get(i);
        TreeMap<Integer, Child> children = santa.getChildren();
        ArrayList<Gift> gifts = santa.getGifts();

        Iterator<Map.Entry<Integer, Child>> iterator = children.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Integer, Child> child = iterator.next();
            // increment the age and check in what category the child is
            child.getValue().setAge(child.getValue().getAge() + 1);
        }

        TreeMap<Integer, Child> temporary = new TreeMap<>();
        for (Child child : children.values()) {
            Child newChild = getChildCategory(child);
            if (newChild != null) {
                temporary.put(newChild.getId(), newChild);
            }
        }
        // create again the TreeMap containing the children after the update
        children.clear();
        santa.setChildren(temporary);

        // add the new children to the list
        for (Child child : annualChange.getNewChildren()) {
            Child newChild = getChildCategory(child);
            if (newChild != null) {
                santa.getChildren().put(newChild.getId(), newChild);
            }
        }

        // update the children information
        for (ChildUpdate childUpdate : annualChange.getChildrenUpdates()) {

            if (santa.getChildren().containsKey(childUpdate.getId())) {
                // add niceScore to the list of niceScores if any information given
                if (childUpdate.getNiceScore() >= 0d) {
                    santa.getChildren().get(childUpdate.getId()).getNiceScore().
                            add(childUpdate.getNiceScore());
                }

                // add gift preferences
                if (childUpdate.getGiftsPreferences() != null) {
                    for (int j = childUpdate.getGiftsPreferences().size() - 1; j >= 0; j--) {
                        // the gift preferences are taken in the reversed order to be added
                        // correctly in the list of gift preferences
                        String gift = childUpdate.getGiftsPreferences().get(j);
                        if (santa.getChildren().containsKey(childUpdate.getId())) {
                            addGift(gift, santa.getChildren().get(childUpdate.getId()));
                        }
                    }
                }
            }
        }

        // add the new gifts to Santa's List of gifts
        for (Gift gift :  annualChange.getNewGifts()) {
            gifts.add(gift);
        }

        // update the budget
        santa.setBudget(annualChange.getBudget());
    }
}
