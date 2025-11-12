public interface LoggerInterface extends LoggerQueueInterface {
    //Logger methods
    void log(String message);
    void log(String message, boolean writeToFile);
    void log(String message, boolean writeToFile, boolean force);

    //Log if true
    void logIfTrue(boolean statement);
    void logIfTrue(String message, boolean statement);
    void logIfTrue(boolean statement, boolean writeToFile, boolean force);
    void logIfTrue(String message, boolean statement, boolean writeToFile, boolean force);

    //Log threads
    void logThread(Thread thread, String message);
    void logThread(Thread thread, String message, boolean writeToFile);
    void logThread(Thread thread, String message, boolean writeToFile, boolean force);

    //Log exceptions
    void logException(Exception e, String message);
    void logException(Exception e, String message, boolean writeToFile);
    void logException(Exception e);
    void logException(Exception e, boolean writeToFile);

    //Log exceptions in threads
    void logThreadException(Thread thread, Exception e);
    void logThreadException(Thread thread, Exception e, boolean writeToFile);
    void logThreadException(Thread thread, Exception e, String message);
    void logThreadException(Thread thread, Exception e, String message, boolean writeToFile);

    //Log silently
    void logSilently(String message);
    void logExceptionSilently(Exception e, String message);
}
