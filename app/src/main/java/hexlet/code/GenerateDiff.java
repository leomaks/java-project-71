package hexlet.code;

import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

public class GenerateDiff {
    public static ArrayList<Item> getDiff(Map<String, Object> map1, Map<String, Object> map2) {

        Map<String, Object> treeMap = new TreeMap<String, Object>(map2);
        treeMap.putAll(map1);
        ArrayList<Item> items = new ArrayList<>();
        ArrayList<Map<String, Object>> hotelsByService;


        for (var x: treeMap.entrySet()) {
            String key = String.valueOf(x.getKey());
            String valueMap1 = String.valueOf(map1.get(key));
            String valueMap2 = String.valueOf(map2.get(key));

            Item item;

            if (!map1.containsKey(key)) {
                item = new Item(key, Status.ADDED, "", map2.get(key));
            } else if (!map2.containsKey(key)) {
                item = new Item(key, Status.REMOVED, map1.get(key), "");
            } else if (valueMap1.equals(valueMap2)) {
                item = new Item(key, Status.CONSTANT, map1.get(key), "");
            } else {
                item = new Item(key, Status.UPDATED, map1.get(key), map2.get(key));
            }



            items.add(item);
            System.out.println(items);
        }

        return items;
    }
}
