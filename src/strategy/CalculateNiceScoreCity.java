package strategy;

import children.Child;
import enums.Cities;

import java.util.Map;

public class CalculateNiceScoreCity {
    private final Map<Integer, Child> children;

    public CalculateNiceScoreCity(final Map<Integer, Child> children) {
        this.children = children;
    }

    /**
     * Computes the nice score of the city and sets the score to the niceScoreCity field
     */
    public void compute() {
        for (Cities city : Cities.values()) {
            // calculate the niceScoreCity for every city
            Double niceScoreSum = 0d;
            int numberOfChildren = 0;

            for (Child child : children.values()) {
                if (child.getCity() == city) {
                    niceScoreSum += child.getAverageScore();
                    numberOfChildren++;
                }
            }

            niceScoreSum = niceScoreSum / numberOfChildren;

            // set the NiceScoreCity for every child
            for (Child child : children.values()) {
                if (child.getCity() == city) {
                    child.setNiceScoreCity(niceScoreSum);
                }
            }
        }
    }

}
