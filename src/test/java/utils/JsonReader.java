package utils;

import org.apache.commons.io.FileUtils;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.IOException;

import static org.apache.commons.io.FileUtils.readFileToString;

public class JsonReader {

    public static JSONObject getJsonData() throws IOException, ParseException {
        //pass the path of the testdata.json file
        File filename = new File("ressources//TestData//testData.json");
        //convert json file into string
        String json = readFileToString(filename, "UTF-8");
        //parse the string into object
        Object obj = new JSONParser().parse(json);
        //give jsonobject so that o can return it to the function everytime it get  called
        JSONObject jsonObject = (JSONObject) obj;
        return jsonObject;
    }

    public static String getTestData(String key) throws IOException, ParseException {
        String testDataValue;
        return testDataValue = (String) getJsonData().get(key);
    }
}
