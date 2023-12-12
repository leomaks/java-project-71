package hexlet.code;

import hexlet.code.formatters.Json;
import hexlet.code.formatters.Plain;
import hexlet.code.formatters.Stylish;

import java.io.IOException;
import java.util.ArrayList;

public class BazeFormatter {
    public static String generateFormat(String format,  ArrayList<Item> listItems) throws IOException {

        switch (format) {
            case "stylish":
                return Stylish.formate(listItems);
            case "plain":
                return Plain.formate(listItems);
            case "json":
                return Json.formate(listItems);
            default:
                throw new Error("Unknown format: " + format + " !");
        }
    }
}
