package hexlet.code;
import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;

import java.io.File;
import java.math.BigInteger;
import java.nio.file.Files;
import java.security.MessageDigest;
import java.util.concurrent.Callable;



@CommandLine.Command(name = "gendiff",

        mixinStandardHelpOptions = true, version = "gendiff 1.1",
        description = "Compares two configuration files and shows a difference."
)


public class App implements Runnable {

    @Option(names = {"-V", "--version"}, versionHelp = true, description = "Print version information and exit.")
    boolean versionInfoRequested;

    @Option(names = {"-h", "--help"}, usageHelp = true, description = "Show this help message and exit.")
    boolean usageHelpRequested;

    @Option(names = { "-f", "--format" }, paramLabel = "format", description = "output format [default: stylish]")
    String format;
    @Parameters(paramLabel = "filepath1", description = "path to first file")
    File file1;
    @Parameters(paramLabel = "filepath2", description = "path to second file")
    File file2;


    public static void main(String[] args) {

        //String[] args = { "-f", "--file", "file1.txt", "file2.txt" };

        CommandLine commandLine = new CommandLine(new App());
        commandLine.parseArgs(args);

        if (commandLine.isUsageHelpRequested()) {
            commandLine.usage(System.out);
            return;
        } else if (commandLine.isVersionHelpRequested()) {
            commandLine.printVersionHelp(System.out);
            return;
        }

    }
    @Override
    public void run() {}
}