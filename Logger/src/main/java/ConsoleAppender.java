public class ConsoleAppender implements Appender {
    long startTime;
    String fileName;
    public ConsoleAppender(String fileName) {
        this.fileName = fileName;
        startTime = System.currentTimeMillis();
    }

    public void log(String message) {
        System.out.println(fileName + " " + message);
    }

    public int getCurrentSize() {
        return 0;
    }
    public long getRunningTime(){
        return System.currentTimeMillis() - startTime;
    }

    @Override
    public String toString() {
        return "ConsoleAppender{" +
                "startTime=" + startTime +
                '}';
    }
}
