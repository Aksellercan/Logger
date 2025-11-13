public interface LoggerFormatInterface {
    String DateSeverityFormat(LogObject log);
    void ColourOutput(LogObject log, String fullMessage);
}
