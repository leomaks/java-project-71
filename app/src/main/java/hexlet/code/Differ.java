package hexlet.code;

import hexlet.code.formatters.Plain;
import hexlet.code.formatters.Stylish;

import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

public class Differ {

    public static ArrayList<Item> getDif(Map<String, Object> map1,  Map<String, Object> map2) {

        Map<String, Object> treeMap = new TreeMap<String, Object>(map2);
        treeMap.putAll(map1);
        ArrayList<Item> items = new ArrayList<>();

        for (var x: treeMap.entrySet()) {
            String key0 = String.valueOf(x.getKey());
            String valueMap1 = String.valueOf(map1.get(key0));
            String valueMap2 = String.valueOf(map2.get(key0));

            Item item = ((map1.containsKey(key0)) && (map2.containsKey(key0)))
                    ? (valueMap1.equals(valueMap2)) ? new Item(key0, "constant", map1.get(key0), "")
                                                    : new Item(key0, "updated",  map1.get(key0),  map2.get(key0))
                    : !map2.containsKey(key0) ? new Item(key0, "removed", map1.get(key0), "")
                                                : new Item(key0, "added", "", map2.get(key0));
            items.add(item);
        }

        return items;
    }

    public static String generate(String filePath1, String filePath2, String format) throws Exception {
//        System.out.println(format);
        var listItems = getDif(Parser.parse(filePath1), Parser.parse(filePath2));

        if (format.equals("plain")) {
            return Plain.formate(listItems);
        } else {
            return Stylish.formate(listItems);
        }
    }

    public static String generate(String filePath1, String filePath2) throws Exception {
        return generate(filePath1, filePath2, "stylish");
    }
}




