package hexlet.code;

import org.junit.jupiter.api.Test;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AppTest {

    private final Path pathPlain = Paths.get("./src/test/resources/resultPlain.txt").toAbsolutePath().normalize();
    private final Path pathStylish = Paths.get("./src/test/resources/resultStylish.txt").toAbsolutePath().normalize();
    private final Path pathJson = Paths.get("./src/test/resources/resultJson.txt").toAbsolutePath().normalize();

    private final String filepath1 = "./src/test/resources/file1.json";
    private final String filepath2 = "./src/test/resources/file2.json";

    private final String filepathYml1 = "./src/test/resources/file31.yml";
    private final String filepathYml2 = "./src/test/resources/file32.yml";



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
