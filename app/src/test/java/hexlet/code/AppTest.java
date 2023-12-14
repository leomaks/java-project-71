package hexlet.code;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.IOException;
import java.nio.file.Files;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AppTest {

    private static String expectedStylish;
    private static String expectedPlain;
    private static String expectedJson;

    private final String file1 = "./src/test/resources/file1.";
    private final String file2 = "./src/test/resources/file2.";


    @BeforeAll
    public static void beforeAll() throws IOException {
        expectedStylish = Files.readString(Differ.getPath("./src/test/resources/resultStylish.txt"));
        expectedPlain = Files.readString(Differ.getPath("./src/test/resources/testPlain.txt"));
        expectedJson = Files.readString(Differ.getPath("./src/test/resources/testJson.txt"));
    }



    @ParameterizedTest
    @ValueSource(strings = { "json", "yml" })
    public final void appTestStylish(String ext) throws Exception {
        assertEquals(expectedStylish, Differ.generate(file1 + ext, file2 + ext, "stylish"));
    }

    @ParameterizedTest
    @ValueSource(strings = { "json", "yml" })
    public final void appTestDefault(String ext) throws Exception {
        assertEquals(expectedStylish, Differ.generate(file1 + ext, file2 + ext));
    }

    @ParameterizedTest
    @ValueSource(strings = { "json", "yml" })
    public final void appTestPlain(String ext) throws Exception {
        assertEquals(expectedPlain, Differ.generate(file1 + ext, file2 + ext, "plain"));
    }



    @ParameterizedTest
    @ValueSource(strings = { "json", "yml" })
    public final void appTestJson(String ext) throws Exception {
        assertEquals(expectedJson, Differ.generate(file1 + ext, file2 + ext, "json"));
    }

}
