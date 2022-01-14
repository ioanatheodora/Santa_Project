package santatodo;

import children.Child;
import common.Constants;
import enums.Category;
import fileio.Output;
import fileio.OutputAnnualChildren;
import fileio.Writer;
import gifts.AssignGift;
import gifts.Gift;
import santa.Santa;
import strategy.Strategy;
import strategy.StrategyFactory;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class ShareGifts {
    private final Santa santa;

    public ShareGifts(final Santa santa) {
        this.santa = santa;
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
            child.getValue().setAverageScore(child.getValue().accept(santa));

            // added the bonus to the average score
            child.getValue().setAverageScore(child.getValue().getAverageScore()
                    + (child.getValue().getNiceScoreBonus() * child.getValue().getAverageScore()
                            / Constants.ONE_HUNDRED));
            sumAverageScore += child.getValue().getAverageScore();
        }


        budgetUnit = santa.getBudget() / sumAverageScore;

        for (Map.Entry<Integer, Child> child : santa.getChildren().entrySet()) {
            // calculate the budget for every child
            Double childBudget = budgetUnit * child.getValue().getAverageScore();

            if (child.getValue().getElfStrategy() != null) {
                child.getValue().setBudget(child.getValue().getElfStrategy().
                        getAssignedBudget(childBudget));
            }
        }

        Strategy currentStrategy = StrategyFactory.createStrategy(
                santa.getCityStrategy());
        LinkedHashMap<Integer, Child> strategyChildren = currentStrategy
                .getOrderByStrategy(santa.getChildren());

        for (Map.Entry<Integer, Child> child : strategyChildren.entrySet()) {
            ArrayList<Gift> childGifts = new ArrayList<>();
            Double temporaryBudget = child.getValue().getBudget();

            for (Category category : santa.getChildren().get(child.getKey()).
                    getGiftsPreferences()) {
                // check whether the category from the child's list is part of Santa's List
                Gift receivedGift = new AssignGift(santa, category, temporaryBudget).
                        getCategoryGift();

                //we added the gift to the list of received gifts for the child
                if (receivedGift != null) {
                    temporaryBudget = temporaryBudget - receivedGift.getPrice();
                    childGifts.add(receivedGift);
                }
            }
            child.getValue().setReceivedGifts(childGifts);
        }

        // yellow elf
        for (Map.Entry<Integer, Child> child : strategyChildren.entrySet()) {
            child.getValue().getElfStrategy().additionalGifts(santa, child.getValue());
        }

        TreeMap<Integer, Child> order = null;
        order = currentStrategy.getOutputOrder(strategyChildren);


        for (Map.Entry<Integer, Child> child : order.entrySet()) {
            Child addResult = santa.getChildren().get(child.getKey());
            Output output = new Output(addResult.getId(), addResult.getLastName(),
                    addResult.getFirstName(), addResult.getCity().getValue(),
                    addResult.getAge(), addResult.getGiftsPreferences(),
                    child.getValue().getAverageScore(),
                    addResult.getNiceScore(), child.getValue().getBudget(),
                    child.getValue().getReceivedGifts());
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
