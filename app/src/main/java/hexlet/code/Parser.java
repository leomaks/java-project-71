package hexlet.code;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

public class Parser {

    public static Map<String, Object> getMap(String input, String format) throws Exception {

        Map<String, Object> map = new HashMap<>();
        ObjectMapper mapper = format.equals(".json") ? new ObjectMapper()  : new ObjectMapper(new YAMLFactory());

        if (input.isEmpty()) {
            return map;
        }

        map = mapper.readValue(input, Map.class);
        return map;
    }
    public static Map<String, Object> parse(String file) throws Exception {

        String filePath = file;
        Path path = Paths.get(filePath).toAbsolutePath().normalize();

        if (!Files.exists(path)) {
            throw new Exception("File '" + path + "' does not exist");
        }

        String input = Files.readString(path);
        String format = filePath.substring(filePath.lastIndexOf("."));
        Map<String, Object> map = getMap(input, format);

        return map;
    }
}
