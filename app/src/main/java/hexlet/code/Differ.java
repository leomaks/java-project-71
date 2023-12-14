package hexlet.code;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Map;


public class Differ {
    public static Path getPath(String file)  {
        return Paths.get(file).toAbsolutePath().normalize();
    }

    public static Map<String, Object> getMap(String file) throws Exception {

        Path path = getPath(file);
        String input = Files.readString(path);

        String format = file.substring(file.lastIndexOf("."));
        Map<String, Object> map = Parser.parse(input, format);

        return map;
    }

    public static String generate(String filePath1, String filePath2, String format) throws Exception {

        ArrayList<Item> listItems = GenerateDiffer.getDif(getMap(filePath1), getMap(filePath2));
        return BazeFormatter.generateFormat(format, listItems);
    }

    public static String generate(String filePath1, String filePath2) throws Exception {
        return generate(filePath1, filePath2, "stylish");
    }
}




