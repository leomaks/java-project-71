package hexlet.code;

import picocli.CommandLine;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;
import java.util.concurrent.Callable;

@CommandLine.Command(name = "gendiff", mixinStandardHelpOptions = true, version = "gendiff 1.1",
        description = "Compares two configuration files and shows a difference."
)


public class App implements Callable<Integer> {
    @Parameters(paramLabel = "filepath1", description = "path to first file")
    private static String file1;
    @Parameters(paramLabel = "filepath2", description = "path to second file")
    private static String file2;

    @Option(names = { "-f", "--format" }, defaultValue = "stylish", paramLabel = "format",
            description = "output format [default: stylish]")
    private String format;



    public static void main(String[] args) throws Exception {

        int exitCode = new CommandLine(new App()).execute(args);
        System.exit(exitCode);

    }

    @Override
    public final Integer call() throws Exception {

        String list = Differ.generate(file1, file2, format);
        System.out.println(list);

        return null;
    }
}
