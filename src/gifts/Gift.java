package gifts;


import enums.Category;

public class Gift {
    private final String productName;
    private final Double price;
    private final Category category;
    private int quantity;

    public Gift(final Gift gift) {
        productName = gift.getProductName();
        price = gift.getPrice();
        category = gift.getCategory();
        quantity = gift.getQuantity();
    }

    public Gift(final String productName, final Double price, final Category category,
                final int quantity) {
        this.productName = productName;
        this.price = price;
        this.category = category;
        this.quantity = quantity;
    }

    /**
     * Get the quantity of the gift
     * @return int - quantity
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * Set the quantity of the gift
     * @param quantity int - quantity
     */
    public void setQuantity(final int quantity) {
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
     * @return Double - price of the gift
     */
    public Double getPrice() {
        return price;
    }

    /**
     * Get the category of the gift
     * @return String - category of the gift
     */
    public Category getCategory() {
        return category;
    }
}
