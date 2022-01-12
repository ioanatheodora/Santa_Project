package fileio;

import common.Constants;
import enums.Category;
import enums.EnumConverter;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;



public class InputLoader {

    private final String inputPath;

    public InputLoader(final String inputPath) {
        this.inputPath = inputPath;
    }

    private static ArrayList<Category> getPreferences(final ArrayList<String> gifts) {
        ArrayList<Category> giftPreferences = new ArrayList<>();

        for (String gift : gifts) {
            Category category = new EnumConverter(gift).toCategory();
            giftPreferences.add(category);
        }

        return giftPreferences;
    }

    /**
     * Converts a JSONArray to an ArrayList of String
     * @param array JSONArray
     * @return ArrayList<String>
     */
    public static ArrayList<String> convertJSONArray(final JSONArray array) {
        if (array != null) {
            ArrayList<String> finalArray = new ArrayList<>();
            for (Object object : array) {
                finalArray.add((String) object);
            }
            return finalArray;
        } else {
            return null;
        }
    }

    /**
     * Converts the children from a JSON Object to the class ChildrenInputData
     * @param jsonChild JSONObject - the object that represents Santa's list of children
     * @param children List - list of children
     */
    public static void convertJSONToChildren(final JSONObject jsonChild,
                                             final List<ChildrenInputData> children) {
        ArrayList<Category> giftsPreferences = getPreferences(convertJSONArray((JSONArray) jsonChild
                        .get(Constants.GIFTS_PREFERENCES)));
        children.add(new ChildrenInputData(
                ((Long) jsonChild.get(Constants.ID)).intValue(),
                (String) jsonChild.get(Constants.LAST_NAME),
                (String) jsonChild.get(Constants.FIRST_NAME),
                ((Long) jsonChild.get(Constants.AGE)).intValue(),
                (String) jsonChild.get(Constants.CITY),
                ((Long) jsonChild.get(Constants.NICE_SCORE)).doubleValue(),
                ((Long) jsonChild.get(Constants.NICE_SCORE_BONUS)).doubleValue(),
                (String) jsonChild.get(Constants.ELF),
                giftsPreferences));

    }

    /**
     * Converts Santa's gifts from a JSON Object to the class SantaGiftsInputData
     * @param jsonGift JSONObject - the object that represents Santa's gifts
     * @param santaGifts List - list of Santa's gifts
     */
    public static void convertJSONToSantaGifts(final JSONObject jsonGift,
                                               final List<SantaGiftsInputData> santaGifts) {
        santaGifts.add(new SantaGiftsInputData(
                (String) jsonGift.get(Constants.PRODUCT_NAME),
                ((Long) jsonGift.get(Constants.PRICE)).doubleValue(),
                (String) jsonGift.get(Constants.CATEGORY),
                ((Long) jsonGift.get(Constants.QUANTITY)).intValue()
        ));
    }

    /**
     * Converts the children updates from a JSON Object to the class ChildrenUpdatesInputData
     * @param jsonUpdate JSONObject - the object that represents the children updates
     * @param updates List - list of children updates
     */
    public static void convertJSONToChildrenUpdates(final JSONObject jsonUpdate,
                                                    final List<ChildrenUpdatesInputData> updates) {
        ArrayList<Category> giftsPreferences = getPreferences(convertJSONArray((JSONArray)
                jsonUpdate.get(Constants.GIFTS_PREFERENCES)));
        if ((Long) jsonUpdate.get(Constants.NICE_SCORE) != null) {
//            we get new information about the nice score
            updates.add(new ChildrenUpdatesInputData(
                    ((Long) jsonUpdate.get(Constants.ID)).intValue(),
                    ((Long) jsonUpdate.get(Constants.NICE_SCORE)).doubleValue(),
                    giftsPreferences, (String) jsonUpdate.get(Constants.ELF))
                    );
        } else {
            updates.add(new ChildrenUpdatesInputData(
                    ((Long) jsonUpdate.get(Constants.ID)).intValue(),
                    giftsPreferences, (String) jsonUpdate.get(Constants.ELF)));
        }
    }

