package hexlet.code;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import java.util.HashMap;
import java.util.Map;

public class Parser {

    public static Map<String, Object> parse(String input, String format) throws Exception {

        Map<String, Object> map = new HashMap<>();
        ObjectMapper mapper = format.equals(".json") ? new ObjectMapper()  : new ObjectMapper(new YAMLFactory());

        if (input.isEmpty()) {
            return map;
        }

        map = mapper.readValue(input, Map.class);
        return map;
    }
}
