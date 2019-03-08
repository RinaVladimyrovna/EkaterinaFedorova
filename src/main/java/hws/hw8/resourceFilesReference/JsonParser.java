package hws.hw8.resourceFilesReference;

import hws.hw8.entities.SubmitData;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class JsonParser {

    public static List<SubmitData> parseInputJson(String address) throws IOException {

        List<SubmitData> tempData = new ArrayList<>();
        JSONObject data = new JSONObject(new String(Files.readAllBytes(Paths.get(address))));
        String[] names = data.getNames(data);

        for (String name : names) {
            JSONObject currentObject = data.getJSONObject(name);
            List<String> radioButtons = convertator(currentObject.getJSONArray("summary"));
            List<String> checkboxes = convertator(currentObject.getJSONArray("elements"));
            String colorDropDown = currentObject.getString("color");
            String metalDropDown = currentObject.getString("metals");
            List<String> vegetableDropDown = convertator(currentObject.getJSONArray("vegetables"));
            tempData.add(new SubmitData(radioButtons, checkboxes, colorDropDown, metalDropDown, vegetableDropDown));
        }

        return tempData;
    }

    private static List<String> convertator(JSONArray array) {

        List<String> result = new ArrayList<>();
        for (Object el : array) {
            result.add(el.toString());
        }

        return result;

    }


}
