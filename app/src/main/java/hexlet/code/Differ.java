package hexlet.code;

import hexlet.code.formatters.BaseFormatter;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Map;


public class Differ {
    public static Path getPath(String file)  {
        return Paths.get(file).toAbsolutePath().normalize();
    }

    public static String getFormat(String file)  {
        return file.substring(file.lastIndexOf("."));
    }

    public static String getStringFromFile(String file) throws IOException {
        Path path = getPath(file);
        return Files.readString(path);
    }

    public static Map<String, Object> getMap(String file) throws Exception {

        String input = getStringFromFile(file);
        Map<String, Object> map = Parser.parse(input, getFormat(file));

        return map;
    }

    public static String generate(String filePath1, String filePath2, String format) throws Exception {

        ArrayList<Item> listItems = GenerateDiff.getDiff(getMap(filePath1), getMap(filePath2));
        return BaseFormatter.generateFormat(format, listItems);
    }

    public static String generate(String filePath1, String filePath2) throws Exception {
        return generate(filePath1, filePath2, "stylish");
    }
}




