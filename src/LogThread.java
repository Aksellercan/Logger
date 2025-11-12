public class LogThread extends Log {
    private Thread thread;

    // Threads
    public LogThread(long id, Thread thread, Logger severityEnum, String severity, String message) {
        super(id, severityEnum, severity, message);
        this.thread = thread;
        this.severity = setThreadSeverity();
    }
    public LogThread(long id, Thread thread, Logger severityEnum, String severity, String message, boolean writeToFile) {
        super(id, severityEnum, severity, message, writeToFile);
        this.thread = thread;
        this.severity = setThreadSeverity();
    }
    public LogThread(long id, Thread thread, Logger severityEnum, String severity, String message, boolean writeToFile, boolean force) {
        super(id, severityEnum, severity, message, writeToFile, force);
        this.thread = thread;
        this.severity = setThreadSeverity();
    }

    public Thread getThread() {
        return thread;
    }

    public void setThread(Thread thread) {
        this.thread = thread;
    }

    public String setThreadSeverity() {
        StringBuilder sb = new StringBuilder();
        boolean add = false;
        for (int i = 0; i < this.getSeverity().length(); i++) {
            if (add) {
                sb.append(this.getSeverity().charAt(i));
                continue;
            }
            if (this.getSeverity().charAt(i) == ':') {
                add = true;
            }
        }
        String threadName;
        if (this.getThread() != null)
            threadName = this.getThread().getName();
        else
            threadName = "lost-thread";
        return String.format(" [ %s:%s", threadName, sb);
    }
}
