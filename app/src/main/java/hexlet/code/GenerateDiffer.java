package hexlet.code;

import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

public class GenerateDiffer {
    public static ArrayList<Item> getDif(Map<String, Object> map1, Map<String, Object> map2) {

        Map<String, Object> treeMap = new TreeMap<String, Object>(map2);
        treeMap.putAll(map1);
        ArrayList<Item> items = new ArrayList<>();

        for (var x: treeMap.entrySet()) {
            String key0 = String.valueOf(x.getKey());
            String valueMap1 = String.valueOf(map1.get(key0));
            String valueMap2 = String.valueOf(map2.get(key0));

            Item item = ((map1.containsKey(key0)) && (map2.containsKey(key0)))
                    ? (valueMap1.equals(valueMap2)) ? new Item(key0, Status.constant, map1.get(key0), "")
                    : new Item(key0, Status.updated,  map1.get(key0),  map2.get(key0))
                    : !map2.containsKey(key0) ? new Item(key0, Status.removed, map1.get(key0), "")
                    : new Item(key0, Status.added, "", map2.get(key0));
            items.add(item);
        }

        return items;
    }
}
