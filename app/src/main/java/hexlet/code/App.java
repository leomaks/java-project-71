package hexlet.code;

import picocli.CommandLine;
import picocli.CommandLine.Option;
//import picocli.CommandLine.Parameters;
import java.util.concurrent.Callable;

@CommandLine.Command(name = "gendiff",

        mixinStandardHelpOptions = true, version = "gendiff 1.1",
        description = "Compares two configuration files and shows a difference."
)


public class App implements Callable<Integer> {

    @Option(names = {"-V", "--version"}, versionHelp = true, description = "Print version information and exit.")
     boolean versionInfoRequested;

    @Option(names = {"-h", "--help"}, usageHelp = true, description = "Show this help message and exit.")
    private boolean usageHelpRequested;

    @Option(names = { "-f", "--format" }, defaultValue = "stylish", paramLabel = "format",
            description = "output format [default: stylish]")
    private String format;


  /*  @Parameters(paramLabel = "filepath1", description = "path to first file")
    private static String file1; // = "file1.json";
    @Parameters(paramLabel = "filepath2", description = "path to second file")
    private static String file2; //  = "file2.json";



   */
    public static void main(String[] args) throws Exception {

        int exitCode = new CommandLine(new App()).execute(args);
        System.exit(exitCode);

    }

    @Override
    public final Integer call() throws Exception {

        String file1 = "app/src/test/resources/file31.yml";
        String file2 = "app/src/test/resources/file32.yml";
        String list = Differ.generate(file1, file2, format);
        System.out.println(list);
        return null;
    }
}
