public enum Logger implements LoggerInterface {
    INFO(" [ INFO ] "),
    WARN(" [ WARN ] "),
    ERROR(" [ ERROR ] "),
    DEBUG(" [ DEBUG ] "),
    CRITICAL(" [ CRITICAL ] "),
    THREAD_INFO(" [ THREAD: INFO ] "),
    THREAD_DEBUG(" [ THREAD: DEBUG ] "),
    THREAD_WARN(" [ THREAD: WARN ] "),
    THREAD_ERROR(" [ THREAD: ERROR ] "),
    THREAD_CRITICAL(" [ THREAD: CRITICAL ] "),
    ;

    /**
     * Severity level of a log
     */
    private final String severity;

    Logger(String severity) {
        this.severity = severity;
    }

    @Override
    public void log(String message) {
        logQueue.add(new Log(0,
                this,
                severity,
                message));
    }

    @Override
    public void log(String message, boolean writeToFile) {
        logQueue.add(new Log(
                (long) logQueue.size()+1,
                this,severity,
                message,
                writeToFile));
    }

    @Override
    public void log(String message, boolean writeToFile, boolean force) {
        logQueue.add(new Log((long) logQueue.size()+1,
                this,
                severity,
                message,
                writeToFile,
                force));
    }

    @Override
    public void logIfTrue(boolean statement) {
        if (statement) logQueue.add(new Log((long) logQueue.size()+1,
                this,
                severity,
                String.format("Statement is %s", statement)));
    }

    @Override
    public void logIfTrue(String message, boolean statement) {
        if (statement) logQueue.add(new Log((long) logQueue.size()+1,
                this,
                severity,
                String.format("%s is %s", message, statement)));
    }

    @Override
    public void logIfTrue(boolean statement, boolean writeToFile, boolean force) {
        if (statement) logQueue.add(new Log((long) logQueue.size()+1,
                this,
                severity,
                String.format("Statement is %s", statement),
                writeToFile,
                force));
    }

    @Override
    public void logIfTrue(String message, boolean statement, boolean writeToFile, boolean force) {
        if (statement) logQueue.add(new Log((long) logQueue.size()+1,
                this,
                severity,
                message,
                writeToFile,
                force));
    }

    @Override
    public void logThread(Thread thread, String message) {
        logQueue.add(new LogThread((long) logQueue.size()+1,
                thread,
                this,
                severity,
                message));
    }

    @Override
    public void logThread(Thread thread, String message, boolean writeToFile) {
        logQueue.add(new LogThread((long) logQueue.size()+1,
                thread,
                this,
                severity,
                message,
                writeToFile));
    }

    @Override
    public void logThread(Thread thread, String message, boolean writeToFile, boolean force) {
        logQueue.add(new LogThread((long) logQueue.size()+1,
                thread,
                this,
                severity,
                message,
                writeToFile,
                force));
    }

    @Override
    public void logException(Exception e, String message) {
        logQueue.add(new LogException((long) logQueue.size()+1,
                e,
                this,
                severity,
                message));
    }

    @Override
    public void logException(Exception e, String message, boolean writeToFile) {
        logQueue.add(new LogException((long) logQueue.size()+1,
                e,
                this,
                severity,
                message,
                writeToFile));
    }

    @Override
    public void logException(Exception e) {
        logQueue.add(new LogException((long) logQueue.size()+1,
                e,
                this,
                severity));
    }

    @Override
    public void logException(Exception e, boolean writeToFile) {
        logQueue.add(new LogException((long) logQueue.size()+1,
                e,
                this,
                severity,
                writeToFile));
    }

    @Override
    public void logThreadException(Thread thread, Exception e) {
        logQueue.add(new LogException((long) logQueue.size()+1,
                thread,
                e,
                this,
                severity));
    }

    @Override
    public void logThreadException(Thread thread, Exception e, boolean writeToFile) {
        logQueue.add(new LogException((long) logQueue.size()+1,
                e,
                this,
                severity,
                writeToFile));
    }

    @Override
    public void logThreadException(Thread thread, Exception e, String message) {
        logQueue.add(new LogException((long) logQueue.size()+1,
                thread,
                e,
                this,
                severity,
                message));
    }

    @Override
    public void logThreadException(Thread thread, Exception e, String message, boolean writeToFile) {
        logQueue.add(new LogException((long) logQueue.size()+1,
                thread,
                e,
                this,
                severity,
                message,
                writeToFile));
    }

    @Override
    public void logSilently(String message) {
        Log log = new Log((long) logQueue.size()+1,
                this,
                severity,
                message,
                true);
        log.setSilent(true);
        logQueue.add(log);
    }

    @Override
    public void logExceptionSilently(Exception e, String message) {
        Log log = new LogException((long) logQueue.size()+1,
                e,
                this,
                severity,
                message,
                true);
        log.setSilent(true);
        logQueue.add(log);
    }
}
