
public class Configuration {

    LogRotationMode logRotationMode;
    LogLevel minimumLogLevel;
    String typeOfAppender;
    String fileName;
    LogRotationStrategy logRotationStrategy;

    public LogRotationStrategy getLogRotationStrategy() {
        return logRotationStrategy;
    }

    public void setLogRotationStrategy(LogRotationStrategy logRotationStrategy) {
        this.logRotationStrategy = logRotationStrategy;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    static enum LogRotationMode{
        DAEMONTHREAD,
        ATEVERYUPDATE,
        NONEED
    }

    public LogRotationMode getLogRotationMode() {
        return logRotationMode;
    }

    public void setLogRotationMode(LogRotationMode logRotationMode) {
        this.logRotationMode = logRotationMode;
    }

    public LogLevel getMinimumLogLevel() {
        return minimumLogLevel;
    }

    public void setMinimumLogLevel(LogLevel minimumLogLevel) {
        this.minimumLogLevel = minimumLogLevel;
    }

    public Configuration(LogRotationMode logRotationMode, LogLevel minimumLogLevel, String typeOfAppender, LogRotationStrategy logRotationStrategy) {
        this.typeOfAppender = typeOfAppender;
        this.logRotationMode = logRotationMode;
        this.minimumLogLevel = minimumLogLevel;
        this.logRotationStrategy = logRotationStrategy;
    }

    public String getTypeOfAppender() {
        return typeOfAppender;
    }

    public void setTypeOfAppender(String typeOfAppender) {
        this.typeOfAppender = typeOfAppender;
    }

    @Override
    public String toString() {
        return "Configuration{" +
                "logRotationMode=" + logRotationMode +
                ", minimumLogLevel=" + minimumLogLevel +
                '}';
    }
}
