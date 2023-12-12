package hexlet.code;

import org.junit.jupiter.api.Test;

import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AppTest {

    private final Path pathPlain = Parser.getPath("./src/test/resources/testPlain.txt");
    private final Path pathStylish = Parser.getPath("./src/test/resources/resultStylish.txt");
    private final Path pathJson = Parser.getPath("./src/test/resources/resultJson.txt");

    private final String filepath1 = "./src/test/resources/file1.json";
    private final String filepath2 = "./src/test/resources/file2.json";

    private final String filepathYml1 = "./src/test/resources/file31.yml";
    private final String filepathYml2 = "./src/test/resources/file32.yml";

    public AppTest() throws Exception {
    }


    @Test
    public void appTestJsonStylish() throws Exception {

        String expected = Files.readString(pathStylish);
        assertEquals(expected, Differ.generate(filepath1, filepath2, "stylish"));

    }


    @Test
    public void appTestJsonDefault() throws Exception {

        String expected = Files.readString(pathStylish);
        assertEquals(expected, Differ.generate(filepath1, filepath2));

    }

    @Test
    public void appTestJsonPlain() throws Exception {

        String expected = Files.readString(pathPlain);
        assertEquals(expected, Differ.generate(filepath1, filepath2, "plain"));

    }


    @Test
    public void appTestJsonJson() throws Exception {

        String expected = Files.readString(pathJson);
        assertEquals(expected, Differ.generate(filepath1, filepath2, "json"));

    }


    @Test
    public void appTestYmlStylish() throws Exception {

        String expected = Files.readString(pathStylish);
        assertEquals(expected, Differ.generate(filepathYml1, filepathYml2, "stylish"));
    }


    @Test
    public void appTestYmlDefault() throws Exception {

        String expected = Files.readString(pathStylish);
        assertEquals(expected, Differ.generate(filepathYml1, filepathYml2));

    }

    @Test
    public void appTestYmlPlain() throws Exception {

        String expected = Files.readString(pathPlain);
        assertEquals(expected, Differ.generate(filepathYml1, filepathYml2, "plain"));

    }


    @Test
    public void appTestYmlJson() throws Exception {

        String expected = Files.readString(pathJson);
        assertEquals(expected, Differ.generate(filepathYml1, filepathYml2, "json"));

    }

}
