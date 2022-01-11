package annualchanges;

import java.util.List;

public class ChildUpdate {
    private final int id;
    private final Double niceScore;
    private final List<String> giftsPreferences;

    public ChildUpdate(final int id, final Double niceScore, final List<String> giftsPreferences) {
        this.id = id;
        this.niceScore = niceScore;
        this.giftsPreferences = giftsPreferences;
    }

    /**
     * Get the id the child can be identified by
     * @return int - id
     */
    public int getId() {
        return id;
    }

    /**
     * Get the year's nice score
     * @return double - nice score
     */
    public Double getNiceScore() {
        return niceScore;
    }

    /**
     * Get a list of new gift preferences to be added to the previous one
     * @return List - giftsPreferences
     */
    public List<String> getGiftsPreferences() {
        return giftsPreferences;
    }
}
