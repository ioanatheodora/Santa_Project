package strategy;

import children.Child;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class ID extends Strategy {
    /**
     * returns a linked hash map of children sorted by the children id
     * @param children Treemap - children
     * @return LinkedHashMap - the new order of the children
     */
    @Override
    public LinkedHashMap<Integer, Child> getOrderByStrategy(final TreeMap<Integer,
            Child> children) {
        LinkedHashMap newOrder = new LinkedHashMap();

        // added the children in the same order as in the initial HashMap
        for (Map.Entry<Integer, Child> child : children.entrySet()) {
            newOrder.put(child.getKey(), child.getValue());
        }

        return newOrder;
    }
}
