public class Main {
    public static void main(String[] args) {
        Thread loggerThread = new Thread(new LoggerBackend());
        loggerThread.setDaemon(true);
        loggerThread.start();
    }
}
