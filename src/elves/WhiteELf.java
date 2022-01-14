package elves;

import children.Child;
import santa.Santa;

public class WhiteELf implements ElfStrategy {
    /**
     * Compute the budget accordingly to the white elf method of assigning the budget
     * The white elf does not change the initial budget
     * @param budget Double - initial budget
     * @return Double - final budget
     */
    @Override
    public Double getAssignedBudget(final Double budget) {
        return budget;
    }

    /**
     * Method necessarily implemented by the interface
     * The pink elf does not share any additional gifts
     * @param santa Santa - Santa
     * @param child Child - child
     */
    @Override
    public void additionalGifts(final Santa santa, final Child child) {
        // the white elf does not give any additional gifts
    }


}
