package strategy;

import children.Child;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public abstract class Strategy {
    /**
     * Get the order of the children by the specified strategy
     * @param children TreeMap - children
     * @return LinkedHashMap - children in the needed order to further share the gifts
     */
    public abstract LinkedHashMap<Integer, Child> getOrderByStrategy(TreeMap<Integer,
            Child> children);

    /**
     * Transfers the children from a LinkedHashMap to a TreeMap in order to be sorted
     * by id and be ready for the output
     * @param children LinkedHashMap - children in the order needed to share gifts
     * @return TreeMap - final order of the children
     */
    public TreeMap<Integer, Child> getOutputOrder(final LinkedHashMap<Integer, Child> children) {
        TreeMap<Integer, Child> finalOrder = new TreeMap<>();

        for (Map.Entry<Integer, Child> childEntry : children.entrySet()) {
            finalOrder.put(childEntry.getKey(), childEntry.getValue());
        }

        return finalOrder;
    }
}
