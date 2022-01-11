package fileio;

import java.util.ArrayList;

public class ChildrenUpdatesInputData {
    private int id;
    private Double niceScore;
    private ArrayList<String> giftPreferences;

    public ChildrenUpdatesInputData(final int id, final Double niceScore,
                                    final ArrayList<String> giftPreferences) {
        this.id = id;
        this.niceScore = niceScore;
        this.giftPreferences = giftPreferences;
    }

    public ChildrenUpdatesInputData(final int id,
                                    final ArrayList<String> giftPreferences) {
        this.id = id;
        this.niceScore = -1d;
        this.giftPreferences = giftPreferences;
    }

    /**
     * Get the id the child can be identified by
     * @return int - id
     */
    public int getId() {
        return id;
    }

    /**
     * Set the id the child can be identified by
     * @param id int - id
     */
    public void setId(final int id) {
        this.id = id;
    }

    /**
     * Get the year's nice score
     * @return double - nice score
     */
    public Double getNiceScore() {
        return niceScore;
    }

    /**
     * Set the year's nice score
     * @param niceScore double - nice score
     */
    public void setNiceScore(final Double niceScore) {
        this.niceScore = niceScore;
    }

    /**
     * Get a list of new gift preferences to be added to the previous one
     * @return List - gift preferences
     */
    public ArrayList<String> getGiftPreferences() {
        return giftPreferences;
    }

    /**
     * Set a list of new gift preferences to be added to the previous one
     * @param giftPreferences ArrayList - gift preferences
     */
    public void setGiftPreferences(final ArrayList<String> giftPreferences) {
        this.giftPreferences = giftPreferences;
    }
}
