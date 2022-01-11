package gifts;


public class Gift {
    private final String productName;
    private final Double price;
    private final String category;

    public Gift(final Gift gift) {
        productName = gift.getProductName();
        price = gift.getPrice();
        category = gift.getCategory();
    }

    public Gift(final String productName, final Double price, final String category) {
        this.productName = productName;
        this.price = price;
        this.category = category;
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
    public String getCategory() {
        return category;
    }
}
