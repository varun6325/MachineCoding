import java.util.HashMap;
import java.util.Map;

public class LoggerService {
    private static LoggerService loggerService;
    private LoggerService(){}
    Map<Class, Logger> map = new HashMap<>();
    static LoggerService getInstance(){
        if(loggerService == null)
            loggerService = new LoggerService();
        return loggerService;
    }
    public Logger createLooger(Class level,LogLevel minLoggingLevel, Configuration.LogRotationMode logRotationMode, LogRotationStrategy logRotationStrategy, String typeOfAppender, String fileName){
        if(map.containsKey(level)) {
            System.out.println("Logger already exists for this class");
            return map.get(level);
        }
        Configuration configuration = new Configuration(logRotationMode, minLoggingLevel, typeOfAppender, logRotationStrategy);
        configuration.setFileName(fileName);
        Logger logger = new Logger(configuration);
        map.put(level, logger);
        return logger;
    }
    public Logger getLogger(Class level){
        return map.getOrDefault(level, null);
    }

}
