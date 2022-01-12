package annualchanges;

import enums.Category;
import enums.ElvesType;

import java.util.List;

public class ChildUpdate {
    private final int id;
    private final Double niceScore;
    private final List<Category> giftsPreferences;
    private final ElvesType elf;

    public ChildUpdate(final int id, final Double niceScore, final List<Category> giftsPreferences,
                       final ElvesType elf) {
        this.id = id;
        this.niceScore = niceScore;
        this.giftsPreferences = giftsPreferences;
        this.elf = elf;
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
    public List<Category> getGiftsPreferences() {
        return giftsPreferences;
    }

    /**
     * Get the child's assigned elf in the current year
     * @return ElvesType - the elf's type
     */
    public ElvesType getElf() {
        return elf;
    }
}
