package hws.hw8.resourceFilesReference;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import hws.hw8.entities.SubmitData;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class JsonParserWrapper {

    public static List<SubmitData> parseInputJson(String address) throws IOException {

        List<SubmitData> tempData = new ArrayList<>();
        JsonObject originalStructure = new JsonParser()
                .parse(new String(Files.readAllBytes(Paths.get(address)))).getAsJsonObject();
        // TODO Take a look on IDEA warning, this is really bad mistake.
        // Seems like in gson lib it is not a static method
        Set<String> names = originalStructure.keySet();
        for (String name : names) {
            // TODO This is completely prohibited to write algorithm that depends on data name/title.
            // Yes, you are absolutely right.
            // TODO Most all of this libraries use reflection mechanism under the hood.
            tempData.add(new Gson().fromJson(originalStructure.get(name), SubmitData.class));
        }

        return tempData;
    }

}
