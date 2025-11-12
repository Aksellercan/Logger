public class LoggerSettings {
    /**
     * Sets log path
     */
    private static String log_path = "logs";
    /**
     * Outputs DEBUG severity logs to console
     */
    private static boolean debugOutput = false;
    /**
     * Writes DEBUG severity logs to logfile
     */
    private static boolean verboseLogFile = false;
    /**
     * Colour codes logs
     */
    private static boolean colouredOutput = false;
    /**
     * Prints out detailed Exceptions in console and writes it to logfile
     */
    private static boolean enableStackTraces = false;
    /**
     * Disables all logging except Exceptions. Can be bypassed with force boolean
     */
    private static boolean quiet = false;

    public static String getLog_path() {
        return log_path;
    }

    public static void setLog_path(String log_path) {
        LoggerSettings.log_path = log_path;
    }

    public static boolean isDebugOutput() {
        return debugOutput;
    }

    public static void setDebugOutput(boolean debugOutput) {
        LoggerSettings.debugOutput = debugOutput;
    }

    public static boolean isVerboseLogFile() {
        return verboseLogFile;
    }

    public static void setVerboseLogFile(boolean verboseLogFile) {
        LoggerSettings.verboseLogFile = verboseLogFile;
    }

    public static boolean isColouredOutput() {
        return colouredOutput;
    }

    public static void setColouredOutput(boolean colouredOutput) {
        LoggerSettings.colouredOutput = colouredOutput;
    }

    public static boolean isEnableStackTraces() {
        return enableStackTraces;
    }

    public static void setEnableStackTraces(boolean enableStackTraces) {
        LoggerSettings.enableStackTraces = enableStackTraces;
    }

    public static boolean isQuiet() {
        return quiet;
    }

    public static void setQuiet(boolean quiet) {
        LoggerSettings.quiet = quiet;
    }
}
