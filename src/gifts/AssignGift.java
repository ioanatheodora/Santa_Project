package gifts;

import enums.Category;
import santa.Santa;

public class AssignGift {
    private final Santa santa;
    private final Category category;
    private final Double budget;

    public AssignGift(final Santa santa, final Category category,
                      final Double budget) {
        this.santa = santa;
        this.category = category;
        this.budget = budget;
    }

    /**
     * Finds a gift in Santa's list of gifts that fits into the given budget
     * and is in the given category. It also chooses the least expensive gift.
     *
     * @return returns an instance of the class Gift if there is a gift
     * found, or null otherwise
     */
    public Gift getCategoryGift() {
        Gift givenGift = null;
        Gift smallest = null;
        Double smallestPrice = Double.MAX_VALUE;

        for (Gift gift : santa.getGifts()) {
            if (gift.getCategory() == category && gift.getPrice() < budget
                    && smallestPrice > gift.getPrice() && gift.getQuantity() > 0) {
                smallest = gift;
                smallestPrice = gift.getPrice();
            }
        }

       for (Gift gift : santa.getGifts()) {
           if (gift.getPrice() == smallestPrice) {
               gift.setQuantity(gift.getQuantity() - 1);
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
     * Finds the gift from the child's favourite category that is the least expensive
     * If there aren't any gifts from that category or if there aren't any left gifts,
     * the elf does not give the child any gift
     *
     * @return returns an instance of the class Gift if there is a gift
     * found, or null otherwise
     */
    public Gift getYellowElfGift() {
        Gift givenGift = null;
        Gift smallest = null;
        Double smallestPrice = Double.MAX_VALUE;

        for (Gift gift : santa.getGifts()) {
            if (gift.getCategory() == category && gift.getPrice() < budget
                    && smallestPrice > gift.getPrice()) {
                smallest = gift;
                smallestPrice = gift.getPrice();
            }
        }

        for (Gift gift : santa.getGifts()) {
            if (gift.getPrice() == smallestPrice  && smallest.getQuantity() != 0) {
                gift.setQuantity(gift.getQuantity() - 1);
            }
        }

        // if the category is not found the smallest price will stay 0
        // if found, the smallest price will be the price of the gift
        if (smallest != null  && smallest.getQuantity() != 0) {
            givenGift = new Gift(smallest);
        }
        return givenGift;
    }

}
