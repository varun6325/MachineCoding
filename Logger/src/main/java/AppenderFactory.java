public class AppenderFactory {
    static Appender createAppender(String appenderType, String name){
        if(appenderType.equals("ConsoleAppender"))
            return new ConsoleAppender(name);
        return null;
    }
}
