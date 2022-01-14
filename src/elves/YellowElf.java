package elves;

import children.Child;
import enums.Category;
import gifts.AssignGift;
import gifts.Gift;
import santa.Santa;

public class YellowElf implements ElfStrategy {
    /**
     * Compute the budget accordingly to the yellow elf method of assigning the budget
     * The yellow elf does not change the initial budget
     * @param budget Double - initial budget
     * @return Double - final budget
     */
    @Override
    public Double getAssignedBudget(final Double budget) {
        return budget;
    }

    /**
     * The yellow elf shares the cheapest gift from the child's favourite category
     * if the child did not get any and there is any gift of the specified kind
     * @param santa Santa - Santa
     * @param child Child - child
     */
    @Override
    public void additionalGifts(final Santa santa, final Child child) {
        // check whether the child received any gift
        // in case he didn't, we try to assign him one
        if (child.getReceivedGifts().size() == 0) {
            Category favoriteCategory = child.getGiftsPreferences().get(0);

            // we used santa's budget in order to be able to get any gift
            Gift receivedGift = new AssignGift(santa, favoriteCategory,
                    santa.getBudget()).getYellowElfGift();
            if (receivedGift != null) {
                child.getReceivedGifts().add(receivedGift);
            }
        }
    }
}
