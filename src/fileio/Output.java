package fileio;

import enums.Category;
import gifts.Gift;
import org.json.simple.JSONObject;

import java.util.ArrayList;

public class Output {
    private final int id;
    private final String lastName;
    private final String firstName;
    private final String city;
    private final int age;
    private final ArrayList<Category> giftsPreferences;
    private final double averageScore;
    private final ArrayList<Double> niceScoreHistory;
    private final double assignedBudget;
    private final ArrayList<Gift> receivedGifts;

    // cloned the array lists in order to get the right answer in the object
    public Output(final int id, final String lastName, final String firstName,
                  final String city, final int age, final ArrayList<Category> giftsPreferences,
                  final double averageScore, final ArrayList<Double> niceScoreHistory,
                  final double assignedBudget, final ArrayList<Gift> receivedGifts) {
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.city = city;
        this.age = age;
        this.giftsPreferences = (ArrayList<Category>) giftsPreferences.clone();
        this.averageScore = averageScore;
        this.niceScoreHistory = (ArrayList<Double>) niceScoreHistory.clone();
        this.assignedBudget = assignedBudget;
        this.receivedGifts = (ArrayList<Gift>) receivedGifts.clone();
    }

    /**
     * Creates a JSONObject representing the class Gift
     * @return JSONObject - gift received
     */
    private ArrayList<JSONObject> addGifts() {
        ArrayList<JSONObject> jsonGifts = new ArrayList<>();
        for (Gift gift : receivedGifts) {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("productName", gift.getProductName());
            jsonObject.put("price", gift.getPrice());
            jsonObject.put("category", gift.getCategory().getValue());
            jsonGifts.add(jsonObject);
        }
        return jsonGifts;

    }

    /**
     * Converts the output into an ArrayList of String in order to add it to the output
     * @param gifts ArrayList<Category> - list of gift preferences
     * @return ArrayList<String> - list of gift preferences
     */
    private ArrayList<String> getGiftsPreferences(final ArrayList<Category> gifts) {
        ArrayList<String> giftPreferences = new ArrayList<>();

        for (Category category : gifts) {
            giftPreferences.add(category.getValue());
        }

        return giftPreferences;
    }

    /**
     * Creates a JSONObject that represents the output for one children in one year
     * @return JSONObject - information about one child
     */
    public JSONObject addResult() {
        JSONObject object = new JSONObject();
        ArrayList<JSONObject> gifts = addGifts();

        object.put("id", id);
        object.put("lastName", lastName);
        object.put("firstName", firstName);
        object.put("city", city);
        object.put("age", age);
        object.put("giftsPreferences", getGiftsPreferences(giftsPreferences));
        object.put("averageScore", averageScore);
        object.put("niceScoreHistory", niceScoreHistory);
        object.put("assignedBudget", assignedBudget);
        object.put("receivedGifts", gifts);

        return object;
    }


}
