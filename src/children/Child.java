package children;

import gifts.Gift;

import java.util.ArrayList;

public abstract class Child implements Visitable {
    private int id;
    private String lastName;
    private String firstName;
    private int age;
    private String city;
    private Double averageScore;
    private ArrayList<Double> niceScore;
    private ArrayList<String> giftsPreferences;
    private ArrayList<Gift> receivedGifts = new ArrayList<>();

    public Child(final int id, final String lastName, final String firstName, final int age,
                 final String city, final ArrayList<Double> niceScore,
                 final ArrayList<String> giftsPreferences) {
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.age = age;
        this.city = city;
        this.niceScore = niceScore;
        this.giftsPreferences = giftsPreferences;
    }

    public Child(final Child child) {
        this.id = child.getId();
        this.lastName = child.getLastName();
        this.firstName = child.getFirstName();
        this.age = child.getAge();
        this.city = child.getCity();
        this.niceScore = child.getNiceScore();
        this.giftsPreferences = child.getGiftsPreferences();
    }

    /**
     * Get the child's id
     * @return int - the child's id
     */
    public int getId() {
        return id;
    }

    /**
     * Sets the child's id
     * @param id int - the child's id
     */
    public void setId(final int id) {
        this.id = id;
    }

    /**
     * Get the child's last name
     * @return a String - last name
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Set the child's last name
     * @param lastName a String - last name
     */
    public void setLastName(final String lastName) {
        this.lastName = lastName;
    }

    /**
     * Get the child's first name
     * @return a string - first name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Set the child's first name
     * @param firstName a String - first name
     */
    public void setFirstName(final String firstName) {
        this.firstName = firstName;
    }

    /**
     * Get the child's age
     * @return int - age
     */
    public int getAge() {
        return age;
    }

    /**
     * Set the child's age
     * @param age int - age
     */
    public void setAge(final int age) {
        this.age = age;
    }

    /**
     * Get the city the child is from
     * @return String - city
     */
    public String getCity() {
        return city;
    }

    /**
     * Set the city the child is from
     * @param city String - city
     */
    public void setCity(final String city) {
        this.city = city;
    }

    /**
     * Get the child's list of nice scores
     * @return ArrayList - list of nice scores
     */
    public ArrayList<Double> getNiceScore() {
        return niceScore;
    }

    /**
     * Set the child's list of nice scores
     * @param niceScore ArrayList - list of nice scores
     */
    public void setNiceScore(final ArrayList<Double> niceScore) {
        this.niceScore = niceScore;
    }


    /**
     * Get the list of gifts the child receives
     * @return ArrayList - list of gifts
     */
    public ArrayList<Gift> getReceivedGifts() {
        return receivedGifts;
    }

    /**
     * Sets the list of gifts the child receives
     * @param receivedGifts ArrayList - list of gifts
     */
    public void setReceivedGifts(final ArrayList<Gift> receivedGifts) {
        this.receivedGifts = receivedGifts;
    }

    /**
     * Get the child's list of gift preferences
     * @return ArrayList - list of gift preferences
     */
    public ArrayList<String> getGiftsPreferences() {
        return giftsPreferences;
    }

    /**
     * Set the child's list of gift preferences
     * @param giftsPreferences ArrayList - list of gift preferences
     */
    public void setGiftsPreferences(final ArrayList<String> giftsPreferences) {
        this.giftsPreferences = giftsPreferences;
    }

    /**
     * Get the average grade of the current year
     * @return Double - average grade
     */
    public Double getAverageScore() {
        return averageScore;
    }

    /**
     * Set the average grade of the current year
     * @param averageScore Double - average grade
     */
    public void setAverageScore(final Double averageScore) {
        this.averageScore = averageScore;
    }
}
