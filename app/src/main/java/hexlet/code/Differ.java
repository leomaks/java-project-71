package hexlet.code;

import hexlet.code.formatters.Json;
import hexlet.code.formatters.Plain;
import hexlet.code.formatters.Stylish;

import java.util.ArrayList;


public class Differ {

    public static String generate(String filePath1, String filePath2, String format) throws Exception {

        ArrayList<Item> listItems = GenerateDiffer.getDif(Parser.parse(filePath1), Parser.parse(filePath2));

        switch (format) {
            case "stylish":
                return Stylish.formate(listItems);
            case "plain":
                return Plain.formate(listItems);
            case "json":
                return Json.formate(listItems);
            default:
                System.out.println("Format" + format + " is not correct!");
        }
        return Stylish.formate(listItems);
    }

    public static String generate(String filePath1, String filePath2) throws Exception {
        return generate(filePath1, filePath2, "stylish");
    }
}




