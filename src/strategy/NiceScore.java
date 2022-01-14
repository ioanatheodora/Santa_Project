package strategy;

import children.Child;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.TreeMap;
import java.util.Map;

public class NiceScore extends Strategy {
    /**
     * returns a linked hash map of children sorted by the children average score
     * @param children Treemap - children
     * @return LinkedHashMap - the new order of the children
     */
    @Override
    public LinkedHashMap<Integer, Child> getOrderByStrategy(final TreeMap<Integer,
            Child> children) {
        ArrayList<Child> temporary = new ArrayList<>();
        LinkedHashMap<Integer, Child> newOrder = new LinkedHashMap<>();

        for (Map.Entry<Integer, Child> childEntry : children.entrySet()) {
            temporary.add(childEntry.getValue());
        }

        // the children are already sorted by id, therefore it is only needed to sort them by
        // the average score of the current year

        temporary.sort((o1, o2) -> Double.compare(o2.getAverageScore(),  o1.getAverageScore()));

        for (Child child : temporary) {
            newOrder.put(child.getId(), child);
        }

        return newOrder;
    }
}
