package hexlet.code;

import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

public class GenerateDiff {
    public static ArrayList<Item> getDiff(Map<String, Object> map1, Map<String, Object> map2) {

        Map<String, Object> treeMap = new TreeMap<String, Object>(map2);
        treeMap.putAll(map1);
        ArrayList<Item> items = new ArrayList<>();

        for (var x: treeMap.entrySet()) {
            String key0 = String.valueOf(x.getKey());
            String valueMap1 = String.valueOf(map1.get(key0));
            String valueMap2 = String.valueOf(map2.get(key0));

            Item item;

            if ((map1.containsKey(key0)) && (map2.containsKey(key0))) {
                if ((valueMap1.equals(valueMap2))) {
                    item = new Item(key0, Status.CONSTANT, map1.get(key0), "");
                } else {
                    item = new Item(key0, Status.UPDATED, map1.get(key0), map2.get(key0));
                }
            } else {
                if (!map2.containsKey(key0)) {
                    item = new Item(key0, Status.REMOVED, map1.get(key0), "");
                } else {
                    item = new Item(key0, Status.ADDED, "", map2.get(key0));
                }
            }

            items.add(item);
        }

        return items;
    }
}
