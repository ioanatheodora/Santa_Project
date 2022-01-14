package elves;

import children.Child;
import common.Constants;
import santa.Santa;

public class BlackELf implements ElfStrategy {
    /**
     * Compute the budget accordingly to the black elf method of assigning the budget
     * @param budget Double - initial budget
     * @return Double - final budget
     */
    @Override
    public Double getAssignedBudget(final Double budget) {
        return budget - (budget * Constants.THIRTY / Constants.ONE_HUNDRED);
    }

    /**
     * Method necessarily implemented by the interface
     * The black elf does not share any additional gifts
     * @param santa Santa - Santa
     * @param child Child - child
     */
    @Override
    public void additionalGifts(final Santa santa, final Child child) {
        // the black elf does not add any additional gift
    }

}
