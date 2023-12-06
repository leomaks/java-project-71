package hexlet.code;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AppTest {

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
                Property 'setting3' was updated. From true to 'none'
                """;

        final String filepath1 = "./src/test/resources/file31.yml";
        final String filepath2 = "./src/test/resources/file32.yml";

        assertEquals(result, Differ.generate(filepath1, filepath2, "plain"));
    }
}
