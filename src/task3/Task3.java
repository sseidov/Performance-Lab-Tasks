package task3;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Task3 {
    public static void main(String[] args) throws IOException, ParseException {

        JSONArray jsonArray = compareValuesFromTwoJson(roots(args[0], "tests"),
                roots(args[1], "values"));

        createAnswerJson(jsonArray);
    }

    public static void createAnswerJson(JSONArray jsonArray) {
        try {
            try (FileWriter file = new FileWriter("src\\task3\\report.json")) {
                file.write(jsonArray.toJSONString());
                file.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static JSONArray compareValuesFromTwoJson(JSONArray tests, JSONArray values) {
        int x = -1;
        int y;
//      рекурсивный вызов метода
        while (++x < tests.size()) {
            if (((JSONObject) tests.get(x)).get("values") != null)
                compareValuesFromTwoJson((JSONArray) ((JSONObject) tests.get(x)).get("values"), values);

            y = -1;
            while (++y < values.size()) {
                if (((JSONObject) tests.get(x)).get("id").equals(((JSONObject) values.get(y)).get("id"))){
                    ((JSONObject) tests.get(x)).put("value", ((JSONObject) values.get(y)).get("value"));
                }
            }
        }

        return tests;
    }

    public static JSONArray roots(String name, String tag) throws IOException, ParseException {
        FileReader fileReader = new FileReader(name);
        JSONParser jsonParser = new JSONParser();
        JSONObject jsonObject = (JSONObject) jsonParser.parse(fileReader);
        return ((JSONArray) jsonObject.get(tag));
    }
}
