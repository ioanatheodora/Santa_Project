package fileio;

import enums.Category;
import enums.Cities;
import enums.ElvesType;
import enums.EnumConverter;

import java.util.ArrayList;

public class ChildrenInputData {
    private final int id;
    private final String lastName;
    private final String firstName;
    private final int age;
    private final Cities city;
    private final Double niceScore;
    private final ArrayList<Category> giftsPreferences;
    private final Double niceScoreBonus;
    private final ElvesType elfType;

    public ChildrenInputData(final int id, final String lastName, final String firstName,
                             final int age, final String city, final Double niceScore,
                             final Double niceScoreBonus, final String elfType,
                             final ArrayList<Category> giftsPreferences) {
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.age = age;
        this.city = new EnumConverter(city).toCities();
        this.niceScore = niceScore;
        this.niceScoreBonus = niceScoreBonus;
        this.elfType = new EnumConverter(elfType).toElvesType();
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
     * Get the city the child is from
     * @return String - city
     */
    public Cities getCity() {
        return city;
    }

    /**
     * Get the child's nice score
     * @return double - nice score
     */
    public Double getNiceScore() {
        return niceScore;
    }

    /**
     * Get the list of gifts the child prefers
     * @return ArrayList - list of gifts
     */
    public ArrayList<Category> getGiftsPreferences() {
        return giftsPreferences;
    }

    /**
     * Get the child's nice score bonus
     * @return Double - nice score bonus
     */
    public Double getNiceScoreBonus() {
        return niceScoreBonus;
    }

    /**
     * Get the assigned elf type
     * @return ELvesType - the elf type
     */
    public ElvesType getElfType() {
        return elfType;
    }
}
