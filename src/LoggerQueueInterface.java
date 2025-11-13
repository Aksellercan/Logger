import java.util.concurrent.ConcurrentLinkedQueue;

public interface LoggerQueueInterface {
    //Queue
    ConcurrentLinkedQueue<LogObject> logQueue = new ConcurrentLinkedQueue<>();
}
