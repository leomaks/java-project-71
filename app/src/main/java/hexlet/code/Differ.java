package hexlet.code;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class Differ {

    public static Map<String, String> getData(String file) throws Exception {
        String readFilePath = file;
        Path path = Paths.get(readFilePath).toAbsolutePath().normalize();

        if (!Files.exists(path)) {
            throw new Exception("File '" + path + "' does not exist");
        }

        String jsonInput = Files.readString(path);
        ObjectMapper mapper = new ObjectMapper();
        Map<String, String> map = mapper.readValue(jsonInput, new TypeReference<HashMap<String, String>>() {
        });

        return map;
    }

    public static String generate(String filePath1, String filePath2) throws Exception {

        Map<String, String> map1 = getData(filePath1);
        Map<String, String> map2 = getData(filePath2);


        Map<String, String> treeMap = new TreeMap<String, String>(map2);
        treeMap.putAll(map1);
        var list = new ArrayList<String>();

        for (var item: treeMap.entrySet()) {
            String value0 = item.getValue();
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
        return result;

    }

}
