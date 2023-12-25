package hexlet.code.formatters;

import hexlet.code.Item;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import java.util.stream.Collectors;

public class Plain {

    public static String stringConstruct(Item item) {
        return "Property " + "\'" + item.getKey() + "\'" + " was " + item.getStatus().toString().toLowerCase();
    }


    public static String getValue(Object value) {

        if (value instanceof ArrayList || value instanceof Map) {
            return "[complex value]";
        } else if (value instanceof String) {
            return "\'" + String.valueOf(value) + "\'";
        } else {
            return String.valueOf(value);
        }

    }

    public static String getString(Item item) {

        String s = "";
        switch (item.getStatus()) {

            case REMOVED: s = stringConstruct(item);
                break;
            case ADDED: s = stringConstruct(item) + " with value: " + getValue(item.getNewValue());
                break;
            case UPDATED: s = stringConstruct(item) + ". From " + getValue(item.getOldValue())
                        + " to " + getValue(item.getNewValue());
                break;
            default: s = "";
        }

        return s;
    }
    public static String format(ArrayList<Item> list) throws IOException {

        var result = list.stream()
                .map(x -> getString(x))
                .filter(x -> (!x.equals("")))
                .collect(Collectors.joining("\n"));

        return result;

    }
}
