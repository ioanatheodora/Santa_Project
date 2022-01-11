package fileio;

public class SantaGiftsInputData {
    private String productName;
    private Double price;
    private String category;

    public SantaGiftsInputData(final String productName, final Double price,
                               final String category) {
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
     * Set the name of the gift
     * @param productName String - product name
     */
    public void setProductName(final String productName) {
        this.productName = productName;
    }

    /**
     * Get the price of the gift
     * @return double - price
     */
    public Double getPrice() {
        return price;
    }

    /**
     * Set the price of the gift
     * @param price double - price
     */
    public void setPrice(final Double price) {
        this.price = price;
    }

    /**
     * Get the category of a gift
     * @return String - category
     */
    public String getCategory() {
        return category;
    }

    /**
     * Set the category of a gift
     * @param category String - category
     */
    public void setCategory(final String category) {
        this.category = category;
    }
}
