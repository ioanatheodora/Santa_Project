package fileio;

import enums.Category;
import enums.ElvesType;
import enums.EnumConverter;

import java.util.ArrayList;

public class ChildrenUpdatesInputData {
    private final int id;
    private final Double niceScore;
    private final ArrayList<Category> giftPreferences;
    private final ElvesType elf;

    public ChildrenUpdatesInputData(final int id, final Double niceScore,
                                    final ArrayList<Category> giftPreferences,
                                    final String elf) {
        this.id = id;
        this.niceScore = niceScore;
        this.giftPreferences = giftPreferences;
        this.elf = new EnumConverter(elf).toElvesType();
    }

    public ChildrenUpdatesInputData(final int id,
                                    final ArrayList<Category> giftPreferences,
                                    final String elf) {
        this.id = id;
        this.niceScore = -1d;
        this.giftPreferences = giftPreferences;
        this.elf = new EnumConverter(elf).toElvesType();
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
     * @return List - gift preferences
     */
    public ArrayList<Category> getGiftPreferences() {
        return giftPreferences;
    }

    /**
     * Get the elf type of the current year
     * @return ElvesType - elf type
     */
    public ElvesType getElf() {
        return elf;
    }
}
