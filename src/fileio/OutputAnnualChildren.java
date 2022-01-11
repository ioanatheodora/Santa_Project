package fileio;

import org.json.simple.JSONObject;

import java.util.ArrayList;

public class OutputAnnualChildren {
    private ArrayList<JSONObject> children = new ArrayList<>();
    private ArrayList<JSONObject> annualChange = new ArrayList<>();

    public OutputAnnualChildren() {

    }

    /**
     * Adds a JSONObject to the list of JSONObjects that represent the children
     * for one year
     * @param jsonObject
     */
    public void add(final JSONObject jsonObject) {
        children.add(jsonObject);
    }

    /**
     * Adds to the ArrayList of JSONObjects the annual changes
     */
    public void children() {
        JSONObject object = new JSONObject();
        ArrayList<JSONObject> temporary = (ArrayList<JSONObject>) children.clone();
        object.put("children", temporary);
        annualChange.add(object);
        children.clear();

    }

    /**
     * Adds the result to the file using a Writer Object
     * @param fileWriter a Writer Object
     */
    public void add(final Writer fileWriter) {
        JSONObject object = new JSONObject();
        object.put("annualChildren", annualChange);
        fileWriter.closeJSON(object);
    }


}
