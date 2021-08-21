import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Logger {
    Appender appender;
    Configuration configuration;
    int counter = 1;
    public Logger(Configuration configuration) {
//        Date date = Calendar.getInstance().getTime();
//        DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");
//        String strDate = dateFormat.format(date);

        this.appender = AppenderFactory.createAppender(configuration.getTypeOfAppender(), configuration.getFileName()+"-" +counter);
        counter++;
        this.configuration = configuration;
    }

    @Override
    public String toString() {
        return "Logger{" +
                "appender=" + appender +
                ", configuration=" + configuration +
                '}';
    }

    public Appender getAppender() {
        return appender;
    }

    public void setAppender(Appender appender) {
        this.appender = appender;
    }

    public Configuration getConfiguration() {
        return configuration;
    }

    public void setConfiguration(Configuration configuration) {
        this.configuration = configuration;
    }

    void log(String message, LogLevel logLevel){
        if(logLevel.ordinal() < configuration.getMinimumLogLevel().ordinal() ) {
            System.out.println("Minimum log level is : " + configuration.getMinimumLogLevel());
            return;
        }
        if(configuration.getLogRotationMode() == Configuration.LogRotationMode.ATEVERYUPDATE && configuration.getLogRotationStrategy() != null && configuration.getLogRotationStrategy().doRotation(appender)){
//            Date date = Calendar.getInstance().getTime();
//            DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");
//            String strDate = dateFormat.format(date);
            this.appender = AppenderFactory.createAppender(configuration.getTypeOfAppender(), configuration.getFileName()+"-"+counter);
            counter++;
        }
        appender.log(logLevel + " " + message);
    }
}
