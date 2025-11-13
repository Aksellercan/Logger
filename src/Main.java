import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

public class Main {
    public static void readConfigConcurrently() {
        Random rand = new Random();
        long id = rand.nextLong();
        Thread configReaderThread = new Thread(YAMLParser::ReadConfigAndMap);
        configReaderThread.setName(configReaderThread.getName() + "_config-reader_" + (id > 0 ? id : -1*id));
        configReaderThread.start();
    }

    public static void main(String[] args) throws IOException {
        long startTime = System.currentTimeMillis();
        System.out.printf("""
                Settings
                debug = %s
                colour = %s
                stacktrace = %s
                verbose = %s
                """, LoggerSettings.getDebugOutput(), LoggerSettings.getColouredOutput(), LoggerSettings.getEnableStackTraces(), LoggerSettings.getVerboseLogFile());
        Logger.INFO.Log("yet");
        Thread loggerThread = new Thread(new LoggerBackend());
        loggerThread.setDaemon(true);
        loggerThread.start();

        readConfigConcurrently();

        Logger.INFO.Log("hello");
        Logger.WARN.LogSilently("test");
        Logger.DEBUG.Log("To stop press ENTER...");
        long endTime = System.currentTimeMillis();
        System.out.println("Start time: " + startTime + ", End time: " + endTime + ". Total execution time: " + (endTime - startTime) + "ms");
        if ((char) new BufferedReader(new InputStreamReader(System.in)).read() == '\n') {
            Logger.INFO.LogIfTrue(LoggerSettings.getColouredOutput());
            LoggerSettings.setColouredOutput(false);
            Logger.THREAD_INFO.LogThread(Thread.currentThread(), "Exiting...", true);
        }
    }
}
