package strategy;

import children.Child;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.TreeMap;
import java.util.Map;

public class NiceScoreCity extends Strategy {
    /**
     * returns a linked hash map of children sorted by the city nice score the
     * child is from
     * @param children Treemap - children
     * @return LinkedHashMap - the new order of the children
     */
    @Override
    public LinkedHashMap<Integer, Child> getOrderByStrategy(final TreeMap<Integer,
            Child> children) {

        CalculateNiceScoreCity calculateNiceScoreCity = new CalculateNiceScoreCity(children);
        calculateNiceScoreCity.compute();

        ArrayList<Child> temporary = new ArrayList<>();
        LinkedHashMap<Integer, Child> newOrder = new LinkedHashMap<>();

        for (Map.Entry<Integer, Child> childEntry : children.entrySet()) {
            temporary.add(childEntry.getValue());
        }

        // the children are already sorted by id

        // sort the children by the name of the city
        temporary.sort((o1, o2) -> o1.getCity().getValue().compareTo(o2.getCity().getValue()));

        temporary.sort((o1, o2) -> Double.compare(o2.getNiceScoreCity(), o1.getNiceScoreCity()));

        for (Child child : temporary) {
            newOrder.put(child.getId(), child);
        }

        return newOrder;
    }
}
