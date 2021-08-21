public interface Appender {
    void log(String message);
    int getCurrentSize();
    long getRunningTime();
}
