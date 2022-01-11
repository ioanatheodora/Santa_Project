package children;

import santa.Visitor;

import java.util.ArrayList;

public class Teen extends Child {
    public Teen(final int id, final String lastName, final String firstName, final int age,
                final String city, final ArrayList<Double> niceScore,
                final ArrayList<String> giftsPreferences) {
        super(id, lastName, firstName, age, city, niceScore, giftsPreferences);
    }

    public Teen(final Child child) {
        super(child);
    }

    /**
     * Method used for Visitor Pattern
     * @param v Visitor
     */
    @Override
    public Double accept(final Visitor v) {
        return v.visit(this);
    }
}