    /**
     * Converts the annual changes from a JSON Object to the class annualChangesInputData
     * @param jsonChange JSONObject - the object that represents the annual changes
     * @param annualChanges List - list of annual Changes
     */
    public static void convertJSONToAnnualChanges(final JSONObject jsonChange,
                                             final List<AnnualChangesInputData> annualChanges) {
        double newSantaBudget = ((Long) jsonChange.get(Constants.NEW_SANTA_BUDGET)).doubleValue();
        String strategy = (String) jsonChange.get(Constants.STRATEGY);
        JSONArray jsonChildren = (JSONArray)
                jsonChange.get(Constants.NEW_CHILDREN);
        JSONArray jsonSantaGifts = (JSONArray)
                jsonChange.get(Constants.NEW_GIFTS);
        JSONArray jsonChildrenUpdates = (JSONArray)
                jsonChange.get(Constants.CHILDREN_UPDATES);

        ArrayList<ChildrenInputData> newChildren = new ArrayList<>();
        ArrayList<SantaGiftsInputData> newSantaGifts = new ArrayList<>();
        ArrayList<ChildrenUpdatesInputData> childrenUpdates = new ArrayList<>();

        if (jsonChildren != null) {
            for (Object jsonChild : jsonChildren) {
                convertJSONToChildren((JSONObject) jsonChild, newChildren);
            }
        }
        if (jsonSantaGifts != null) {
            for (Object jsonGift : jsonSantaGifts) {
                convertJSONToSantaGifts((JSONObject) jsonGift, newSantaGifts);
            }
        }
        if (jsonChildrenUpdates != null) {
            for (Object jsonUpdate : jsonChildrenUpdates) {
                convertJSONToChildrenUpdates((JSONObject) jsonUpdate, childrenUpdates);
            }
        }

        AnnualChangesInputData annualChange = new AnnualChangesInputData(
                newSantaBudget, newSantaGifts, newChildren, childrenUpdates,
                strategy);
        annualChanges.add(annualChange);
    }

    /**
     * Transfers data from the JSON Format into an instance of the class Input
      * @return Input - input data
     */
    public Input readData() {
        JSONParser jsonParser = new JSONParser();
        int numberOfYears = 0;
        double santaBudget = 0;
        List<ChildrenInputData> children = new ArrayList<>();
        List<SantaGiftsInputData> santaGifts = new ArrayList<>();
        List<AnnualChangesInputData> annualChanges = new ArrayList<>();

        try {
        // Parse the contents of the JSON file
            JSONObject jsonObject = (JSONObject) jsonParser
                    .parse(new FileReader(inputPath));

            JSONObject initialData = (JSONObject)
                    jsonObject.get(Constants.INITIAL_DATA);
            JSONArray jsonChildren = (JSONArray)
                    initialData.get(Constants.CHILDREN);
            JSONArray jsonSantaGifts = (JSONArray)
                    initialData.get(Constants.SANTA_GIFTS_LIST);
            JSONArray jsonAnnualChanges = (JSONArray)
                    jsonObject.get(Constants.ANNUAL_CHANGES);

        // Start adding the data to the fields
            numberOfYears = ((Long) jsonObject.get(Constants.NUMBER_OF_YEARS))
                    .intValue();
            santaBudget = ((Long) jsonObject.get(Constants.SANTA_BUDGET))
                    .doubleValue();

            if (jsonChildren != null) {
                for (Object jsonChild : jsonChildren) {
                    convertJSONToChildren((JSONObject) jsonChild, children);
                }
            } else {
                System.out.println("Children not found!");
            }

            if (jsonSantaGifts != null) {
                for (Object jsonGift : jsonSantaGifts) {
                    convertJSONToSantaGifts((JSONObject) jsonGift, santaGifts);
                }
            } else {
                System.out.println("Santa Gifts not found! Santa poor!");
            }

            if (jsonAnnualChanges != null) {
                for (Object jsonChange : jsonAnnualChanges) {
                    convertJSONToAnnualChanges((JSONObject) jsonChange, annualChanges);
                }
            }

        } catch (ParseException | IOException e) {
            e.printStackTrace();
        }
        return new Input(numberOfYears, santaBudget, children, santaGifts, annualChanges);
    }
}
