package hexlet.code;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import java.util.HashMap;
import java.util.Map;

public class Parser {

    public static Map<String, Object> parse(String input, String format) throws Exception {

        Map<String, Object> map = new HashMap<>();

        ObjectMapper mapper;

        switch (format) {
            case "json": mapper = new ObjectMapper();
                break;
            case "yml": mapper = new ObjectMapper(new YAMLFactory());
                break;
            case "yaml": mapper = new ObjectMapper(new YAMLFactory());
                break;
            default: mapper = new ObjectMapper();
        }

        if (input.isEmpty()) {
            return map;
        }

        map = mapper.readValue(input, Map.class);
        return map;
    }
}
