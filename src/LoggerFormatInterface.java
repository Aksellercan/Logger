public interface LoggerFormatInterface {
    String dateSeverityFormat(LogObject log);
    void colourOutput(LogObject log, String fullMessage);
}
