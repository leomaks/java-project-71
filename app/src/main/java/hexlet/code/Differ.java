package hexlet.code;

import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

public class Differ {
    public static String generate(String filePath1, String filePath2, String format) throws Exception {
        System.out.println(format);

        Map<String, Object> map1 = Parser.parse(filePath1);
        Map<String, Object> map2 = Parser.parse(filePath2);

        Map<String, Object> treeMap = new TreeMap<String, Object>(map2);
        treeMap.putAll(map1);

        var list = new ArrayList<String>();

        for (var item: treeMap.entrySet()) {
            String key0 = String.valueOf(item.getKey());
            String valueMap1 = String.valueOf(map1.get(key0));
            String valueMap2 = String.valueOf(map2.get(key0));

            if ((map1.containsKey(key0)) && (map2.containsKey(key0))) {
                if (valueMap1.equals(valueMap2)) {
                    list.add(key0 + ": " + valueMap1);
                } else {
                    list.add("- " + key0 + ": " + valueMap1);
                    list.add("+ " + key0 + ": " + valueMap2);
                }
            }
            if ((map1.containsKey(key0)) && (!map2.containsKey(key0))) {
                list.add("- " + key0 + ": " + valueMap1);
            }
            if (!(map1.containsKey(key0)) && (map2.containsKey(key0))) {
                list.add("+ " + key0 + ": " + valueMap2);
            }
        }

        return Stylish.formate(list);
    }
    public static String generate(String filePath1, String filePath2) throws Exception {
        return generate(filePath1, filePath2, "stylish");
    }
}




