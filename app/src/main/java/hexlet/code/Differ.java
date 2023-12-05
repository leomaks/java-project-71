package hexlet.code;

import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class Differ {



    public static String generate(String filePath1, String filePath2) throws Exception {

        Map<String, String> map1 = Parser.parse(filePath1);
        Map<String, String> map2 = Parser.parse(filePath2);

        Map<String, String> treeMap = new TreeMap<String, String>(map2);
        treeMap.putAll(map1);

        var list = new ArrayList<String>();

        for (var item: treeMap.entrySet()) {
            String key0 = item.getKey();

            if ((map1.containsKey(key0)) && (map2.containsKey(key0))) {
                if (map1.get(key0).equals(map2.get(key0))) {
                    list.add(key0 + ": " + map1.get(key0));
                } else {
                    list.add("- " + key0 + ": " + map1.get(key0));
                    list.add("+ " + key0 + ": " + map2.get(key0));
                }
            }
            if ((map1.containsKey(key0)) && (!map2.containsKey(key0))) {
                list.add("- " + key0 + ": " + map1.get(key0));
            }
            if (!(map1.containsKey(key0)) && (map2.containsKey(key0))) {
                list.add("+ " + key0 + ": " + map2.get(key0));
            }
        }

        String result = list.stream().collect(Collectors.joining("\n"));
        result = "{\n"+ result + "\n}";

        return result;

    }

}
