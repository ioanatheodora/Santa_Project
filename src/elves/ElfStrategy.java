package elves;

import children.Child;
import santa.Santa;

public interface ElfStrategy {
    /**
     * Compute the budget accordingly to the elf method of assigning the budget
     * @param budget Double - initial budget
     * @return DOuble - final budget
     */
    Double getAssignedBudget(Double budget);

    /**
     * Assign any additional gifts if necessary accordingly to the type of elf
     * @param santa Santa - santa
     * @param child Child - child
     */
    void additionalGifts(Santa santa, Child child);
}
