package children;

import enums.Category;
import enums.Cities;
import enums.ElvesType;
import gifts.Gift;

import java.util.ArrayList;

public abstract class Child implements Visitable {
    private final int id;
    private final String lastName;
    private final String firstName;
    private int age;
    private Cities city;
    private Double averageScore;
    private ArrayList<Double> niceScore;
    private final Double niceScoreBonus;
    private ArrayList<Category> giftsPreferences;
    private ArrayList<Gift> receivedGifts = new ArrayList<>();
    private ElvesType elfType;


    public Child(final int id, final String lastName, final String firstName, final int age,
                 final Cities city, final ArrayList<Double> niceScore,
                 final Double niceScoreBonus, ElvesType elfType,
                 final ArrayList<Category> giftsPreferences) {
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.age = age;
        this.city = city;
        this.niceScore = niceScore;
        this.niceScoreBonus = niceScoreBonus;
        this.elfType = elfType;
        this.giftsPreferences = giftsPreferences;
    }

    public Child(final Child child) {
        this.id = child.getId();
        this.lastName = child.getLastName();
        this.firstName = child.getFirstName();
        this.age = child.getAge();
        this.city = child.getCity();
        this.niceScore = child.getNiceScore();
        this.niceScoreBonus = child.getNiceScoreBonus();
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
     * Get the child's last name
     * @return a String - last name
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Get the child's first name
     * @return a string - first name
     */
    public String getFirstName() {
        return firstName;
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
    public Cities getCity() {
        return city;
    }

    /**
     * Set the city the child is from
     * @param city String - city
     */
    public void setCity(final Cities city) {
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
     * Get the child's nice score bonus
     * @return Double - nice score bonus
     */
    public Double getNiceScoreBonus() {
        return niceScoreBonus;
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
    public ArrayList<Category> getGiftsPreferences() {
        return giftsPreferences;
    }

    /**
     * Set the child's list of gift preferences
     * @param giftsPreferences ArrayList - list of gift preferences
     */
    public void setGiftsPreferences(final ArrayList<Category> giftsPreferences) {
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

    /**
     * Get the elf type of the current year
     * @return ElvesType - elf type
     */
    public ElvesType getElfType() {
        return elfType;
    }

    /**
     * Set the elf type of the current year
     * @param elfType ElvesType - elf type
     */
    public void setElfType(final ElvesType elfType) {
        this.elfType = elfType;
    }
}
