package santatodo;

import children.Child;
import fileio.Output;
import fileio.OutputAnnualChildren;
import fileio.Writer;
import gifts.Gift;
import santa.Santa;

import java.util.ArrayList;
import java.util.Map;

public class ShareGifts {
    private final Santa santa;

    public ShareGifts(final Santa santa) {
        this.santa = santa;
    }

    /**
     * Finds a gift in Santa's list of gifts that fits into the given budget
     * and is in the given category. It also chooses the least expensive gift.
     *
     * @param category - the category the gift should be
     * @param budget - the budget the gift must fit into
     * @return returns an instance of the class Gift if there is a gift
     * found, or null otherwise
     */
    private Gift getCategoryGift(final String category, final double budget) {
        Gift givenGift = null;
        Gift smallest = null;
        Double smallestPrice = Double.MAX_VALUE;

        for (Gift gift : santa.getGifts()) {
            if (gift.getCategory().equals(category) && gift.getPrice() < budget
                && smallestPrice > gift.getPrice()) {
                smallest = gift;
                smallestPrice = gift.getPrice();
            }
        }

        // if the category is not found the smallest price will stay 0
        // if found, the smallest price will be the price of the gift
        if (smallest != null) {
            givenGift = new Gift(smallest);
        }
        return givenGift;
    }

    /**
     * Computes the steps needed to share gifts in a year by calculating every child's
     * average score, attributing a budget and finding gifts from the preferred categories
     *
     *  @param outputAnnualChildren - JSONObject
     */
    public void annualRound(final OutputAnnualChildren outputAnnualChildren) {
        Double sumAverageScore = 0.0;
        Double budgetUnit;

        // we calculate the average score of the children
        for (Map.Entry<Integer, Child> child : santa.getChildren().entrySet()) {
            sumAverageScore += child.getValue().accept(santa);
            child.getValue().setAverageScore(child.getValue().accept(santa));
        }


        budgetUnit = santa.getBudget() / sumAverageScore;
        for (Map.Entry<Integer, Child> child : santa.getChildren().entrySet()) {
            ArrayList<Gift> childGifts = new ArrayList<>();
            Double childBudget = budgetUnit * child.getValue().getAverageScore();
            Double temporaryBudget = childBudget;

            for (String category : santa.getChildren().get(child.getKey()).getGiftsPreferences()) {
                // check whether the category from the child's list is part of Santa's List
                Gift receivedGift = getCategoryGift(category, temporaryBudget);

                //we added the gift to the list of received gifts for the child
                if (receivedGift != null) {
                    temporaryBudget = temporaryBudget - receivedGift.getPrice();
                    childGifts.add(receivedGift);
                }
            }
            Child addResult = santa.getChildren().get(child.getKey());
            Output output = new Output(addResult.getId(), addResult.getLastName(),
                    addResult.getFirstName(), addResult.getCity(),
                    addResult.getAge(), addResult.getGiftsPreferences(),
                    child.getValue().getAverageScore(),
                    addResult.getNiceScore(), childBudget, childGifts);
            outputAnnualChildren.add(output.addResult());
        }



    }

    /**
     * Computes the steps needed to share gifts in the number of years given
     * @param file - Writer Object
     */
    public void share(final Writer file) {
        OutputAnnualChildren jsonChange = new OutputAnnualChildren();
        annualRound(jsonChange);
        jsonChange.children();

        for (int i = 0; i < santa.getNumberOfYears(); i++) {
            // update Santa's list
            Update update = new Update();
            update.yearlyUpdate(santa, i);
            annualRound(jsonChange);
            jsonChange.children();
        }

        jsonChange.add(file);
    }
}
