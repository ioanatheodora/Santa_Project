package fileio;

import enums.Category;
import enums.EnumConverter;

public class SantaGiftsInputData {
    private final String productName;
    private final Double price;
    private final Category category;
    private final int quantity;

    public SantaGiftsInputData(final String productName, final Double price,
                               final String category, final int quantity) {
        this.productName = productName;
        this.price = price;
        this.category = new EnumConverter(category).toCategory();
        this.quantity = quantity;
    }

    /**
     * Get the name of the gift
     * @return String - product name
     */
    public String getProductName() {
        return productName;
    }

    /**
     * Get the price of the gift
     * @return double - price
     */
    public Double getPrice() {
        return price;
    }

    /**
     * Get the category of a gift
     * @return String - category
     */
    public Category getCategory() {
        return category;
    }

    /**
     * Get the quantity of the specific gift
     * @return int - quantity
     */
    public int getQuantity() {
        return quantity;
    }

}
