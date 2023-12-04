package hexlet.code;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AppTest {

    private final String trueJsonResult = "- follow: false\n"
            + "- host: hexlet.io\n"
            + "+ host: hexlet.io 2\n"
            + "- proxy: 123.234.53.22\n"
            + "- timeout: 150\n"
            + "+ timeout: 20\n"
            + "+ verbose: true";

    @Test
    public void appTest() throws Exception {

        final String filepath1 = "./src/test/resources/file1.json";
        final String filepath2 = "./src/test/resources/file2.json";

        assertEquals(trueJsonResult, Differ.generate(filepath1, filepath2));
    }
}
