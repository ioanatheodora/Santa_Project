package fileio;

import java.util.ArrayList;

public class ChildrenInputData {
    private int id;
    private String lastName;
    private String firstName;
    private int age;
    private String city;
    private Double niceScore;
    private ArrayList<String> giftsPreferences;

    public ChildrenInputData(final int id, final String lastName, final String firstName,
                             final int age, final String city, final Double niceScore,
                             final ArrayList<String> giftsPreferences) {
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.age = age;
        this.city = city;
        this.niceScore = niceScore;
        this.giftsPreferences = giftsPreferences;
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
     * Get the child's nice score
     * @return double - nice score
     */
    public Double getNiceScore() {
        return niceScore;
    }

    /**
     * Set the child's nice score
     * @param niceScore double - nice score
     */
    public void setNiceScore(final Double niceScore) {
        this.niceScore = niceScore;
    }

    /**
     * Get the list of gifts the child prefers
     * @return ArrayList - list of gifts
     */
    public ArrayList<String> getGiftsPreferences() {
        return giftsPreferences;
    }

    /**
     * Set the list of gifts the child prefers
     * @param giftsPreferences - list of gifts
     */
    public void setGiftsPreferences(final ArrayList<String> giftsPreferences) {
        this.giftsPreferences = giftsPreferences;
    }
}
