package hexlet.code.formatters;

import hexlet.code.Item;

import java.io.IOException;
import java.util.ArrayList;

public class BaseFormatter {
    public static String generateFormat(String format,  ArrayList<Item> listItems) throws IOException {

        switch (format) {
            case "stylish":
                return Stylish.format(listItems);
            case "plain":
                return Plain.format(listItems);
            case "json":
                return Json.format(listItems);
            default:
                throw new RuntimeException("Unknown format: " + format + " !");
        }
    }
}
