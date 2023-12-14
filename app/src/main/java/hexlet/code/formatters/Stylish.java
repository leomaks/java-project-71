package hexlet.code.formatters;

import hexlet.code.Item;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class Stylish {
    public static String stringConstruct(String status, String key, Object value) {
        return " ".repeat(2) + status + key + ": " + String.valueOf(value);
    }

    public static String getString(Item item) {

        String s = "";
        switch (item.getStatus()) {
            case CONSTANT:
                s = stringConstruct("  ", item.getKey(), item.getOldValue());
                break;
            case REMOVED:
                s = stringConstruct("- ", item.getKey(), item.getOldValue());
                break;
            case ADDED:
                s = stringConstruct("+ ", item.getKey(), item.getNewValue());
                break;
            case UPDATED:
                s = stringConstruct("- ", item.getKey(), item.getOldValue()) + "\n"
                        + stringConstruct("+ ", item.getKey(), item.getNewValue());
                break;
            default: s = "";
        }
        return s;
    }
    public static String formate(ArrayList<Item> list) {
        var result = list.stream()
                .map(x -> getString(x))
                .collect(Collectors.joining("\n"));

        return "{\n" + result + "\n}";
    }
}
