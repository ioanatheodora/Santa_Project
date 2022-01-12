package children;

import enums.Category;
import enums.Cities;
import enums.ElvesType;
import santa.Visitor;

import java.util.ArrayList;

public class Kid extends Child {

    public Kid(final int id, final String lastName, final String firstName, final int age,
               final Cities city, final ArrayList<Double> niceScore,
               final Double niceScoreBonus, final ElvesType elfType,
               final ArrayList<Category> giftsPreferences) {
        super(id, lastName, firstName, age, city, niceScore, niceScoreBonus, elfType,
                giftsPreferences);
    }

    public Kid(final Child child) {
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
