package hexlet.code;

import picocli.CommandLine;
import picocli.CommandLine.Option;

import java.util.concurrent.Callable;

@CommandLine.Command(name = "gendiff",

        mixinStandardHelpOptions = true, version = "gendiff 1.1",
        description = "Compares two configuration files and shows a difference."
)


public class App implements Callable<Integer> {

    @Option(names = {"-V", "--version"}, versionHelp = true, description = "Print version information and exit.")
    boolean versionInfoRequested;

    @Option(names = {"-h", "--help"}, usageHelp = true, description = "Show this help message and exit.")
    boolean usageHelpRequested;

    @Option(names = { "-f", "--format" }, paramLabel = "format", description = "output format [default: stylish]")
    String format;
   /* @Parameters(paramLabel = "filepath1", description = "path to first file")
    static String file1; // = "file1.json";
    @Parameters(paramLabel = "filepath2", description = "path to second file")
    static String file2; //  = "file2.json";

*/

    public static void main(String[] args) throws Exception {

        int exitCode = new CommandLine(new App()).execute(args);
        System.exit(exitCode);

    }

    @Override
    public Integer call() throws Exception {

        String file1 = "files/file11.yml";
        String file2 = "files/file12.yml";

        String list = Differ.generate(file1, file2);
        System.out.println(list);
        return null;
    }
}
