package hexlet.code.formatters;

import hexlet.code.Item;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;

public class Plain {

    public static String stringConstruct(Item item) {
        return "Property " + "\'" + item.getKey() + "\'" + " was " + item.getStatus();
    }
    public static String getValue(Object value) {

        if (value instanceof Object[] || value instanceof Collections || value instanceof ArrayList
                || value instanceof Map) {
            return "[complex value]";
        } else if (value instanceof String) {
            return "\'" + String.valueOf(value) + "\'";
        } else {
            return String.valueOf(value);
        }

    }

    public static String getString(Item item) {
        String s = "";
        if (item.getStatus() == "removed") {
            s = stringConstruct(item);
        }
        if (item.getStatus() == "added") {
            s = stringConstruct(item) + " with value: " + getValue(item.getNewValue());
        }
        if (item.getStatus() == "updated") {
            s = stringConstruct(item) + ". From " + getValue(item.getOldValue())
                    + " to " + getValue(item.getNewValue());
        }
        return s;
    }
    public static String formate(ArrayList<Item> list) {
        String s = "";

        for (var i = 0; i < list.size(); i++) {
            s = s + (getString(list.get(i)).isEmpty() ? ""
                    : (getString(list.get(i)) + ((i!= list.size()-1) ? "\n" : "")));
        }
        return s;
    }
}
