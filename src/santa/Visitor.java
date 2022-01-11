package santa;

import children.Baby;
import children.Kid;
import children.Teen;

public interface Visitor {
    /**
     * Calculates the average Grade of the child
     * @param baby Baby - instance of the class Baby that represent a child that fits in the Baby
     *              category
     * @return Double - average Grade
     */
     Double visit(Baby baby);

    /**
     * Calculates the average Grade of the child
     *
     * @param kid Kid - instance of the class Baby that represent a child that fits in the Kid
     *                   category
     * @return Double - average Grade
     */
     Double visit(Kid kid);

    /**
     * Calculates the average Grade of the child
     * @param teen Teen - instance of the class Baby that represent a child that fits in the Teen
     *                    category
     * @return Double - average Grade
     */
     Double visit(Teen teen);
}
