package hexlet.code;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;
import java.util.HashMap;

public class Parser {

    public static Map<String, String> getMap(String input, String format) throws Exception {

        Map<String, String> map;
        ObjectMapper mapper = null;

        if (format.equals(".json")) mapper = new ObjectMapper();
        if (format.equals(".yml"))  mapper = new ObjectMapper(new YAMLFactory());

        map = mapper.readValue(input, new TypeReference<HashMap<String, String>>() {});
        return map;
}
    public static Map<String, String> parse(String file) throws Exception {

        String filePath = file;
        Path path = Paths.get(filePath).toAbsolutePath().normalize();

        if (!Files.exists(path)) {
            throw new Exception("File '" + path + "' does not exist");
        }

        String input = Files.readString(path);
        String format = filePath.substring(filePath.lastIndexOf("."));
        Map<String, String> map = getMap(input, format);

        return map;
    }
}
