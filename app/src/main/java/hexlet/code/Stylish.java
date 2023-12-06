package hexlet.code;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class Stylish {
    public static String stringConstruct (String status, String key, Object value) {
        return " ".repeat(2) + status + key + ": " + String.valueOf(value);
    }

    public static String getString(Item item) {
        String s = "";

        if (item.getStatus() == "constant")
            s = stringConstruct("  ", item.getKey(), item.getOldValue());

        if (item.getStatus() == "removed")
            s = stringConstruct("- ", item.getKey(), item.getOldValue());

        if (item.getStatus() == "added")
            s = stringConstruct("+ ", item.getKey(), item.getNewValue());

        if (item.getStatus() == "updated")
            s = stringConstruct("- ", item.getKey(), item.getOldValue()) + "\n"
                    + stringConstruct("+ ", item.getKey(), item.getNewValue());

        return s;
    }
    public static String formate(ArrayList<Item> list) {
        var result = list.stream()
                .map(x -> getString(x))
                .collect(Collectors.joining("\n"));

        return "{\n" + result + "\n}";
    }
}
