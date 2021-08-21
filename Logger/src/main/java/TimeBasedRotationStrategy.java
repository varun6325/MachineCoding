public class TimeBasedRotationStrategy implements LogRotationStrategy {
    long runningTimeThresholdInMillis;
    TimeBasedRotationStrategy(int runningTimeThresholdInMillis){
        this.runningTimeThresholdInMillis = runningTimeThresholdInMillis;
    }
    @Override
    public boolean doRotation(Appender appender) {
        if(appender != null && appender.getRunningTime() > runningTimeThresholdInMillis)
            return true;
        return false;
    }
}
