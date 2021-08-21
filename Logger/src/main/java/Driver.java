public class Driver {
    public static void main(String[] args) {
        LoggerService loggerService = LoggerService.getInstance();

        Logger logger1 = loggerService.createLooger(Driver.class, LogLevel.DEBUG, Configuration.LogRotationMode.NONEED, null, "ConsoleAppender", "");
        Logger logger2 = loggerService.createLooger(Driver.class, LogLevel.DEBUG, Configuration.LogRotationMode.NONEED, new SizeBasedRotationStrategy(100), "ConsoleAppender", "");
        System.out.println(logger1);
        System.out.println(logger2);


        Logger logger3 = loggerService.createLooger(Dummy.class, LogLevel.DEBUG, Configuration.LogRotationMode.ATEVERYUPDATE, new TimeBasedRotationStrategy(10000), "ConsoleAppender", "fileName");
        logger3.log("Debug Log", LogLevel.DEBUG);
        logger3.log("INFO Log", LogLevel.INFO);
        logger3.log("ERROr Log", LogLevel.ERROR);

        try {
            Thread.sleep(12000);
        }catch(InterruptedException ex){

        }

        logger3.log("Warning Log", LogLevel.WARNING);


    }

}
