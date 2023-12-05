package hexlet.code;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AppTest {

    private final String trueJsonResult = "{\n- follow: false\n"
            + "- host: hexlet.io\n"
            + "+ host: hexlet.io 2\n"
            + "- proxy: 123.234.53.22\n"
            + "- timeout: 150\n"
            + "+ timeout: 20\n"
            + "+ verbose: true\n}";

    @Test
    public void appTestJson() throws Exception {

        final String filepath1 = "./src/test/resources/file1.json";
        final String filepath2 = "./src/test/resources/file2.json";

        assertEquals(trueJsonResult, Differ.generate(filepath1, filepath2));
    }
    @Test
    public void appTestJsonEmptyFile() throws Exception {

        String result = "{\n- follow: false\n"
                + "- host: hexlet.io\n"
                + "- proxy: 123.234.53.22\n"
                + "- timeout: 150\n}";

        final String filepath1 = "./src/test/resources/file1.json";
        final String filepath2 = "./src/test/resources/empty.json";

        assertEquals(result, Differ.generate(filepath1, filepath2));
    }
    @Test
    public void appTestYaml() throws Exception {

        final String filepath1 = "./src/test/resources/file11.yml";
        final String filepath2 = "./src/test/resources/file12.yml";

        String trueYamlResult = "{\n- follow: next\n"
                + "- host: hexlet.io\n"
                + "+ host: hexlet.io 2\n"
                + "- proxy: 999.999.99.99\n"
                + "- timeout: 255\n"
                + "+ timeout: 20\n"
                + "+ verbose: true\n}";

        assertEquals(trueYamlResult, Differ.generate(filepath1, filepath2));
    }
   // @Test
    public void appTestYamlEmptyFile() throws Exception {

        String result = "{\n- follow: false\n"
                + "- host: hexlet.io\n"
                + "- proxy: 123.234.53.22\n"
                + "- timeout: 150\n}";

        final String filepath1 = "./src/test/resources/file11.yml";
        final String filepath2 = "./src/test/resources/empty.yml";

        assertEquals(result, Differ.generate(filepath1, filepath2));
    }
}
