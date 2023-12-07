package hexlet.code;

import org.junit.jupiter.api.Test;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AppTest {

    private final Path pathPlain =
            Paths.get("./src/test/resources/result_plain.txt").toAbsolutePath().normalize();
    private final Path pathStylish =
            Paths.get("./src/test/resources/result_stylish.txt").toAbsolutePath().normalize();
    private final String trueJsonResult = """
            {
              - follow: false
              - host: hexlet.io
              + host: hexlet.io 2
              - proxy: 123.234.53.22
              - timeout: 150
              + timeout: 20
              + verbose: true
            }""";

   // @Test
    public void testFromArtefactsJsonPlane() throws Exception {


        String expected = Files.readString(pathPlain);
        final String filepath1 = "src/test/resources/file111.json";
        final String filepath2 = "src/test/resources/file222.json";

        assertEquals(expected, Differ.generate(filepath1, filepath2, "plain"));
    }
 //   @Test
    public void testFromArtefactsJsonStylish() throws Exception {


        String expected = Files.readString(pathStylish);
        final String filepath1 = "./src/test/resources/file111.json";
        final String filepath2 = "./src/test/resources/file222.json";

        assertEquals(expected, Differ.generate(filepath1, filepath2, "stylish"));
    }
///

 //   @Test
    public void testFromArtefactsYamlPlane() throws Exception {
        String expected = Files.readString(pathPlain);
        final String filepath1 = "./src/test/resources/file301.yml";
        final String filepath2 = "./src/test/resources/file302.yml";
        assertEquals(expected, Differ.generate(filepath1, filepath2, "plain"));
    }
  //  @Test
    public void testFromArtefactsYamlStylish() throws Exception {


        String expected = Files.readString(pathStylish);
        final String filepath1 = "./src/test/resources/file301.yml";
        final String filepath2 = "./src/test/resources/file302.yml";

        assertEquals(expected, Differ.generate(filepath1, filepath2, "stylish"));
    }

///
    @Test

    public void appTestJson() throws Exception {

        final String filepath1 = "./src/test/resources/file1.json";
        final String filepath2 = "./src/test/resources/file2.json";

        assertEquals(trueJsonResult, Differ.generate(filepath1, filepath2));
    }

    @Test
    public void appTestJsonEmptyFile() throws Exception {

        String result = """
                {
                  - follow: false
                  - host: hexlet.io
                  - proxy: 123.234.53.22
                  - timeout: 150
                }""";

        final String filepath1 = "./src/test/resources/file1.json";
        final String filepath2 = "./src/test/resources/empty.json";

        assertEquals(result, Differ.generate(filepath1, filepath2));
    }
    @Test
    public void appTestYaml() throws Exception {

        final String filepath1 = "./src/test/resources/file11.yml";
        final String filepath2 = "./src/test/resources/file12.yml";

        String trueYamlResult = """
                {
                  - follow: next
                  - host: hexlet.io
                  + host: hexlet.io 2
                  - proxy: 999.999.99.99
                  - timeout: 255
                  + timeout: 20
                  + verbose: true
                }""";

        assertEquals(trueYamlResult, Differ.generate(filepath1, filepath2));
    }
    @Test
    public void appTestYamlEmptyFile() throws Exception {

        String result = """
                {
                  - follow: next
                  - host: hexlet.io
                  - proxy: 999.999.99.99
                  - timeout: 255
                }""";

        final String filepath1 = "./src/test/resources/file11.yml";
        final String filepath2 = "./src/test/resources/empty.yml";

        assertEquals(result, Differ.generate(filepath1, filepath2));
    }

    @Test
    public void appTestJsonStructured() throws Exception {

        final String filepath1 = "./src/test/resources/file31.yml";
        final String filepath2 = "./src/test/resources/file32.yml";
        String result = """
            {
                chars1: [a, b, c]
              - chars2: [d, e, f]
              + chars2: false
              - checked: false
              + checked: true
              - default: null
              + default: [value1, value2]
              - id: 45
              + id: null
              - key1: value1
              + key2: value2
                numbers1: [1, 2, 3, 4]
              - numbers2: [2, 3, 4, 5]
              + numbers2: [22, 33, 44, 55]
              - numbers3: [3, 4, 5]
              + numbers4: [4, 5, 6]
              + obj1: {nestedKey=value, isNested=true}
              - setting1: Some value
              + setting1: Another value
              - setting2: 200
              + setting2: 300
              - setting3: true
              + setting3: none
            }""";

        assertEquals(result, Differ.generate(filepath1, filepath2));
    }

    @Test
    public void appTestPlain() throws Exception {

        String result = """
                Property 'chars2' was updated. From [complex value] to false
                Property 'checked' was updated. From false to true
                Property 'default' was updated. From null to [complex value]
                Property 'id' was updated. From 45 to null
                Property 'key1' was removed
                Property 'key2' was added with value: 'value2'
                Property 'numbers2' was updated. From [complex value] to [complex value]
                Property 'numbers3' was removed
                Property 'numbers4' was added with value: [complex value]
                Property 'obj1' was added with value: [complex value]
                Property 'setting1' was updated. From 'Some value' to 'Another value'
                Property 'setting2' was updated. From 200 to 300
                Property 'setting3' was updated. From true to 'none'""";

        final String filepath1 = "./src/test/resources/file31.yml";
        final String filepath2 = "./src/test/resources/file32.yml";

        assertEquals(result, Differ.generate(filepath1, filepath2, "plain"));
    }

    @Test
    public void appTestJsonFormate() throws Exception {

        String result = """
[{"key":"chars1","status":"constant","oldValue":["a","b","c"],"newValue":""},""" + """
{"key":"chars2","status":"updated","oldValue":["d","e","f"],"newValue":false},""" + """
{"key":"checked","status":"updated","oldValue":false,"newValue":true},""" + """
{"key":"default","status":"updated","oldValue":null,"newValue":["value1","value2"]},""" + """
{"key":"id","status":"updated","oldValue":45,"newValue":null},""" + """
{"key":"key1","status":"removed","oldValue":"value1","newValue":""},""" + """
{"key":"key2","status":"added","oldValue":"","newValue":"value2"},""" + """
{"key":"numbers1","status":"constant","oldValue":[1,2,3,4],"newValue":""},""" + """
{"key":"numbers2","status":"updated","oldValue":[2,3,4,5],"newValue":[22,33,44,55]},""" + """
{"key":"numbers3","status":"removed","oldValue":[3,4,5],"newValue":""},""" + """
{"key":"numbers4","status":"added","oldValue":"","newValue":[4,5,6]},""" + """
{"key":"obj1","status":"added","oldValue":"","newValue":{"nestedKey":"value","isNested":true}},""" + """
{"key":"setting1","status":"updated","oldValue":"Some value","newValue":"Another value"},""" + """
{"key":"setting2","status":"updated","oldValue":200,"newValue":300},""" + """
{"key":"setting3","status":"updated","oldValue":true,"newValue":"none"}]""";

        final String filepath1 = "./src/test/resources/file31.yml";
        final String filepath2 = "./src/test/resources/file32.yml";

        assertEquals(result, Differ.generate(filepath1, filepath2, "json"));
    }
}
